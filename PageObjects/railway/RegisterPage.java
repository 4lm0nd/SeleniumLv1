package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locator
    private static final By txtEmail = By.id("email");
    private static final By txtPassword = By.id("password");
    private static final By txtConfirmPassword = By.id("confirmPassword");
    private static final By txtPID = By.id("pid");
    private static final By btnRegister = By.xpath("//input[@title='Register']");
    private static final By msgError = By.xpath("//p[@class='message error']");
    private static final By msgSuccess = By.xpath("//div[@id='content']/p");
    private static final By msgPIDError = By.xpath("//label[@for='pid' and @class='validation-error']");
    private static final By msgPasswordError = By.xpath("//label[@for='password' and @class='validation-error']");

    //Element
    public WebElement getTxtEmail() {

        return Constant.DRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {

        return Constant.DRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {

        return Constant.DRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return Constant.DRIVER.findElement(txtPID);
    }

    public WebElement getBtnRegister() {

        return Constant.DRIVER.findElement(btnRegister);
    }

    public WebElement getMsgError() {

        return Constant.DRIVER.findElement(msgError);
    }

    public WebElement getMsgSuccess() {
        return Constant.DRIVER.findElement(msgSuccess);
    }

    public WebElement getMsgPIDError() {
        return Constant.DRIVER.findElement(msgPIDError);
    }

    public WebElement getMsgPasswordError() {
        return Constant.DRIVER.findElement(msgPasswordError);
    }

    public void register(String email, String password, String confirmPassword, String PID) {
        goToTab("Register");
        scrollToFindElement(getBtnRegister());
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(PID);
        getBtnRegister().click();
    }

    public String getSuccessMsg() {
        return getMsgSuccess().getText();
    }

    public String getPIDError() {
        return getMsgPIDError().getText();
    }

    public String getPasswordError() {
        return getMsgPasswordError().getText();
    }

    public String getErrorMsg() {
        return getMsgError().getText();
    }
}
