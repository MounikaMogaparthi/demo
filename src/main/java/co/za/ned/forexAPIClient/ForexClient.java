package co.za.ned.forexAPIClient;

import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.Date;

public class ForexClient {

    public static Double getCurrencyConversionRate(String from, String to) {
        String url = "https://currency-exchange.p.rapidapi.com/exchange?from=" + from + "&to=" + to + "&q=1";
        Client client = ClientBuilder.newClient();
        String conversionRate = client.target(url)
                .request(MediaType.APPLICATION_JSON).header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com").header("X-RapidAPI-Key", "55f651dc0dmshaee90e8ad5fdd74p1ae9a2jsn9eb0a60850de")
                .get(String.class);
        if (conversionRate.isEmpty()) {
            return null;
        }
        return Double.parseDouble(conversionRate);
    }
}
