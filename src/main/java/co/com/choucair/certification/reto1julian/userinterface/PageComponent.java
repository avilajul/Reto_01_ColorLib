package co.com.choucair.certification.reto1julian.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageComponent {

    public static final Target MENU_FORMS = Target.the("FORMS")
            .located(By.xpath("//a[contains(.,'Forms')]"));

    public static final Target SUBMENU_FORM_VALIDATION = Target.the("FORM_VALIDATION")
            .located(By.xpath("//a[contains(.,'Form Validation')]"));

    public static final Target LABEL_HOME = Target.the("VERIFY COLORLIB HOME")
            .located(By.xpath("//h3[contains(.,'Metis')]"));

    public static final Target LABEL_BLOCK_VALIDATION = Target.the("VERIFY COLORLIB HOME")
            .located(By.xpath("//h5[contains(.,'Block Validation')]"));




}
