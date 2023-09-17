package tasks.apisPet;

import interacciones.timer.CalculateExecutionTime;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Assert;
import utilidades.BaseTemplate;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static utilidades.EnumsMessage.REMEMBER_STATUS;
import static utilidades.enums.EnumsEndPoints.FIND_BY_STATUS;
import static utilidades.enums.EnumsHeadersAutenticacion.ACCEPT;
import static utilidades.enums.Timer.START_TIME;

public class GetFindByStatusTask implements Task {

    BaseTemplate data = new BaseTemplate();

    public static GetFindByStatusTask status() {
        return Tasks.instrumented(GetFindByStatusTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long miliSegundosIniciales = System.currentTimeMillis();
        actor.remember(START_TIME.toString(), miliSegundosIniciales);

        actor.attemptsTo(
                Get.resource(String.format(FIND_BY_STATUS.toString(), data.obtenerDatos("status"))).
                        with(requestSpecification ->
                                requestSpecification.header(ACCEPT.getLlave(), ACCEPT.getValor()).
                                        contentType(ContentType.JSON)
                        )
        );

        Response response = SerenityRest.lastResponse();
        JsonPath jsonPath = response.jsonPath();
        List<String> statusList = jsonPath.getList("status");
        // Convierte la lista de status en una cadena separada por comas
        String status = String.join(",", statusList);
        actor.remember(REMEMBER_STATUS.toString(), status);
        System.out.println("El status es: "+status);

        String[] statusArray = status.split(",");
        Set<String> uniqueStatusSet = new LinkedHashSet<>(Arrays.asList(statusArray));
        String[] uniqueStatusArray = uniqueStatusSet.toArray(new String[0]);
        String uniqueStatus = String.join(",", uniqueStatusArray);
        actor.remember(REMEMBER_STATUS.toString(), uniqueStatus);

        Assert.assertEquals(String.format(data.obtenerDatos("status")), uniqueStatus);

        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
        actor.attemptsTo(
                CalculateExecutionTime.serviceResponse()
        );
    }
}
