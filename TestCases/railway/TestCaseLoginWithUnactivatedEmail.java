package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseLoginWithUnactivatedEmail {
    private static final String email = "al" + Utilities.convertDateToString() + "@yopmail.com";
    private static final String password = ReadFileJson.getJsonValue("Register.json", "password");
    private static final String PID = ReadFileJson.getJsonValue("Register.json", "pid password");
    private static final String confirmPasswd = ReadFileJson.getJsonValue("Register.json", "confirm password");
    private static final GeneralPage generalPage = new GeneralPage();
    private static final RegisterPage registerPage = new RegisterPage();
    private static final Utilities utilities = new Utilities();
    private static final LoginPage loginPage = new LoginPage();
    private static final Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
        logger.info("Preconditions: Register new account");
        registerPage.register(email, password, confirmPasswd, PID);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.quit();
    }

    @Test
    public void TC08_Login_with_unactivated_username() {
        logger.info("TC08_Verify_User can't login with an account hasn't been activated");
        logger.info("Step 1: Login with an account that is not activated");
        loginPage.login(email, password);
        logger.info("Check unsuccessfully login");
        utilities.checkTextContent(generalPage.getTitlePage(), "Login page");
    }
}
