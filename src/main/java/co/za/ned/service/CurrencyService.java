package co.za.ned.service;
import co.za.ned.forexAPIClient.LatestExRateClient;
import co.za.ned.forexAPIClient.SymbolsClient;


import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class CurrencyService {

    private LatestExRateClient latestExRateClient;
    @Inject
    private SymbolsClient symbolsClient;


    public static String getSymbols() {
        SymbolsClient symbolsClient = new SymbolsClient();
        return symbolsClient.symbols();
    }

    public static String getSymbols2() {
        SymbolsClient symbolsClient = new SymbolsClient();
        return symbolsClient.symbols2();

    }

    //Latest Exchange Rate based on Euro
    public static String getLatestRate() {
        LatestExRateClient latestExRateClient = new LatestExRateClient();
        return latestExRateClient.latestExRate();

    }


    public static void main(String[] args) throws Exception {
        CurrencyService currencyService = new CurrencyService();
        currencyService.getSymbols2();

    }
}

