package starter.stepdef.Posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Posts.PostsAPI;
import starter.utils.Constants;

import java.io.File;

public class CreatePostsStepDef {

    @Steps
    PostsAPI postsAPI;


    @Given("Create posts with valid json {}")
    public void createPostsWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_POSTS + json);
        postsAPI.postCreatePosts(jsonFile);
    }

    @When("Send request create posts")
    public void sendRequestCreatePosts() {
        SerenityRest.when().post(PostsAPI.POSTS);
    }

    @Given("Create posts with invalid json {}")
    public void createPostsWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_POSTS + json);
        postsAPI.postCreatePosts(jsonFile);
    }
}
