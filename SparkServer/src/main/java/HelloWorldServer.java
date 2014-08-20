import spark.Request;
import spark.Response;

import static spark.Spark.*;


/**
 * Spark defaults to port:4567
 *
 * type 'curl http://localhost:4567/hello' into terminal to test
 */
public class HelloWorldServer {
    private static Person person;

    public static void main(String[] args) {

        person = new Person("Ian James");

        get("/hello", (Request req, Response res) -> {
            return "You made a connection!";
        });
/*
        get("/person", (Request req, Response res) -> {
            return person;
        });
*/
    }
}