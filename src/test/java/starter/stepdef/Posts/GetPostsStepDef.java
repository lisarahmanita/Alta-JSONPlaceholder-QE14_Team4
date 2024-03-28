package starter.stepdef.Posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Posts.PostsAPI;
import starter.jsonph.Todos.TodosAPI;
import starter.utils.Constants;

import java.io.File;

public class GetPostsStepDef {

    @Steps
    PostsAPI postsAPI;

    @Given("Get posts with valid parameter Id {}")
    public void getPostsWithValidParameterId(int id) {
        postsAPI.getUserPosts(id);
    }

    @When("Send request get posts")
    public void sendRequestGetPosts() {
        SerenityRest.when().get(PostsAPI.SINGLE_POSTS);
    }

    @And("validate posts json {string}")
    public void validatePostsJson(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA_POSTS+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get posts with invalid parameter Id {}")
    public void getPostsWithInvalidParameterId(String id) {
        postsAPI.getUserInvalidPosts(id);
    }
}
