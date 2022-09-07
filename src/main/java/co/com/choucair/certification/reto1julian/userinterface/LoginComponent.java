package co.com.choucair.certification.reto1julian.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginComponent {
    public static final Target INPUT_USERNAME= Target.the("Nombre de usuario")
            .located(By.xpath("//input[@placeholder='Username']"));

    public static final Target INPUT_PASSWORD= Target.the("Contraseña")
            .located(By.xpath("//input[@placeholder='Password']"));

    public static final Target BUTTON_SIGNIN= Target.the("Iniciar Sesión")
            .located(By.xpath("//button[@class='btn btn-lg btn-primary btn-block'][contains(.,'Sign in')]"));
}
