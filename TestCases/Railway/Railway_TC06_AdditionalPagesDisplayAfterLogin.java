package Railway;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Railway_TC06_AdditionalPagesDisplayAfterLogin {
    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    DriverManager driverManager;
    Utilities utilities = new Utilities();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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
    public void TC06(){
        System.out.println("TC06_Verify_Additional pages display once user logged in");
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
        utilities.checkTabExist("My ticket");
        generalPage.goToTab("My ticket");
        String pageTitle1 = myTicketPage.getPageTitle().getText().toString();
        utilities.checkTextContent(pageTitle1,"Manage ticket");
        utilities.checkTabExist("Change password");
        generalPage.goToTab("Change password");
        String pageTitle2 = changePasswordPage.getPageTitle().getText().toString();
        utilities.checkTextContent(pageTitle2,"Change password");
        utilities.checkTabExist("Log out");
    }
}
