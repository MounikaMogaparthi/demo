package co.za.ned.service;

import co.za.ned.customException.NegativeCurrencyException;
import co.za.ned.dao.CurrencyConversionDao;
import co.za.ned.dao.CurrencyDao;
import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.forexAPIClient.ForexClient;
import co.za.ned.forexAPIClient.SymbolsClient;
import co.za.ned.model.*;
import co.za.ned.mapper.CurrencyMapper;


import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class CurrencyConversionService {
    private static final int EXCHANGE_RATE_OLDER_THAN = 900;
    @Inject
    CurrencyDao currencyDao;

    @Inject
    ForexClient forexClient;
    @Inject
    SymbolsClient symbolsClient;

    CurrencyConversionDao currencyConversionDao = new CurrencyConversionDao();

    CurrencyConversion currencyConversion = new CurrencyConversion();

    public ResponseQuote getCurrencyConversion(RequestQuote requestQuote) {
        if (requestQuote.getSourceAmount() < 0) {
            throw new NegativeCurrencyException("  " + String.valueOf(requestQuote.getSourceAmount()) + "  ");
        }
        Double conversionRate = ForexClient.getCurrencyConversionRate(requestQuote.getFromCurrency().toUpperCase(), requestQuote.getToCurrency().toUpperCase());
        if (conversionRate == null) {
            throw new RuntimeException("Service down, please try after some time");
        }
        ResponseQuote responseQuote = new ResponseQuote();
        responseQuote.setFromCurrency(requestQuote.getFromCurrency().toUpperCase());
        responseQuote.setToCurrency(requestQuote.getToCurrency().toUpperCase());
        responseQuote.setConversionRate(conversionRate);
        responseQuote.setSourceAmount(requestQuote.getSourceAmount());
        responseQuote.setExchangedAmount(conversionRate * requestQuote.getSourceAmount());
        responseQuote.setTimestamp(new Timestamp(new Date().getTime()));
        return responseQuote;
    }

    @Transactional
    public ResponseQuote convertCurrency(RequestQuote requestQuote) throws Exception {
        String pKey = requestQuote.getFromCurrency().toUpperCase() + "-" + requestQuote.getToCurrency().toUpperCase();
        CurrencyConversion currencyConversion = currencyConversionDao.find(pKey);
        if (mustFetchRate(currencyConversion)) {
            currencyConversion = fetchCurrencyConversion(requestQuote.getFromCurrency().toUpperCase(), requestQuote.getToCurrency().toUpperCase());
        }
        double convertedAmount = calculateConvertedAmount(requestQuote, currencyConversion);

        ResponseQuote responseQuote = new ResponseQuote(200, "Success", "Success",
                requestQuote.getFromCurrency().toUpperCase(), requestQuote.getToCurrency().toUpperCase(), requestQuote.getSourceAmount(),
                convertedAmount);
        return responseQuote;
    }

    private CurrencyConversion fetchCurrencyConversion(String fromCurrency, String toCurrency) throws Exception {
        double currencyRate = forexClient.getCurrencyConversionRate(fromCurrency, toCurrency);
        return saveExchangeRate(fromCurrency, toCurrency, currencyRate);
    }

    private CurrencyConversion saveExchangeRate(String fromCurrency, String toCurrency, double currencyRate) {
        String pKey = fromCurrency.toUpperCase() + "-" + toCurrency.toUpperCase();
        return currencyConversionDao.update(new CurrencyConversion(pKey, currencyRate, new Timestamp(new Date().getTime())));
    }


    private boolean mustFetchRate(CurrencyConversion currencyConversion) {
        return currencyConversion == null || exchangeRateIsOld(currencyConversion.getUpdatedDate(), EXCHANGE_RATE_OLDER_THAN);
    }

    private boolean exchangeRateIsOld(Timestamp date, int numberOfSeconds) {
        long milliseconds = System.currentTimeMillis() - date.getTime();
        int seconds = (int) milliseconds / 1000;
        System.out.println("Number of seconds old = " + seconds);
        return (seconds >= numberOfSeconds);
    }

    private double calculateConvertedAmount(RequestQuote requestQuote, CurrencyConversion currencyConversion) {
        return requestQuote.getSourceAmount() * currencyConversion.getConversionRate();
    }

    @Transactional
    public ResponseMessage saveCurrencyDetails() throws Exception {
        List<CurrencyDetail> currencyDetailList = symbolsClient.symbols1();
        List<Currency> currencyList = CurrencyMapper.mapRequest(currencyDetailList);
        for (Currency currency : currencyList) {
            System.out.println(currency.getCurrencyCode() + "<===>" + currency.getCurrencyName());
            currencyDao.update(currency);
        }
        return new ResponseMessage(200, "Success", "Successfully Saved");
    }

    public static void main(String[] args) throws Exception {
        RequestQuote q = new RequestQuote();
        q.setFromCurrency("ZAR");
        q.setToCurrency("inr");
        q.setSourceAmount(3500.0);
        ResponseQuote rq = new CurrencyConversionService().getCurrencyConversion(q);
        System.out.println(rq);
        System.out.println(new CurrencyConversionService().saveCurrencyDetails());

    }
}
