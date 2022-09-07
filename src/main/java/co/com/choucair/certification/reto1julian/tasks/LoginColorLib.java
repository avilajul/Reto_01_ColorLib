package co.com.choucair.certification.reto1julian.tasks;

import co.com.choucair.certification.reto1julian.model.UserData;
import static co.com.choucair.certification.reto1julian.userinterface.LoginComponent.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

public class LoginColorLib implements Task {
    private final List<UserData> userData;

    public LoginColorLib(List<UserData> dataUser) {
        this.userData = dataUser;
    }

    public static LoginColorLib thePage(List<UserData> dataUser) {
        return Tasks.instrumented(LoginColorLib.class, dataUser);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userData.get(0).getUserName()).into(INPUT_USERNAME),
                Enter.theValue(userData.get(0).getPassword()).into(INPUT_PASSWORD),
                Click.on(BUTTON_SIGNIN)
                );
    }
}
