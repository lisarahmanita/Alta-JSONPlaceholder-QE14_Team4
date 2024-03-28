package starter.stepdef.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.pdfbox.contentstream.operator.state.Concatenate;
import starter.jsonph.Todos.TodosAPI;
import starter.jsonph.Todos.TodosResponse;
import starter.utils.Constants;


import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class GetTodosStepDef {

    @Steps
    TodosAPI todosAPI;


    @Given("User todos with valid paramtere {}")
    public void userTodosWithValidParamtere(int id) {
        todosAPI.getUserTodos(id);

    }

    @When("Send request get user todos")
    public void sendRequestGetUserTodos() {
        SerenityRest.when().get(TodosAPI.SINGLE_TODOS);
    }

    @And("Response body should be {} and {}")
    public void responseBodyShouldBeAnd(int id, String title) {
        SerenityRest.and()
                .body(TodosResponse.ID,equalTo(id))
                .body(TodosResponse.TITLE,equalTo(title));
    }


    @And("Validate todos json schema {string}")
    public void validateTodosJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_TODOS+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("User totos with  invalid parameter {}")
    public void userTotosWithInvalidParameter(String id) {
        todosAPI.getUserTodosInvalid(id);
    }
}