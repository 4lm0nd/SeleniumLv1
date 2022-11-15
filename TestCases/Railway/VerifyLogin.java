package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyLogin {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BrowserManager browserManager = new BrowserManager();
    Utilities utilities = new Utilities();
    BookTicketPage bookTicketPage = new BookTicketPage();
    GeneralPage generalPage = new GeneralPage();
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
    public void TC01() {
        logger.info("TC01_Verify_User can log into Railway with valid username and password");
        logger.info("Step 1: Login with valid account");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
        String expectedMsg = "Welcome " + Constant.USER_NAME;
        logger.info("Check success message");
        utilities.checkTextContent(homePage.getWelcomeMsg(), expectedMsg);
    }

    @Test
    public void TC02() {
        logger.info("TC02_Verify_User cannot login with blank username");
        logger.info("Step 1: Login with blank user");
        loginPage.login("", Constant.PASSWORD);
        logger.info("Check error message appear");
        utilities.checkTextContent(loginPage.getErrorMsg(), "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC03() {
        logger.info("TC03_Verify_User cannot log into Railway with invalid password ");
        logger.info("Step 1: Login with invalid password");
        loginPage.login(Constant.USER_NAME, "INVALID_PASSWORD");
        logger.info("Check error message appear");
        utilities.checkTextContent(loginPage.getErrorMsg(), "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC04() {
        logger.info("TC04_Verify_Login page displays when un-logged User clicks on Book ticket tab");
        logger.info("Step 1: Go to the book ticket page without login");
        generalPage.goToTab("Book ticket");
        logger.info("Check Login page is displayed");
        utilities.checkTextContent(loginPage.getLoginPageTitle(), "Login page");
    }

    @Test
    public void TC05() {
        logger.info("TC05_Verify_System shows message when user enters wrong password several times");
        logger.info("Step 1: Login multiple(6) times");
        loginPage.multipleLogin("INVALID_EMAIL", "INVALID_PASSWORD", 6);
        logger.info("Check error message appear");
        utilities.checkTextContent(loginPage.getErrorMsg(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}