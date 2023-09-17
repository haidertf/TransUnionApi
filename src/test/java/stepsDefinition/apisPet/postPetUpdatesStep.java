package stepsDefinition.apisPet;

import cucumber.api.java.en.When;
import tasks.apisPet.PostPetUpdatesTask;
import utilidades.BaseTemplate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class postPetUpdatesStep {

    BaseTemplate Data = new BaseTemplate();

    @When("^Se ejecuta el api updates a pet (.*) (.*) (.*)$")
    public void se_ejecuta_el_api_find_by_status(String id, String updatename, String updatesold) {
        Data.guardarDatos("id", String.valueOf(id));
        Data.guardarDatos("updatename", String.valueOf(updatename));
        Data.guardarDatos("updatesold", String.valueOf(updatesold));
        theActorInTheSpotlight().attemptsTo(PostPetUpdatesTask.withData());
    }
}
