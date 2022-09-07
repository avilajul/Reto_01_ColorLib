package co.com.choucair.certification.reto1julian.questions;

import static co.com.choucair.certification.reto1julian.userinterface.PageComponent.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class AnswerAuthentication implements Question<Boolean> {

    private final String question;

    public AnswerAuthentication(String question) {
        this.question = question;
    }
    public static AnswerAuthentication toThe(String question){
        return new AnswerAuthentication(question);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String homeLabel = Text.of(LABEL_HOME).viewedBy(actor).asString();
        homeLabel = homeLabel.trim();

        if (question.equals(homeLabel)){
            result = true;
        }else {
            result = false;
        }

        return result;
    }
}





