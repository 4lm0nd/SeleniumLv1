package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseLoginWithNoneExistentAccount {
    private final String email = "alTC08" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = ReadFileJson.getJsonValue("Login.json", "password");
    private final String errorLoginMsg = ReadFileJson.getJsonValue("Login.json", "msg validation");
    private final GeneralPage generalPage = new GeneralPage();
    private final Utilities utilities = new Utilities();
    private final LoginPage loginPage = new LoginPage();
    private final Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.DRIVER.quit();
    }

    @Test
    public void TC08_Login_with_nonexistent_account() {
        logger.info("TC08_Verify_User can't login with an account hasn't been registered");
        logger.info("Step 1: Login with an account that hasn't been registered");
        loginPage.login(email, password);
        logger.info("Check unsuccessfully login");
        utilities.checkTextContent(loginPage.getLoginErrorMsg(), errorLoginMsg);
    }
}
