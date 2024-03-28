package starter.stepdef.Albums;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.jsonph.Albums.AlbumsResponse;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponseStepDef {
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.and()
                .statusCode(statusCode);
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_ALBUMS+json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body id should {} and title should {string}")
    public void responseBodyIdShouldAndTitleShould(int id, String title) {
        SerenityRest.and()
                .body(AlbumsResponse.ID,equalTo(id))
                .body(AlbumsResponse.TITLE,equalTo(title));
    }

    @And("Response body userId should {} and title should {string}")
    public void responseBodyUserIdShouldAndTitleShould(int userId, String title) {
        SerenityRest.and()
                .body(AlbumsResponse.USER_ID,equalTo(userId))
                .body(AlbumsResponse.TITLE,equalTo(title));

    }
}
