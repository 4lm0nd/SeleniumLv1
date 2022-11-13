package Railway;

import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Railway_TC08_VerifyLoginWithUnactivatedEmail {

    DriverManager driverManager = new DriverManager();
    RegisterPage registerPage = new RegisterPage();
    Utilities utilities = new Utilities();
    LoginPage loginPage = new LoginPage();

    String email = "al" + Constant.convertDateToString() + "@yopmail.com";

    @BeforeMethod
    public void beforeMethod() {
        driverManager = new DriverManager();
        driverManager.openSite(Constant.RAILWAY_SITE);
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC08() {
        System.out.println("TC08_Verify_User can't login with an account hasn't been activated");
        loginPage.login(email, Constant.PASSWORD);
        String pageTitle = loginPage.getPageTitle().getText().toString();
        utilities.checkTextContent(pageTitle,"Login Page");
       }
}
