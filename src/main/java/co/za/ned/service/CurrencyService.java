package co.za.ned.service;

import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.forexAPIClient.ForexClient;
import co.za.ned.forexAPIClient.LatestExRateClient;
import co.za.ned.forexAPIClient.SymbolsClient;
import co.za.ned.model.Currency;
import co.za.ned.model.CurrencyDetail;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ManagedBean
public class CurrencyService {

    private LatestExRateClient latestExRateClient;
    @Inject
    private SymbolsClient symbolsClient;


    public static String getSymbols() {
        SymbolsClient symbolsClient = new SymbolsClient();
        return symbolsClient.symbols();
    }

    public  List<CurrencyDetail> getSymbols1() throws Exception{
       List<CurrencyDetail> currencies= symbolsClient.symbols1();
          return currencies;
    }

    //Latest Exchange Rate based on Euro
    public static String getLatestRate() {
        LatestExRateClient latestExRateClient = new LatestExRateClient();
        return latestExRateClient.latestExRate();

    }

    /*public static double getCurrencyConverted() {
        ForexClient forexClient = new ForexClient();
        return ForexClient.getCurrencyConversionRate("AED", "INR");
    }*/


    public static void main(String[] args) throws  Exception{
        /*getSymbols();
        getLatestRate();*/
        CurrencyService currencyService=new CurrencyService();
        currencyService.getSymbols1();

    }
}

