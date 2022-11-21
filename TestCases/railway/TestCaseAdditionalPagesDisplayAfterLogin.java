package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseAdditionalPagesDisplayAfterLogin {
    private static final String email = ReadFileJson.getJsonValue("Login.json", "username");
    private static final String password = ReadFileJson.getJsonValue("Login.json", "password");
    private static final GeneralPage generalPage = new GeneralPage();
    private static final LoginPage loginPage = new LoginPage();
    private static final Utilities utilities = new Utilities();
    private static final Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.quit();
    }

    @Test
    public void TC06_Verify_AdditionalPages_display_after_login() {
        logger.info("TC06_Verify_Additional pages display once user logged in");
        logger.info("Step 1: Login with valid account");
        loginPage.login(email, password);
        logger.info("Check My ticket tab is displayed");
        utilities.checkElementExist(generalPage.getTabMenu("My ticket"));
        logger.info("Check user goes to My ticket page when clicking on My ticket tab");
        generalPage.goToTab("My ticket");
        utilities.checkTextContent(generalPage.getTitlePage(), "Manage ticket");
        logger.info("check Change Password tab is displayed");
        utilities.checkElementExist(generalPage.getTabMenu("Change password"));
        logger.info("Check user goes to Change Password page when clicking on Change password tab");
        generalPage.goToTab("Change password");
        utilities.checkTextContent(generalPage.getTitlePage(), "Change password");
        logger.info("Check Log out tab is displayed");
        utilities.checkElementExist(generalPage.getTabMenu("Log out"));
    }
}
