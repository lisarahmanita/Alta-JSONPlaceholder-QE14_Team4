package starter.jsonph.Todos;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class TodosAPI {

    public static String TODOS = Constants.BASE_URL+"/todos";
    public static String SINGLE_TODOS = Constants.BASE_URL+"/todos/{id}";






// Method Get
    @Step("Get user todos")
    public void getUserTodos(int id){
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



}
