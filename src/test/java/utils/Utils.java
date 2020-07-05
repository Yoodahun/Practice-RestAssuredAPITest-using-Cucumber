package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {

    public RequestSpecification requestSpecification() throws FileNotFoundException {

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));


       return new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();
    }

    public ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
}
