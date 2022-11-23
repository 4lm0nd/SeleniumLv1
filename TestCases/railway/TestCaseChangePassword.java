package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseChangePassword {

    private final String email = "alTC09" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = ReadFileJson.getJsonValue("Register.json", "password");
    private final String password2 = ReadFileJson.getJsonValue("Register.json", "password2");
    private final String confirmPass = ReadFileJson.getJsonValue("Register.json", "confirm password");
    private final String PID = ReadFileJson.getJsonValue("Register.json", "pid password");
    private final GeneralPage generalPage = new GeneralPage();
    private final Utilities utilities = new Utilities();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
        logger.info("Preconditions: Register new account");
        registerPage.register(email, password, confirmPass, PID);
    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.DRIVER.quit();
    }

    @Test
    public void TC09_Verify_User_can_change_password() {
        logger.info("TC06_Verify_User can change password");
        logger.info("Step 1: Login");
        loginPage.login(email, password);
        logger.info("Step 2: Change password");
        changePasswordPage.changePassword(password, password2, password2);
        logger.info("Check success message appear");
        utilities.checkTextContent(changePasswordPage.getSuccessMsg(), "Your password has been updated!");
    }
}
