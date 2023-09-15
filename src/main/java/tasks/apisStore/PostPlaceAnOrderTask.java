package tasks.apisStore;

import interacciones.timer.CalculateExecutionTime;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.junit.Assert;
import utilidades.encrypt.Encrypt;

import static utilidades.enums.EnumsEndPoints.PLACE_AN_ORDER;
import static utilidades.enums.EnumsHeadersAutenticacion.*;
import static utilidades.enums.Timer.START_TIME;

public class PostPlaceAnOrderTask implements Task {

    public static PostPlaceAnOrderTask order() {
        return Tasks.instrumented(PostPlaceAnOrderTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long miliSegundosIniciales = System.currentTimeMillis();
        actor.remember(START_TIME.toString(), miliSegundosIniciales);
        boolean value = true;
        actor.attemptsTo(
                Post.to(String.format(PLACE_AN_ORDER.toString())).
                        with(requestSpecification ->
                                requestSpecification.header(ACCEPT.getLlave(), ACCEPT.getValor()).
                                        contentType(ContentType.JSON).
                                        body("{" +
                                                '\"' + ID.getLlave() + '\"' + ":" + '\"' + Encrypt.decrypt(ID.getValor()) + '\"' + "," +
                                                '\"' + PET_ID.getLlave() + '\"' + ":" + '\"' + Encrypt.decrypt(PET_ID.getValor()) + '\"' + "," +
                                                '\"' + QUANTITY.getLlave() + '\"' + ":" + '\"' + Encrypt.decrypt(QUANTITY.getValor()) + '\"' + "," +
                                                '\"' + SHIP_DATE.getLlave() + '\"' + ":" + '\"' + SHIP_DATE.getValor() + '\"' + "," +
                                                '\"' + STATUS.getLlave() + '\"' + ":" + '\"' + STATUS.getValor() + '\"' + "," +
                                                '\"' + COMPLETE.getLlave() + '\"' + ":" + value +
                                                "}"
                                        ))
        );
        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());
        actor.attemptsTo(
                CalculateExecutionTime.serviceResponse()
        );
    }
}
