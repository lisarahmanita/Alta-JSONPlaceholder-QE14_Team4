package starter.stepdef.Albums;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Albums.AlbumsAPI;

public class DeleteAlbumsStepDef {
    @Steps
    AlbumsAPI albumsAPI;

    @Given("Delete albums with valid id {}")
    public void deleteAlbumsWithValidId(int id) {
        albumsAPI.deleteAlbumsValidParameter(id);
    }

    @When("Send request delete albums")
    public void sendRequestDeleteAlbums() {
        SerenityRest.when()
                .delete(AlbumsAPI.SINGLE_ALBUMS);
    }

    @Given("Delete albums with invalid id {}")
    public void deleteAlbumsWithInvalidId(String id) {
        albumsAPI.deleteAlbumsInvalidParameter(id);
    }
}
