package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseAdditionalPagesDisplayAfterLogin {
    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();
    Utilities utilities = new Utilities();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC06_AdditionalPages_display_after_login(){
        logger.info ("TC06_Verify_Additional pages display once user logged in");
        logger.info("Step 1: Login with valid account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
        logger.info("Check My ticket tab is displayed");
        utilities.checkElementExist(generalPage.getTabMenu("My ticket"));
        logger.info("Check user goes to My ticket page when clicking on My ticket tab");
        generalPage.goToTab("My ticket");
        utilities.checkTextContent(myTicketPage.getMyTicketPageTitle(), "Manage ticket");
        logger.info("check Change Password tab is displayed");
        utilities.checkElementExist(generalPage.getTabMenu("Change password"));
        logger.info("Check user goes to Change Password page when clicking on Change password tab");
        generalPage.goToTab("Change password");
        utilities.checkTextContent(changePasswordPage.getChangePasswordPageTitle(), "Change password");
        logger.info("Check Log out tab is displayed");
        utilities.checkElementExist(generalPage.getTabMenu("Log out"));
    }
}