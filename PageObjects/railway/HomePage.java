package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Locators
    private static final By lblWelcomeMessage = By.xpath("//div[@class ='account']/strong");

    //Elements
    public final WebElement getLblWelcomeMessage() {
        return Constant.DRIVER.findElement(lblWelcomeMessage);
    }

    public String getWelcomeMsg() {
        return getLblWelcomeMessage().getText();
    }
}
