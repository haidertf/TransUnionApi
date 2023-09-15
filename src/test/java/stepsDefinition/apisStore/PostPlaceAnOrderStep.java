package stepsDefinition.apisStore;

import cucumber.api.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import tasks.apisStore.PostPlaceAnOrderTask;

import java.io.File;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utilidades.enums.enumsRutasJson.RutasArchivosJson.JSON_FILES_DIR;

public class PostPlaceAnOrderStep {

    Response response;

    @When("^Se ejecuta el api post place an order$")
    public void se_ejecuta_el_api_post_place_an_order() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(PostPlaceAnOrderTask.order());
    }

    @When("^Se valida el esquema json path: (.*)$")
    public void se_valida_el_esquema_json_path(String pathFile) {
        response = SerenityRest.lastResponse();
        response.then().assertThat().body(
                JsonSchemaValidator.matchesJsonSchema(
                        new File(JSON_FILES_DIR.getText().concat(pathFile))));
    }
}
