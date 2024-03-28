package starter.stepdef.Albums;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.jsonph.Albums.AlbumsAPI;

public class GetAlbumsStepDef {
    @Steps
    AlbumsAPI albumsAPI;

    @Given("Get all list albums with valid parameter")
    public void getAllListAlbumsWithValidParameter() {
        albumsAPI.getAllAlbums();
    }

    @When("Send request get list albums")
    public void sendRequestGetListAlbums() {
        SerenityRest.when()
                .get(AlbumsAPI.ALBUMS);
    }
    @Given("Get albums with valid parameter id {int}")
    public void getAlbumsWithValidParameterId(int id) {
        albumsAPI.getAlbumsValidParameter(id);
    }

    @When("Send request get single albums")
    public void sendRequestGetSingleAlbums() {
        SerenityRest.when()
                .get(AlbumsAPI.SINGLE_ALBUMS);
    }

    @Given("Get albums with invalid parameter id {}")
    public void getAlbumsWithInvalidParameterId(String id) {
        albumsAPI.getAlbumsInvalidParameter(id);
    }
}
