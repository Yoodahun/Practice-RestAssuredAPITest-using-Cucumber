package stepDefinitions;

import buildTestData.TestData;
import googleAPI.AddPlace;
import googleAPI.Location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import utils.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MyStepdefs extends Utils {

    RequestSpecification req;
    ResponseSpecification res;
    Response response;



    @Given("Add Place Payload")
    public void addPlacePayload() throws FileNotFoundException {

        req = requestSpecification();
        res = responseSpecification();

        req = given().log().all().spec(req).body(new TestData().serializationAddPlace());

    }

    @When("User calls {string} with Post http request")
    public void userCallsWithPostHttpRequest(String resourceURI) {
        response = req.when().post("/maps/api/place/add/json")
                .then().log().all()
                .assertThat().spec(res).extract().response();
    }

    @Then("the API call got success with statusCode {int}")
    public void theAPICallGotSuccessWithStatusCode(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String result) {
        Assert.assertEquals(response.getBody().jsonPath().getString(key), result);
    }

}
