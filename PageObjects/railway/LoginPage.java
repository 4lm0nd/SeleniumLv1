package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {

    //Locator
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@title='Login']");
    private final By msgError = By.xpath("//p[@class = 'message error LoginForm']");

    //Element
    private WebElement getTxtEmail() {
        return BrowserManager.DRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return BrowserManager.DRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return BrowserManager.DRIVER.findElement(btnLogin);
    }

    private WebElement getMsgError() {
        return BrowserManager.DRIVER.findElement(msgError);
    }

    //Method
    public void login(String email, String pass) {
        goToTab("Login");
        scrollToFindElement(getBtnLogin());
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        getTxtPassword().click();
        getTxtPassword().sendKeys(pass);
        getBtnLogin().click();
    }

    public void multipleLogin(String email, String pass, int time) {
        goToTab("Login");
        scrollToFindElement(getBtnLogin());
        for (int i = 0; i < time; i++) {
            login(email, pass);
        }
    }

    public String getLoginErrorMsg() {
        return getMsgError().getText();
    }

}
