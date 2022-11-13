package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {

    //Locator
    private By txtEmail = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@title='Login']");
    private By msgError = By.xpath("//p[@class = 'message error LoginForm']");
    private By pageTitle = By.xpath("//div[@id='content']/h1");

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

    public WebElement getPageTitle() {
        return Constant.DRIVER.findElement(pageTitle);
    }

    //Method
    public void login(String email, String pass) {
        goToTab("Login");
        scrollByPage();
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        getTxtPassword().click();
        getTxtPassword().sendKeys(pass);
        getBtnLogin().click();
    }

    public void multipleLogin(String email, String pass, int time) {
        goToTab("Login");
        scrollByPage();
        for (int i = 0; i < time; i++) {
            login(email, pass);
        }
    }
}
