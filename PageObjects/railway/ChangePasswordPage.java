package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private By txtCurrentPassword = By.id("currentPassword");
    private By txtNewPassword = By.id("newPassword");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By btnChangePassword = By.xpath("//input[@title='Change password']");
    private By msgSuccess = By.xpath("//p[@class='message success']");


    //Element
    public WebElement getTxtCurrentPassword() {
        return Constant.DRIVER.findElement(txtCurrentPassword);
    }
    public WebElement getTxtNewPassword() {
        return Constant.DRIVER.findElement(txtNewPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.DRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getBtnChangePassword() {
        return Constant.DRIVER.findElement(btnChangePassword);
    }

    public WebElement getMsgSuccess(){
        return Constant.DRIVER.findElement(msgSuccess);
    }

    public void changePassword(String currentPass, String newPass, String confirmPass) {
        goToTab("Change password");
        scrollToFindElement(getBtnChangePassword());
        getTxtCurrentPassword().sendKeys(currentPass);
        getTxtNewPassword().sendKeys(newPass);
        getTxtConfirmPassword().sendKeys(confirmPass);
        getBtnChangePassword().click();
    }

    public String getChangePasswordPageTitle(){
        String pageTitle =  getTitlePage();
        return pageTitle;
    }

    public String getSuccessMsg(){
        String successMsg = getMsgSuccess().getText().toString();
        return successMsg;
    }
}
