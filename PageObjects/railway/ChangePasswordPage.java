package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locator
    private static final By txtCurrentPassword = By.id("currentPassword");
    private static final By txtNewPassword = By.id("newPassword");
    private static final By txtConfirmPassword = By.id("confirmPassword");
    private static final By btnChangePassword = By.xpath("//input[@title='Change password']");
    private static final By msgSuccess = By.xpath("//p[@class='message success']");


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

    public WebElement getMsgSuccess() {
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

    public String getSuccessMsg() {
        return getMsgSuccess().getText();
    }
}
