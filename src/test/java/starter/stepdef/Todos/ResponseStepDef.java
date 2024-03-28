package starter.stepdef.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.jsonph.Albums.AlbumsResponse;
import starter.jsonph.Todos.TodosResponse;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponseStepDef {

//  Status Code Todos
    @Then("Status code todos should be {int}")
    public void statusCodeTodosShouldBe(int statusCode) {
        SerenityRest.and().statusCode(statusCode);
    }

    @And("Validate todos json schema {string}")
    public void validateTodosJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_TODOS+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }






}
