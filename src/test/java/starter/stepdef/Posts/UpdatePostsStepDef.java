package starter.stepdef.Posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Posts.PostsAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdatePostsStepDef {

    @Steps
    PostsAPI postsAPI;
    @Given("Update posts with valid id {int} and valid json {string}")
    public void updatePostsWithValidIdAndValidJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_POSTS + json);
        postsAPI.putUpdatePosts(id,jsonFile);
    }

    @When("Send request update posts")
    public void sendRequestUpdatePosts() {
        SerenityRest.when().put(PostsAPI.SINGLE_POSTS);
    }

    @Given("Update posts with invalid id {} and invalid json {string}")
    public void updatePostsWithInvalidIdAndInvalidJson(String id, String json ) {
        File jsonFile = new File(Constants.REQ_BODY_POSTS + json);
        postsAPI.putInvalidUpdatePosts(id,jsonFile);
    }
}
