package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.SPAN_DIGITS_ERROR;

public class AnswerInvalidDigits implements Question<Boolean> {
    private final String question;

    public AnswerInvalidDigits(String question) {
        this.question = question;
    }

    public static AnswerInvalidDigits validDigits(String question){
        return new AnswerInvalidDigits(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanDigits = Text.of(SPAN_DIGITS_ERROR).viewedBy(actor).asString();
        if (question.equals(spanDigits)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
