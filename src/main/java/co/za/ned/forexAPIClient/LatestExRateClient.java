package co.za.ned.forexAPIClient;

import javax.annotation.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class LatestExRateClient {
    static String key = "f7cc00a4fba2890922749c2347dcd846";

    //latest Exchane Rate based on Euro
    public static String latestExRate() {
        Client client = ClientBuilder.newClient();
        String run = client.target("http://data.fixer.io/api/latest?access_key=" + key)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(run);
        return run;
    }

}
