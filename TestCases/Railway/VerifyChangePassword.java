package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyChangePassword {

    BrowserManager browserManager = new BrowserManager();
    GeneralPage generalPage = new GeneralPage();
    Utilities utilities = new Utilities();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    Logger logger = new Logger();
    String email = "al" + Utilities.convertDateToString() + "@yopmail.com";


    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC09() {
        logger.info("TC06_Verify_User can change password");
        logger.info("Step 1: Login");
        loginPage.login(email, Constant.PASSWORD);
        logger.info("Step 2: Change password");
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD2, Constant.PASSWORD2);
        logger.info("Check success message appear");
        utilities.checkTextContent(changePasswordPage.getSuccessMsg(), "Your password has been updated!");
    }
}
