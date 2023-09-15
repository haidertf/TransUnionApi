package interacciones.timer;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.com.identity_auto.certification.utilidades.enums.Timer.START_TIME;

public class CalculateExecutionTime implements Interaction {
    public static CalculateExecutionTime serviceResponse() {
        return new CalculateExecutionTime();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        long miliSegundosIniciales = actor.recall(START_TIME.toString());
        long miliSegundosFinales = System.currentTimeMillis();
        double tiempoDeEjecucion = Double.parseDouble(String.valueOf((miliSegundosFinales - miliSegundosIniciales)));
        double formatoASegundos = (tiempoDeEjecucion / 1000);
        if (formatoASegundos <= 4.000) {
            System.out.println("La API cumple con el tiempo de ejecucion Esperado: " + formatoASegundos);
        } else if (formatoASegundos > 4.000) {
            System.out.println("La API NO cumple con el tiempo de ejecucion Esperado: " + formatoASegundos);
        }
        actor.attemptsTo( );
    }
    }

