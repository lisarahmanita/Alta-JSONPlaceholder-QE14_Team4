package starter.jsonph.Todos;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class TodosAPI {

    public static String TODOS = Constants.BASE_URL+"/todos";
    public static String SINGLE_TODOS = Constants.BASE_URL+"/todos/{id}";




// Method Get
    @Step("Get user todos")
    public void getUserTodosValid(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get user todos")
    public void getUserTodosInvalid(String id){
        SerenityRest.given().pathParam("id", id);
    }


//    Method Delete
    @Step("Delete todos user")
    public void deleteTodosValid(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete todos user")
    public void deleteTodosInvalid(String id){
        SerenityRest.given().pathParam("id",id);
    }

//    Method Post
    @Step("Create new Todos")
    public void postCreateTodosValidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Create new Todos")
    public void postCreateTodosInvalidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

//    Method Put
    @Step("Update todos user")
    public void putUpdateTodosValidJson(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update todos invalid parameter")
    public void putUpdateTodosInvalidId(String id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update todos invalid json ")
    public void putUpdateTodosInvalidJson(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }






}
