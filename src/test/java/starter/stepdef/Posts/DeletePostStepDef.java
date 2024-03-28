package starter.stepdef.Posts;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Posts.PostsAPI;

public class DeletePostStepDef {
    @Steps
    PostsAPI postsAPI;
    @Given("Delete posts with valid parameter Id {}")
    public void deletePostsWithValidParameterId(int id) {
        postsAPI.deletePosts(id);
    }

    @Given("Delete posts with invalid parameter Id {}")
    public void deletePostsWithInvalidParameterId(String id) {
        postsAPI.deleteInvalidPosts(id);
    }
}
