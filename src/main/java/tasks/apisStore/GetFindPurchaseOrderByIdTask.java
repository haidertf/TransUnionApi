package tasks.apisStore;

import interacciones.timer.CalculateExecutionTime;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Assert;
import utilidades.BaseTemplate;
import utilidades.encrypt.Encrypt;

import static utilidades.enums.EnumsEndPoints.FIND_PURCHASE_ORDER_BY_ID;
import static utilidades.enums.EnumsHeadersAutenticacion.*;
import static utilidades.enums.Timer.START_TIME;

public class GetFindPurchaseOrderByIdTask implements Task {

    BaseTemplate data = new BaseTemplate();

    public static GetFindPurchaseOrderByIdTask order() {
        return Tasks.instrumented(GetFindPurchaseOrderByIdTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long miliSegundosIniciales = System.currentTimeMillis();
        actor.remember(START_TIME.toString(), miliSegundosIniciales);
        actor.attemptsTo(
                Get.resource(String.format(FIND_PURCHASE_ORDER_BY_ID.toString(), data.obtenerDatos("id") )).
                        with(requestSpecification ->
                                requestSpecification.header(ACCEPT.getLlave(), ACCEPT.getValor()).
                                        contentType(ContentType.JSON)
                                        )
        );
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
        actor.attemptsTo(
                CalculateExecutionTime.serviceResponse()
        );
    }
}
