package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.*;

public class AnswerEmptyForm implements Question<Boolean> {

    private final String question;

    public AnswerEmptyForm(String question) {
        this.question = question;
    }

    public static AnswerEmptyForm areEmptyFields(String question){
        return new AnswerEmptyForm(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String spanRequired = Text.of(SPAN_REQUIRED_ERROR).viewedBy(actor).asString();
        String spanEmail = Text.of(SPAN_EMAIL_ERROR).viewedBy(actor).asString();
        String spanPassword = Text.of(SPAN_PASSWORD_ERROR).viewedBy(actor).asString();
        String spanConfirmPassword = Text.of(SPAN_CONFIRM_PASSWORD_ERROR).viewedBy(actor).asString();
        String spanDate = Text.of(SPAN_DATE_ERROR).viewedBy(actor).asString();
        String spanUrl = Text.of(SPAN_URL_ERROR).viewedBy(actor).asString();
        String spanDigits = Text.of(SPAN_DIGITS_ERROR).viewedBy(actor).asString();
        String spanRange = Text.of(SPAN_RANGE_ERROR).viewedBy(actor).asString();
        String spanAgree = Text.of(SPAN_AGREE_TO_OUR_POLICY_ERROR).viewedBy(actor).asString();

        if (question.equals(spanRequired) &&  question.equals(spanEmail) && question.equals(spanPassword)
                && question.equals(spanConfirmPassword) && question.equals(spanDate) && question.equals(spanUrl)
                && question.equals(spanDigits) && question.equals(spanRange) && question.equals(spanAgree)) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

}
