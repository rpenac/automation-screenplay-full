package co.reto.automatizacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageVisible implements Question<Boolean> {

    public static HomePageVisible esVisible() {
        return new HomePageVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return actor.asksFor(
                WebElementQuestion.the(
                        Target.the("titulo Products")
                              .locatedBy(".title")
                )
        ).isVisible();
    }
}