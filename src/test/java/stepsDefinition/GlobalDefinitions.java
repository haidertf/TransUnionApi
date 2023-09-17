package stepsDefinition;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import utilidades.BaseTemplate;
import utilidades.BeforeHook;
import utilidades.SeleniumFunctions;

import java.io.IOException;


public class GlobalDefinitions {
    SeleniumFunctions functions = new SeleniumFunctions();

    @Given("^Se ingresa a la url de la api (.*)$")
    public void consumesOfServices(String urlBase) throws IOException {
        functions.retrieveTestData(urlBase);
        BeforeHook.prepareStage(functions.getScenarioData(urlBase));
        System.out.println(urlBase);
    }
}


