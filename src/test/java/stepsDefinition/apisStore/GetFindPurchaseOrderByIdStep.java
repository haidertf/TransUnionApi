package stepsDefinition.apisStore;

import cucumber.api.java.en.When;
import tasks.apisStore.GetFindPurchaseOrderByIdTask;
import utilidades.BaseTemplate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetFindPurchaseOrderByIdStep {

    BaseTemplate Data = new BaseTemplate();

    @When("^Se ejecuta el api find purchase order by (.*)$")
    public void se_ejecuta_0el_api_find_purchase_order_by_id(String id) {
        Data.guardarDatos("id", String.valueOf(id));
        theActorInTheSpotlight().attemptsTo(GetFindPurchaseOrderByIdTask.order());
    }
}
