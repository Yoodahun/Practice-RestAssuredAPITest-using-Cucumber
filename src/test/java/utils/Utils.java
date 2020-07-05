package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public RequestSpecification requestSpecification()  {
        PrintStream log = null;

        try {
            log = new PrintStream(new FileOutputStream("logging.txt"));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new RequestSpecBuilder().setBaseUri(getGlobalValue("baseuri"))
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

    public String getGlobalValue(String key){
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
            prop.load(fis);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return  prop.getProperty(key);
    }
}
