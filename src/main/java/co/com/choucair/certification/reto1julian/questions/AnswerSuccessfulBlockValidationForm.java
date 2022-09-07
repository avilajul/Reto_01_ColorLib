package co.com.choucair.certification.reto1julian.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.ArrayList;

import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.*;

public class AnswerSuccessfulBlockValidationForm implements Question<Boolean> {

    public static AnswerSuccessfulBlockValidationForm successfulValidation(){
        return new AnswerSuccessfulBlockValidationForm();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result = true;
        ArrayList<Boolean> campos = new ArrayList<>();
        campos.add(Text.of(INPUT_REQUIRED).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_EMAIL).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_PASSWORD).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_CONFIRM_PASSWORD).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_DATE).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_URL).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_DIGITS).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(INPUT_RANGE).viewedBy(actor).asString().isEmpty());
        campos.add(Text.of(CHECK_AGREE_TO_OUR_POLICY).viewedBy(actor).asString().isEmpty());

        for (Boolean campo : campos) {
            if (Boolean.FALSE.equals(campo)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
