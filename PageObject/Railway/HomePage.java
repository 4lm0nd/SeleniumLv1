package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Locators
    private static By lblWelcomeMessage = By.xpath("//div[@class ='account']/strong");

    //Elements
    public final WebElement getLblWelcomeMessage() {
        return Constant.DRIVER.findElement(lblWelcomeMessage);
    }
}
