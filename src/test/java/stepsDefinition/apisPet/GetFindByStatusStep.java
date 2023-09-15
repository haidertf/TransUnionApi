package stepsDefinition.apisPet;

import cucumber.api.java.en.When;
import tasks.apisPet.GetFindByStatusTask;
import tasks.apisStore.GetFindPurchaseOrderByIdTask;
import utilidades.BaseTemplate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetFindByStatusStep {

    BaseTemplate Data = new BaseTemplate();

    @When("^Se ejecuta el api find by status (.*)$")
    public void se_ejecuta_el_api_find_by_status(String status) {
        Data.guardarDatos("status", String.valueOf(status));
        theActorInTheSpotlight().attemptsTo(GetFindByStatusTask.status());
    }
}
