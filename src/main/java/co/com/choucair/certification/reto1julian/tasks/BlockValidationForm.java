package co.com.choucair.certification.reto1julian.tasks;

import co.com.choucair.certification.reto1julian.model.FormBlockValidationData;
import static co.com.choucair.certification.reto1julian.userinterface.BlockValidationFormComponent.*;
import co.com.choucair.certification.reto1julian.userinterface.PageComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

public class BlockValidationForm implements Task {

    private final List<FormBlockValidationData> formBlockValidationData;
    private final Boolean agree;

    public BlockValidationForm(List<FormBlockValidationData> formBlockValidationData, Boolean agree) {
        this.formBlockValidationData = formBlockValidationData;
        this.agree = agree;
    }

    public static BlockValidationForm fillOutForm(List<FormBlockValidationData> formBlockValidationData, Boolean agree){
        return Tasks.instrumented(BlockValidationForm.class, formBlockValidationData, agree);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PageComponent.MENU_FORMS),
                Click.on(PageComponent.SUBMENU_FORM_VALIDATION)
        );
        actor.attemptsTo(
                Enter.theValue(formBlockValidationData.get(0).getRequired()).into(INPUT_REQUIRED),
                Enter.theValue(formBlockValidationData.get(0).getEmail()).into(INPUT_EMAIL),
                Enter.theValue(formBlockValidationData.get(0).getFormPassword()).into(INPUT_PASSWORD),
                Enter.theValue(formBlockValidationData.get(0).getFormConfirmPassword()).into(INPUT_CONFIRM_PASSWORD),
                Enter.theValue(formBlockValidationData.get(0).getDate()).into(INPUT_DATE),
                Enter.theValue(formBlockValidationData.get(0).getUrl()).into(INPUT_URL),
                Enter.theValue(formBlockValidationData.get(0).getDigitOnly()).into(INPUT_DIGITS),
                Enter.theValue(formBlockValidationData.get(0).getRange()).into(INPUT_RANGE)
        );
        if (Boolean.TRUE.equals(agree)) {
            actor.attemptsTo(Click.on(CHECK_AGREE_TO_OUR_POLICY));
        }

        actor.attemptsTo(Click.on(BUTTON_VALIDATE));
    }
}
