package co.com.choucair.certification.reto1julian.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;



public class BlockValidationFormComponent {
    public static final Target INPUT_REQUIRED = Target.the("Requerido").located(By.id("required2"));
    public static final Target INPUT_EMAIL = Target.the("Correo electrónico").located(By.id("email2"));
    public static final Target INPUT_PASSWORD = Target.the("Password").located(By.id("password2"));
    public static final Target INPUT_CONFIRM_PASSWORD = Target.the("Confirmar Password").located(By.id("confirm_password2"));
    public static final Target INPUT_DATE = Target.the("Fecha").located(By.id("date2"));
    public static final Target INPUT_URL= Target.the("url").located(By.id("url2"));
    public static final Target INPUT_DIGITS = Target.the("Solo dígitos").located(By.id("digits"));
    public static final Target INPUT_RANGE = Target.the("Rango").located(By.id("range"));
    public static final Target CHECK_AGREE_TO_OUR_POLICY = Target.the("Aceptar nuestras políticas").located(By.id("agree2"));
    public static final Target BUTTON_VALIDATE = Target.the("Botón Validación").located(By.xpath("(//input[@type='submit'])[2]"));

    public static final Target SPAN_REQUIRED_ERROR = Target.the("Mensaje de error del campo Required").located(By.id("required2-error"));
    public static final Target SPAN_EMAIL_ERROR = Target.the("Mensaje de error del campo Email").located(By.id("email2-error"));
    public static final Target SPAN_PASSWORD_ERROR = Target.the("Mensaje de error del campo Password").located(By.id("password2-error"));
    public static final Target SPAN_CONFIRM_PASSWORD_ERROR = Target.the("Mensaje de error del campo Confirmar Password").located(By.id("confirm_password2-error"));
    public static final Target SPAN_DATE_ERROR = Target.the("Mensaje de error del campo Fecha").located(By.id("date2-error"));
    public static final Target SPAN_URL_ERROR = Target.the("Mensaje de error del campo Url").located(By.id("url2-error"));
    public static final Target SPAN_DIGITS_ERROR = Target.the("Mensaje de error del campo Digitos").located(By.id("digits-error"));
    public static final Target SPAN_RANGE_ERROR = Target.the("Mensaje de error del campo Rango").located(By.id("range-error"));
    public static final Target SPAN_AGREE_TO_OUR_POLICY_ERROR = Target.the("Mensaje de error del campo Aceptar Políticas").located(By.id("agree2-error"));

}
