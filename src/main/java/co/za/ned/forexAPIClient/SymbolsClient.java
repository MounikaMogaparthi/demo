package co.za.ned.forexAPIClient;

import co.za.ned.Interface.ICountries;
import co.za.ned.model.Country;
import co.za.ned.model.Currency;
import co.za.ned.model.CurrencyDetail;
import com.google.gson.Gson;
import feign.Feign;
import feign.gson.GsonDecoder;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class SymbolsClient {
    static String key = "f7cc00a4fba2890922749c2347dcd846";

    public static String symbols() {
        Client client = ClientBuilder.newClient();
        String run1 = client.target("http://data.fixer.io/api/symbols?access_key=" + key)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run1);
        return run1;
    }
    public static String symbols2() {
        Client client = ClientBuilder.newClient();
        String run2 = client.target("http://restcountries.eu/rest/v2/all")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run2);
        return run2;
    }

    public static List<CurrencyDetail> symbols1() throws Exception {
        List<CurrencyDetail> currenciesList = new ArrayList<>();
        ICountries list = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ICountries.class, "http://restcountries.eu");
        // Fetch and print a list of the currencies to this library.
        List<Country> currencies = list.getAll();
        System.out.println(currencies.size());
        for (Country country : currencies) {
            for (Currency curr : country.getCurrencies()) {
                if (curr.getCurrencyCode() == null || curr.getCurrencyName() == null) break;
                currenciesList.add(new CurrencyDetail(curr.getCurrencyCode(),curr.getCurrencyName()));
            }
        }
        return currenciesList;
    }
    public static void main(String[] args) throws  Exception{
        symbols1();
    }
}
