package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.SPAN_CONFIRM_PASSWORD_ERROR;

public class AnswerPasswords implements Question<Boolean> {
    private final String question;

    public AnswerPasswords(String question) {
        this.question = question;
    }

    public static AnswerPasswords validPasswords(String question){
        return new AnswerPasswords(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanPassword = Text.of(SPAN_CONFIRM_PASSWORD_ERROR).viewedBy(actor).asString();
        if (question.equals(spanPassword)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
