import spark.Request;
import spark.Response;

import static spark.Spark.*;


/**
 * Spark defaults to port:4567
 *
 * type 'curl http://localhost:4567/hello' into terminal to test
 */
public class HelloWorldServer {
    public static void main(String[] args) {

        get("/hello", (Request req, Response res) -> {
            return "Hello World";
        });

    }
}