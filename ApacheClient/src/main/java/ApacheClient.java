import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ApacheClient {

    private String address = "http://localhost:4567";

    public static void main(String[] args) {
        ApacheClient apacheClient = new ApacheClient();

        apacheClient.launch();
    }

    private void launch() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        //Recreates the curl, or browser call
        HttpGet httpGet = new HttpGet(address + "/hello");

        //Now do the request
        try {
            //collect the response
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
            //do something with response

            // 1. see if it worked by printing this
            System.out.println(response.getStatusLine());

            // 2. 


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
