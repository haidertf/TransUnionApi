package tasks.apisPet;

import interacciones.timer.CalculateExecutionTime;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.junit.Assert;
import tasks.apisStore.PostPlaceAnOrderTask;
import utilidades.BaseTemplate;

import java.util.Map;

import static utilidades.enums.EnumsEndPoints.UPDATES_A_PET;
import static utilidades.enums.EnumsHeadersAutenticacion.ACCEPT;
import static utilidades.enums.Timer.START_TIME;

public class PostPetUpdatesTask implements Task {

    BaseTemplate data = new BaseTemplate();

    public static PostPetUpdatesTask withData() {
        return Tasks.instrumented(PostPetUpdatesTask.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        long miliSegundosIniciales = System.currentTimeMillis();
        actor.remember(START_TIME.toString(), miliSegundosIniciales);

        actor.attemptsTo(
                Post.to(String.format(UPDATES_A_PET.toString(), data.obtenerDatos("id"))).
                        with(requestSpecification ->
                                requestSpecification.header(ACCEPT.getLlave(), ACCEPT.getValor()).
                                        contentType(ContentType.URLENC).
                                        formParam("name", String.format(data.obtenerDatos("name"))).
                                        formParam("status", String.format(data.obtenerDatos("status")))
                        )
        );
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
        actor.attemptsTo(
                CalculateExecutionTime.serviceResponse()
        );
    }
}
