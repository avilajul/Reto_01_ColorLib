package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.SPAN_URL_ERROR;

public class AnswerInvalidUrl implements Question<Boolean> {
    private final String question;

    public AnswerInvalidUrl(String question) {
        this.question = question;
    }

    public static AnswerInvalidUrl validUrl(String question){
        return new AnswerInvalidUrl(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanUrl = Text.of(SPAN_URL_ERROR).viewedBy(actor).asString();
        if (question.equals(spanUrl)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
