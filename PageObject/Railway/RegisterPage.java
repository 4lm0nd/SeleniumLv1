package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locator
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("password");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By txtPID = By.id("pid");
    private By btnRegister = By.xpath("//input[@title='Register']");
    private By pageTitle = By.xpath("//div[@id='content']/h1");
    private By msgError = By.xpath("//p[@class='message error']");
    private By msgSuccess = By.xpath("//div[@id='content']/p");
    private By msgPDIValidation = By.xpath("//label[@for='pid' and @class='validation-error']");
    private By msgPasswordValidation = By.xpath("//label[@for='password' and @class='validation-error']");

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

    public WebElement getPageTitle() {

        return Constant.DRIVER.findElement(pageTitle);
    }

    public WebElement getMsgSuccess() {
        return Constant.DRIVER.findElement(msgSuccess);
    }

    public WebElement getMsgPIDValidation(){
        return Constant.DRIVER.findElement(msgPDIValidation);
    }

    public WebElement getMsgPasswordValidation(){
        return Constant.DRIVER.findElement(msgPasswordValidation);
    }

    public void register(String email, String password, String confirmPassword, String PID) {
        goToTab("Register");
        scrollDown();
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(PID);
        getBtnRegister().click();
    }

    public String getSuccessMsg(){
                String successMsg = getMsgSuccess().getText().toString();
        return successMsg;
    }

    public String getPIDMsgValidation(){
        String pidValidationMsg = getMsgPIDValidation().getText().toString();
        return pidValidationMsg;
    }

    public String getPasswordMsgValidation(){
        String passwordValidationMsg = getMsgPasswordValidation().getText().toString();
        return passwordValidationMsg;
    }

    public String getErrorMsg(){
        String errorMsg = getMsgError().getText().toString();
        return errorMsg;
    }
}
