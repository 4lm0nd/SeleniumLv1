package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyCreateNewAccount {

    GeneralPage generalPage = new GeneralPage();
    RegisterPage registerPage = new RegisterPage();
    Utilities utilities = new Utilities();
    BrowserManager browserManager = new BrowserManager();
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
    public void TC07() {
        logger.info("TC07_Verify_User can create new account");
        String email = "al" + Utilities.convertDateToString() + "@yopmail.com";
        logger.info("Step 1: Create new account with valid data");
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        logger.info("Check success message appear");
        utilities.checkTextContent(registerPage.getSuccessMsg(), "Registration Confirmed! You can now log in to the site.");
    }
    @Test
    public void TC10() {
        logger.info("TC10_Verify_User can't create account with Confirm password is not the same with Password");
        String email = "al" + Utilities.convertDateToString() + "@yopmail.com";
        logger.info("Step 1: Create new account with confirm password is not the same with password");
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD2, Constant.PASSWORD);
        logger.info("Check error message appear");
        utilities.checkTextContent(registerPage.getErrorMsg(), "There're errors in the form. Please correct the errors and try again.");
    }
    @Test
    public void TC11() {
        logger.info("TC11_Verify_User can't create account while password and PID fields are empty");
        String email = "al" + Utilities.convertDateToString() + "@yopmail.com";
        logger.info("Step 1: Create new account with blank password and pid");
        registerPage.register(email, "", "", "");
        logger.info("Check error message appear");
        utilities.checkTextContent(registerPage.getErrorMsg(), "There're errors in the form. Please correct the errors and try again.");
        utilities.checkTextContent(registerPage.getPasswordMsgValidation(), "Invalid password length");
        utilities.checkTextContent(registerPage.getPIDMsgValidation(), "Invalid ID length");
    }
}
