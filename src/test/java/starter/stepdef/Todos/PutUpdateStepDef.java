package starter.stepdef.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Todos.TodosAPI;
import starter.jsonph.Todos.TodosResponse;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PutUpdateStepDef {

    @Steps
    TodosAPI todosAPI;

    @Given("Update todos with valid json {string} and user userId {}")
    public void updateTodosWithValidJsonAndUserUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY_TODOS+json);
        todosAPI.putUpdateTodosValidJson(id, jsonFile);
    }
    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when()
                .put(TodosAPI.SINGLE_TODOS);
    }
    @And("Response body name should be {} and title is {string}")
    public void responseBodyNameShouldBeAndTitleIs(int userId, String title) {
        SerenityRest.and()
                .body(TodosResponse.USER_ID,equalTo(userId))
                .body(TodosResponse.TITLE,equalTo(title));
    }

    @Given("Update todos with invalid id {string} and valid json {string}")
    public void updateTodosWithInvalidIdAndValidJson(String id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_TODOS+json);
        todosAPI.putUpdateTodosInvalidId(id,jsonFile);
    }

    @When("Send request update todos")
    public void sendRequestUpdateTodos() {
        SerenityRest.when().put(TodosAPI.SINGLE_TODOS);
    }

    @Given("Update todos with valid id {} and invalid json {string}")
    public void updateTodosWithValidIdAndInvalidJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_TODOS+json);
        todosAPI.putUpdateTodosInvalidJson(id,jsonFile);
    }
}
