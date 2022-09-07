package co.com.choucair.certification.reto1julian.questions;

import static co.com.choucair.certification.reto1julian.userinterface.PageComponent.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class AnswerBlockValidationLabel implements Question<Boolean> {
    private final String question;

    public AnswerBlockValidationLabel(String question) {
        this.question = question;
    }

    public static AnswerBlockValidationLabel toThe(String question){
        return new AnswerBlockValidationLabel(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String blockValidationLabel = Text.of(LABEL_BLOCK_VALIDATION).viewedBy(actor).asString();
        blockValidationLabel = blockValidationLabel.trim();

        if (question.equals(blockValidationLabel)){
            result = true;
        }else {
            result = false;
        }

        return result;
    }
}
