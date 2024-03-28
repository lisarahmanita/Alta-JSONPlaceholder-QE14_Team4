package starter.stepdef.Todos;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Todos.TodosAPI;

public class DeleteStepDef {


    @Steps
    TodosAPI todosAPI;
    @Given("Delete todos with valid parameter id {int}")
    public void deleteTodosWithValidParameterId(int id) {
        todosAPI.deleteTodosValid(id);

    }
    @Given("Delete todos with invalid parameter id {string}")
    public void deleteTodosWithInvalidParameterId(String id) {
        todosAPI.deleteTodosInvalid(id);
    }
}
