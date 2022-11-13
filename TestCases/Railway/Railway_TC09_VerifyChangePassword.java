package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Railway_TC09_VerifyChangePassword {

    DriverManager driverManager = new DriverManager();
    Utilities utilities = new Utilities();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    String email = "al" + Constant.convertDateToString() + "@yopmail.com";


    @BeforeMethod
    public void beforeMethod() {
        driverManager = new DriverManager();
        driverManager.openSite(Constant.RAILWAY_SITE);
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC09() {
        System.out.println("TC06_Verify_User can change password");
        loginPage.login(email, Constant.PASSWORD);
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD2, Constant.PASSWORD2);
        String actualMsg = changePasswordPage.getMsgSuccess().getText().toString();
        utilities.checkTextContent(actualMsg, "Your password has been updated!");
    }
}
