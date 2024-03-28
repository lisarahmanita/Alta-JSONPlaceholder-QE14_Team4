package starter.stepdef.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Albums.AlbumsAPI;
import starter.jsonph.Albums.AlbumsResponse;
import starter.jsonph.Todos.TodosAPI;
import starter.jsonph.Todos.TodosResponse;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;


public class PostCreateTodosStepDef {

    @Steps
    TodosAPI todosAPI;

    @Given("Create new todos user with valid json {string}")
    public void createNewTodosUserWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_TODOS+json);
        todosAPI.postCreateTodosValidJson(jsonFile);
    }

    @When("Send request create new todos")
    public void sendRequestCreateNewTodos() {
        SerenityRest.when().post(TodosAPI.TODOS);
    }

    @And("Response body name should be {string}")
    public void responseBodyNameShouldBe(String title) {
        SerenityRest.and()
                .body(TodosResponse.TITLE,equalTo(title));
    }


    @Given("Create new todos user with invalid json {string}")
    public void createNewTodosUserWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_TODOS+json);
        todosAPI.postCreateTodosInvalidJson(jsonFile);
    }


}
