package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.SPAN_RANGE_ERROR;

public class AnswerInvalidRange implements Question<Boolean> {
    private final String question;

    public AnswerInvalidRange(String question) {
        this.question = question;
    }

    public static AnswerInvalidRange validRange(String question){
        return new AnswerInvalidRange(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanRange = Text.of(SPAN_RANGE_ERROR).viewedBy(actor).asString();
        if (question.equals(spanRange)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
