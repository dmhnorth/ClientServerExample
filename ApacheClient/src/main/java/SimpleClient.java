import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SimpleClient {

    private String localAddress = "http://localhost:4567";

    public static void main(String[] args) {
        SimpleClient simpleClient = new SimpleClient();

        simpleClient.launch();
    }

    private void launch() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        //Recreates the curl, or browser call
        HttpGet httpGet = new HttpGet(localAddress + "/hello");

        //Now do the request
        try {
            //collect the response (This is the only line that does anything remotely)
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
            //do something with response

            // 1. see if it connected worked by printing this to the log
            System.out.println(response.getStatusLine());

            // 2. use the response body to pull something out
            System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
