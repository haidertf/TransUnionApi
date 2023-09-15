package utilidades;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.apache.log4j.Logger;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BeforeHook {
    static BaseTemplate data = new BaseTemplate();
    /********** Log Attribute **********/
    private static final Logger LOGGER = Logger.getLogger(BeforeHook.class);



    @Before
    public void initScenario(Scenario scenario) {
        LOGGER.info("************************************************************************************************");
        LOGGER.info("[ Start stage ] --> " + scenario.getName());
        LOGGER.info("************************************************************************************************");
    }

    public static void prepareStage(String urlBase) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Luis").whoCan(CallAnApi.at(urlBase));
    }

    @After
    public void endScenario(Scenario scenario) {
        LOGGER.info("************************************************************************************************");
        LOGGER.info("[ End of stage ] --> " + scenario.getName());
        LOGGER.info("************************************************************************************************");
    }

}
