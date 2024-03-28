package starter.stepdef.Albums;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Albums.AlbumsAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateAlbumsStepDef {
    @Steps
    AlbumsAPI albumsAPI;
    @Given("Create albums with valid json {string}")
    public void createAlbumsWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_ALBUMS+json);
        albumsAPI.postCreateAlbums(jsonFile);
    }

    @When("Send request create new albums")
    public void sendRequestCreateNewAlbums() {
        SerenityRest.when()
                .post(AlbumsAPI.ALBUMS);
    }

    @Given("Create albums with invalid json {string}")
    public void createAlbumsWithInvalidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY_ALBUMS+json);
        albumsAPI.postCreateAlbums(jsonFile);
    }
}
