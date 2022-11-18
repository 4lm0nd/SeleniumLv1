package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseLoginWithUnactivatedEmail {
    String email = "al" + Utilities.convertDateToString() + "@yopmail.com";

    GeneralPage generalPage = new GeneralPage();
    RegisterPage registerPage = new RegisterPage();
    Utilities utilities = new Utilities();
    LoginPage loginPage = new LoginPage();
    Logger logger = new Logger();

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
    public void TC08_Login_with_unactivated_username() {
        logger.info("TC08_Verify_User can't login with an account hasn't been activated");
        logger.info("Step 1: Login with an account that is not activated");
        loginPage.login(email, Constant.PASSWORD);
        logger.info("Check unsuccessfully login");
        utilities.checkTextContent(loginPage.getLoginPageTitle(), "Login page");
       }
}