package starter.jsonph.Posts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostsAPI {
    public static String POSTS = Constants.BASE_URL+"/posts";
    public static String SINGLE_POSTS = Constants.BASE_URL+"/posts/{id}";



    @Step("Get user posts")
    public void getUserPosts(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get user invalid posts")
    public void getUserInvalidPosts(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete posts")
    public void deletePosts(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete invalid posts")
    public void deleteInvalidPosts(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Create new posts")
    public void postCreatePosts(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update posts")
    public void putUpdatePosts(int id,File json){
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Step("Update posts")
    public void putInvalidUpdatePosts(String id,File json){
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }
}

