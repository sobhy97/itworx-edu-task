package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ActivityStepDefs {
    private Response response;

    @Given("I call the activity API")
    public void i_call_the_activity_api() {
        RequestSpecification request = RestAssured.given();
        response = request.get("https://www.boredapi.com/api/activity");
    }

    @Then("the response code should be 200")
    public void the_response_code_should_be_200() {
        response.then().statusCode(200);
    }

    @Then("the response schema should match the expected schema")
    public void the_response_schema_should_match_the_expected_schema() {
        String expectedSchema = "{" +
                "\"type\":\"object\"," +
                "\"properties\":{" +
                "\"activity\":{\"type\":\"string\"}," +
                "\"type\":{\"type\":\"string\"}," +
                "\"participants\":{\"type\":\"integer\"}," +
                "\"price\":{\"type\":\"number\"}," +
                "\"link\":{\"type\":\"string\"}," +
                "\"key\":{\"type\":\"string\"}," +
                "\"accessibility\":{\"type\":\"number\"}" +
                "}," +
                "\"required\":[\"activity\",\"type\",\"participants\",\"price\",\"link\",\"key\",\"accessibility\"]" +
                "}";
        response.then().body(matchesJsonSchema(expectedSchema));
    }
}
