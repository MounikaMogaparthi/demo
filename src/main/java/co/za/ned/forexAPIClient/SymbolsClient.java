package co.za.ned.forexAPIClient;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class SymbolsClient {
    static String key="f7cc00a4fba2890922749c2347dcd846";
    public static String symbols()
    {
        Client client = ClientBuilder.newClient();
        String run1 = client.target("http://data.fixer.io/api/symbols?access_key="+key)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run1);
        return run1;
    }
    /*public static String symbols()
    {
        Client client = ClientBuilder.newClient();
        Response2 run1 = client.target("https://restcountries.eu")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .method("GET",Response2.class);

        System.out.println(run1);
        Gson gs=new Gson();
        //Response cs = gs.fromJson(run1, Response.class);
        if(run1.getCurrencyList()==null)
        {  System.out.println("failed to parse");}
        for(co.za.ned.model.Currency c:run1.getCurrencyList())
        {
            System.out.println(c.getSymbol() );
        }
        return " test ";
    }
*/
    public static void main(String[] args) {
        symbols();
    }
}

/*
class Response
{
    boolean success;
    List<Currency> currencies;
    public Response(){}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
 class Currency{
    String symbol;
    String symbolName;

     public Currency() {
     }

     public Currency(String symbol, String symbolName) {
         this.symbol = symbol;
         this.symbolName = symbolName;
     }

     public String getSymbol() {
         return symbol;
     }

     public void setSymbol(String symbol) {
         this.symbol = symbol;
     }

     public String getSymbolName() {
         return symbolName;
     }

     public void setSymbolName(String symbolName) {
         this.symbolName = symbolName;
     }
 }*/
