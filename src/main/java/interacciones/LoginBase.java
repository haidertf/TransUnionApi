package interacciones;
import co.com.identity_auto.certification.utilidades.BaseTemplate;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.junit.Assert;

import static co.com.identity_auto.certification.utilidades.enums.EnumsEndPoints.ENDPOINT_KEYS_PUBLIC_ACCESS;
import static co.com.identity_auto.certification.utilidades.enums.EnumsHeadersAutenticacion.*;
import static co.com.identity_auto.certification.utilidades.enums.EnumsHeadersAutenticacion.CREATION_CHANNEL_TYPE_PUBLIC;
import static co.com.identity_auto.certification.utilidades.enums.EnumsMessage.REMEMBER_ID_TOKEN;
import static co.com.identity_auto.certification.utilidades.enums.EnumsMessage.REMEMBER_UUID;

public class LoginBase implements Interaction {
    BaseTemplate data = new BaseTemplate();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String idToken = actor.recall(REMEMBER_ID_TOKEN.toString());
        String uuid = actor.recall(REMEMBER_UUID.toString());
        actor.attemptsTo(Post.to(String.format(ENDPOINT_KEYS_PUBLIC_ACCESS.toString(), uuid)).
                with(requestSpecification ->
                        requestSpecification.
                                header(AUTHORITY.getLlave(), AUTHORITY.getValor()).
                                header(ACCEPT.getLlave(), ACCEPT.getValor()).
                                header(ACCEPT_LANGUAGE_PUBLIC.getLlave(), ACCEPT_LANGUAGE_PUBLIC.getValor()).
                                header(AUTHORIZATION_ACCESS.getLlave(), AUTHORIZATION_ACCESS.getValor()+idToken).
                                header(CONTENT_TYPE_STG.getLlave(), CONTENT_TYPE_STG.getValor()).
                                header(CONTENT_SHA.getLlave(), CONTENT_SHA.getValor()).
                                header(ACCEPT.getLlave(), ACCEPT.getValor()).
                                header(ORIGIN.getLlave(), ORIGIN.getValor()).
                                header(REFER.getLlave(), REFER.getValor()).
                                header(SEC_CH_UA_PUBLIC.getLlave(), SEC_CH_UA_PUBLIC.getValor()).
                                header(SEC_CH_UA_MOBILE.getLlave(), SEC_CH_UA_MOBILE.getValor()).
                                header(SEC_CH_UA_PLATFORM_STG.getLlave(), SEC_CH_UA_PLATFORM_STG.getValor()).
                                header(SEC_PLATFORM_PUBLIC_DEST.getLlave(), SEC_PLATFORM_PUBLIC_DEST.getValor()).
                                header(SEC_MODE.getLlave(), SEC_MODE.getValor()).
                                header(SEC_FETCH_SITE_PUBLIC.getLlave(), SEC_FETCH_SITE_PUBLIC.getValor()).
                                header(AGENT_PUBLIC.getLlave(), AGENT_PUBLIC.getValor()).

                                contentType(ContentType.JSON).body("{" +
                                        '\"' + COUNTRY.getLlave() + '\"' + ":" + '\"' + data.obtenerDatos("country") + '\"' + "," +

                                        '\"' + TRACE.getLlave() + '\"' + ":" +

                                        "{" +
                                        '\"' + CREATION_CHANNEL.getLlave() + '\"' + ":" + '\"' + CREATION_CHANNEL.getValor() + '\"' + "," +
                                        '\"' + CREATION_CHANNEL_TYPE_PUBLIC.getLlave() + '\"' + ":" + '\"' + CREATION_CHANNEL_TYPE_PUBLIC.getValor() + '\"' +
                                        "}" + "}")));

        Assert.assertEquals(200, SerenityRest.lastResponse().statusCode());

    }

}
