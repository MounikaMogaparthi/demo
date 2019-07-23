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
    static String key = "f7cc00a4fba2890922749c2347dcd846";

    public static String symbols() {
        Client client = ClientBuilder.newClient();
        String run1 = client.target("http://data.fixer.io/api/symbols?access_key=" + key)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run1);
        return run1;
    }
}
