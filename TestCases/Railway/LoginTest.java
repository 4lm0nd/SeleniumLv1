package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import Railway.Constant;

public class LoginTest {
    static GeneralPage generalPage;
    static LoginPage loginPage;
    static HomePage homePage;

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC1() {
        System.out.println("TC01_Verify_User can log into Railway with valid username and password");
        generalPage = new GeneralPage();
        generalPage.OpenRailway();
        generalPage.GotoTab("Login");
        generalPage.scrollByPage();
        loginPage = new LoginPage();
        loginPage.Login(Constant.USER_NAME, Constant.PASSWORD);
        homePage = new HomePage();
        String actualMsg = homePage.getLblWelcomeMessage().getText().toString();
        String expectedMsg = "Welcome " + Constant.USER_NAME;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}