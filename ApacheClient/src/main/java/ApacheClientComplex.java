import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.OutputStream;

//Second example doing something a bit more complex
public class ApacheClientComplex {

    private String localAddress = "http://localhost:4567";
    private OutputStream personStream;

            public static void main(String[] args) {
        ApacheClientComplex apacheClientComplex = new ApacheClientComplex();

        apacheClientComplex.launch();
    }

    private void launch() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();


        //Recreates the curl, or browser call
        HttpGet httpGet2 = new HttpGet(localAddress + "/person");

        //Now do the request
        try {
            //collect the response (This is the only line that does anything remotely)
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet2);
            //do something with response

            // 1. see if it connected worked by printing this to the log
            System.out.println(response.getStatusLine());

            // TODO figure out how to get a complex object via http/if its possible
            // 2. use the response body to pull something out
            Person person = (Person) response.getEntity();
            System.out.println(person.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
