package co.za.ned.service;

import co.za.ned.customException.NegativeCurrencyException;
import co.za.ned.dao.CurrencyConversionDao;
import co.za.ned.dao.CurrencyDao;
import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.forexAPIClient.ForexClient;
import co.za.ned.model.Currency;
import co.za.ned.model.CurrencyConversion;
import co.za.ned.model.CurrencyList;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.net.ssl.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class CurrencyConversionService {

    CurrencyDao currencyDao = new CurrencyDao();

    CurrencyConversionDao currencyConversionDao=new CurrencyConversionDao();

    CurrencyConversion currencyConversion=new CurrencyConversion();

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
        //persist response quote in table
        // up or down if reqs from the same user > 5 to day 2% upto 1000$
        return responseQuote;
    }

    public CurrencyList getallCurrencies() {
        List<Currency> currencies = currencyDao.findAll();
        CurrencyList currencyList=new CurrencyList();
return currencyList;
    }

    private CurrencyConversion saveExchangeRate(String fromCurrency, String toCurrency, double currencyRate) {
        String code = fromCurrency.toUpperCase() + "-" + toCurrency.toUpperCase();
        return currencyConversionDao.update(new CurrencyConversion(code, currencyRate, new Timestamp(new Date().getTime())));
    }

 public static void main(String[] args) {
        RequestQuote q = new RequestQuote();
        q.setFromCurrency("ZAR");
        q.setToCurrency("inr");
        q.setSourceAmount(3500.0);
        ResponseQuote rq = new CurrencyConversionService().getCurrencyConversion(q);
        System.out.println(rq);
    }
}
