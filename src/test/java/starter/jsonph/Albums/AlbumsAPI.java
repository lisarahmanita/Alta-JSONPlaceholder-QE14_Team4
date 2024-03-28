package starter.jsonph.Albums;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class AlbumsAPI {
    public static String ALBUMS = Constants.BASE_URL+"/albums";
    public static String SINGLE_ALBUMS = Constants.BASE_URL+"/albums/{id}";

    @Step("Get all albums")
    public void getAllAlbums(){
        SerenityRest.given()
                .get(ALBUMS);
    }
    @Step("Get albums with valid parameter id")
    public void getAlbumsValidParameter(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get albums with invalid parameter id")
    public void getAlbumsInvalidParameter(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Create new albums")
    public void postCreateAlbums(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update albums")
    public void putUpdateAlbums(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update invalid albums")
    public void putUpdateInvalidAlbums(String id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete albums with valid parameter id")
    public void deleteAlbumsValidParameter(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete albums with invalid parameter id")
    public void deleteAlbumsInvalidParameter(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
