package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends GeneralPage {

    //Locator
    private By txtEmail = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@title='Login']");
    private By msgerror = By.xpath("//p[@class = 'message error LoginForm']");
    private By pagetitle = By.xpath("//div[@id='content']/h1");

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
        return Constant.DRIVER.findElement(msgerror);
    }

    public WebElement getPageTitle() {
        return Constant.DRIVER.findElement(pagetitle);
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
