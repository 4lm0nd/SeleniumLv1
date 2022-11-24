package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {

    //Locators
    private final By lblWelcomeMessage = By.xpath("//div[@class ='account']/strong");

    //Elements
    private final WebElement getLblWelcomeMessage() {
        return BrowserManager.DRIVER.findElement(lblWelcomeMessage);
    }

    public String getWelcomeMsg() {
        return getLblWelcomeMessage().getText();
    }
}
