package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.SPAN_PASSWORD_ERROR;

public class AnswerPasswordLenght implements Question<Boolean> {
    private final String question;

    public AnswerPasswordLenght(String question) {
        this.question = question;
    }

    public static AnswerPasswordLenght validLenghtPassword(String question){
        return new AnswerPasswordLenght(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanPassword = Text.of(SPAN_PASSWORD_ERROR).viewedBy(actor).asString();
        if (question.equals(spanPassword)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
