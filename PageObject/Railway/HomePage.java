package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Variable

    //Locators
    private static By lblWelcomeMessage = By.xpath("//div[@class ='account']/strong");

    //Elements
    public final WebElement getLblWelcomeMessage() {
        return Constant.DRIVER.findElement(lblWelcomeMessage);
    }

    public String getWelcomeMsg() {
        String welcomeMsg = getLblWelcomeMessage().getText().toString();
        return welcomeMsg;

    }
}
