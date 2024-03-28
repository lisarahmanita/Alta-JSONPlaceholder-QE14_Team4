package starter.stepdef.Albums;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Albums.AlbumsAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateAlbumsStepDef {
    @Steps
    AlbumsAPI albumsAPI;

    @Given("Update albums with valid id {} and valid json {string}")
    public void updateAlbumsWithValidIdAndValidJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_ALBUMS+json);
        albumsAPI.putUpdateAlbums(id, jsonFile);
    }

    @When("Send request update albums")
    public void sendRequestUpdateAlbums() {
        SerenityRest.when()
                .put(AlbumsAPI.SINGLE_ALBUMS);
    }

    @Given("Update albums with invalid id {} and valid json {string}")
    public void updateAlbumsWithInvalidIdAndValidJson(String id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_ALBUMS+json);
        albumsAPI.putUpdateInvalidAlbums(id, jsonFile);
    }


    @Given("Update albums with valid id {} and invalid json {string}")
    public void updateAlbumsWithValidIdAndInvalidJson(int id, String json) {
        File jsonFile = new File(Constants.REQ_BODY_ALBUMS+json);
        albumsAPI.putUpdateAlbums(id, jsonFile);
    }
}
