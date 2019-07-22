/*
package co.za.testRestClient;


import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.Date;

public  class RestClientMain{

    static String key="f7cc00a4fba2890922749c2347dcd846";
    public static void main(String[] args) {
       testRestEndPoint();
      //  symbols();
        RequestQuote requestQuote=new RequestQuote();
        requestQuote.setFromCurrency("ZAR");
        requestQuote.setToCurrency("INR");
        requestQuote.setTimestamp(new Timestamp(new Date().getTime()));
        requestQuote.setSourceAmount(122588.0);

        ResponseQuote responseQuote= new ResponseQuote();
        responseQuote.setSourceAmount(requestQuote.getSourceAmount());
        responseQuote.setFromCurrency(requestQuote.getFromCurrency());
        responseQuote.setToCurrency(requestQuote.getToCurrency());
        responseQuote.setTimestamp(requestQuote.getTimestamp());
        responseQuote.setConversionRate(currencyConversion(requestQuote.getFromCurrency(),requestQuote.getToCurrency()));
        responseQuote.setExchangedAmount(responseQuote.getConversionRate()*requestQuote.getSourceAmount());
       ///System.out.println(responseQuote);
        Gson gson= new Gson();
        String s=gson.toJson(responseQuote);

      //  System.out.println("\n \n "+s);

    }


    public static void testRestEndPoint()
    {
        Client client = ClientBuilder.newClient();
        String run = client.target("http://data.fixer.io/api/latest?access_key="+key)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run);
    }


    public static void symbols()
    {
        Client client = ClientBuilder.newClient();
        String run1 = client.target("http://data.fixer.io/api/symbols?access_key="+key)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run1);
    }

    public static double currencyConversion(String from,String to)
    {
        String url="https://currency-exchange.p.rapidapi.com/exchange?from="+from+"&to="+to+"&q=1";
        Client client = ClientBuilder.newClient();
        String conversionRate = client.target(url)
                .request(MediaType.APPLICATION_JSON).header("X-RapidAPI-Host","currency-exchange.p.rapidapi.com").header("X-RapidAPI-Key","55f651dc0dmshaee90e8ad5fdd74p1ae9a2jsn9eb0a60850de")
                .get(String.class);
      //  System.out.println(conversionRate);
        return Double.parseDouble(conversionRate);
    }
}
*/
