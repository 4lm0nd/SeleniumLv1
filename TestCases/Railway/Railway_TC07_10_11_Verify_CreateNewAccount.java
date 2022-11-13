package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Railway_TC07_10_11_Verify_CreateNewAccount {

    GeneralPage generalPage = new GeneralPage();
    RegisterPage registerPage = new RegisterPage();
    Utilities utilities = new Utilities();
    DriverManager driverManager = new DriverManager();

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
    public void TC07() {
        System.out.println("TC07_Verify_User can create new account");
        String email = "al" + Constant.convertDateToString() + "@yopmail.com";
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        String actualMsg = registerPage.getMsgSuccess().getText().toString();
        utilities.checkTextContent(actualMsg, "Registration Confirmed! You can now log in to the site.");
    }
    @Test
    public void TC10() {
        System.out.println("TC10_Verify_User can't create account with Confirm password is not the same with Password");
        String email = "al" + Constant.convertDateToString() + "@yopmail.com";
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD2, Constant.PASSWORD);
        String actualMsg = registerPage.getMsgError().getText().toString();
        utilities.checkTextContent(actualMsg, "There're errors in the form. Please correct the errors and try again.");
    }
    @Test
    public void TC11() {
        System.out.println("TC11_Verify_User can't create account while password and PID fields are empty");
        String email = "al" + Constant.convertDateToString() + "@yopmail.com";
        registerPage.register(email, "", "", "");
        String actualMsg1 = registerPage.getMsgError().getText().toString();
        String actualMsg2 = registerPage.getMsgPasswordValidation().getText().toString();
        String actualMsg3 = registerPage.getMsgPIDValidation().getText().toString();
        utilities.checkTextContent(actualMsg1, "There're errors in the form. Please correct the errors and try again.");
        utilities.checkTextContent(actualMsg2,"Invalid password length");
        utilities.checkTextContent(actualMsg3, "Invalid ID length");
    }
}
