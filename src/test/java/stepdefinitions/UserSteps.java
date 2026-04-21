package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserSteps {

    private Response response;

    @Given("ejecuto el endpoint GET de usuario con id {int}")
    public void ejecuto_endpoint(int id) {

        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/users/" + id);
    }

    @Then("el status code debe ser {int}")
    public void validar_status(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("el campo name no debe ser null")
    public void validar_name() {
        response.then().body("name", notNullValue());
    }
}
