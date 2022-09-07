package co.com.choucair.certification.reto1julian.tasks;

import co.com.choucair.certification.reto1julian.userinterface.PageComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EnterBlockValidationForm implements Task {

    public static EnterBlockValidationForm enterForm(){
        return Tasks.instrumented(EnterBlockValidationForm.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PageComponent.MENU_FORMS),
                Click.on(PageComponent.SUBMENU_FORM_VALIDATION)
        );
    }
}
