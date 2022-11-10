package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

    //Locator
    private By pagetitle = By.xpath("//div[@id='content']/h1");

    //Element
    public WebElement getPageTitle() {
        return Constant.DRIVER.findElement(pagetitle);
    }
}
