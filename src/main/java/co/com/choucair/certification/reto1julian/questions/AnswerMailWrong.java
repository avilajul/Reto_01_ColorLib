package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.SPAN_EMAIL_ERROR;

public class AnswerMailWrong implements Question<Boolean> {
    private final String question;

    public AnswerMailWrong(String question) {
        this.question = question;
    }

    public static AnswerMailWrong isEmailWrong(String question){
        return new AnswerMailWrong(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanEmail = Text.of(SPAN_EMAIL_ERROR).viewedBy(actor).asString();
        if (question.equals(spanEmail)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
