package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {

    //Locator
    private static final By txtEmail = By.id("username");
    private static final By txtPassword = By.id("password");
    private static final By btnLogin = By.xpath("//input[@title='Login']");
    private static final By msgError = By.xpath("//p[@class = 'message error LoginForm']");

    //Element
    public WebElement getTxtEmail() {
        return Constant.DRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.DRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.DRIVER.findElement(btnLogin);
    }

    public WebElement getMsgError() {
        return Constant.DRIVER.findElement(msgError);
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

    public String getErrorMsg() {
        return getMsgError().getText();
    }

}
