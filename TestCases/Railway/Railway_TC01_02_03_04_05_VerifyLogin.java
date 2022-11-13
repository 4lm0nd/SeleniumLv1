package Railway;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Railway_TC01_02_03_04_05_VerifyLogin {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DriverManager driverManager = new DriverManager();
    Utilities utilities = new Utilities();
    BookTicketPage bookTicketPage = new BookTicketPage();
    GeneralPage generalPage = new GeneralPage();

    @BeforeMethod
    public void beforeMethod() {
        driverManager = new DriverManager();
        driverManager.openSite(Constant.RAILWAY_SITE);
    }
    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }
    @Test
    public void TC01() {
        System.out.println("TC01_Verify_User can log into Railway with valid username and password");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
        homePage = new HomePage();
        String actualMsg = homePage.getLblWelcomeMessage().getText().toString();
        String expectedMsg = "Welcome " + Constant.USER_NAME;
        utilities.checkTextContent(actualMsg, expectedMsg);
    }
    @Test
    public void TC02() {
        System.out.println("TC02_Verify_User cannot login with blank username");
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getMsgError().getText().toString();
        utilities.checkTextContent(actualMsg, "There was a problem with your login and/or errors exist in your form.");
    }
    @Test
    public void TC03() {
        System.out.println("TC03_Verify_User cannot log into Railway with invalid password ");
        loginPage.login(Constant.USER_NAME, "INVALID_PASSWORD");
        String actualMsg = loginPage.getMsgError().getText().toString();
        utilities.checkTextContent(actualMsg, "There was a problem with your login and/or errors exist in your form.");
    }
    @Test
    public void TC04() {
        System.out.println("TC04_Verify_Login page displays when un-logged User clicks on Book ticket tab");
        generalPage.goToTab("Book ticket");
        String pageTitle = loginPage.getPageTitle().getText().toString();
        utilities.checkTextContent(pageTitle, "Login page");
    }
    @Test
    public void TC05() {
        System.out.println("TC05_Verify_System shows message when user enters wrong password several times");
        loginPage = new LoginPage();
        loginPage.multipleLogin("INVALID_EMAIL", "INVALID_PASSWORD", 6);
        String actualMsg = loginPage.getMsgError().getText().toString();
        utilities.checkTextContent(actualMsg, "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}