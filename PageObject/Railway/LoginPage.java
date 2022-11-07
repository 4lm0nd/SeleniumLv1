package Railway;

import Railway.GeneralPage;
import Railway.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

   //Locator
    private By _txtEmail = By.id("username");
    private By _txtPassword = By.id("password");
    private By _btnLogin = By.xpath("//input[@title='Login']");

    //Element
    public WebElement getTxtEmail() {
        return Constant.DRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword() {
        return Constant.DRIVER.findElement(_txtPassword);
    }
    public WebElement getBtnLogin() {
        return Constant.DRIVER.findElement(_btnLogin);
    }

    //Method
    public void Login(String email, String pass) {
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        getTxtPassword().click();
        getTxtPassword().sendKeys(pass);
        getBtnLogin().click();
    }
}
