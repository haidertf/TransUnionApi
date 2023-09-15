package stepsDefinition;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import utilidades.BaseTemplate;
import utilidades.BeforeHook;
import utilidades.SeleniumFunctions;

import java.io.IOException;


public class GlobalDefinitions {
    Response response;
    BaseTemplate Data = new BaseTemplate();
    SeleniumFunctions functions = new SeleniumFunctions();

    @Given("^Se ingresa a la url de la api (.*)$")
    public void consumesOfServices(String urlBase) throws IOException {
        functions.retrieveTestData(urlBase);
        BeforeHook.prepareStage(functions.getScenarioData(urlBase));
        System.out.println(urlBase);
    }

//    @Then("^Validates the last response with the signature related in the path: (.*)$")
//    public void validateSignature(String pathFile) {
//        response = SerenityRest.lastResponse();
//        response.then().assertThat().body(
//                JsonSchemaValidator.matchesJsonSchema(
//                        new File(JSON_FILES_DIR.getText().concat(pathFile))));
//    }
//
//    @Then("^displays the web component (.*) country (.*)$")
//    public void useAccountAssociation(String webComponent, String country) {
//        Data.guardarDatos("phoneNumber", String.valueOf(country));
//        theActorInTheSpotlight().attemptsTo(LoginToThePortal.useTheWebComponent(webComponent));
//
//
//    }
//
//    @And("^That Luis use the service of (.*)$")
//    public void useTheUrl(String urlBase) throws IOException {
//        functions.retrieveTestData(urlBase);
//        BeforeHook.prepareStage(functions.getScenarioData(urlBase));
//        System.out.println(urlBase);
//    }
}


