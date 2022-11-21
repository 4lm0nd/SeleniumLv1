package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseCreateNewAccount {

    private static final String emailTC07 = "al07" + Utilities.convertDateToString() + "@yopmail.com";
    private static final String emailTC10 = "al10" + Utilities.convertDateToString() + "@yopmail.com";
    private static final String emailTC11 = "al11" + Utilities.convertDateToString() + "@yopmail.com";

    private static final String password = ReadFileJson.getJsonValue("Register.json", "password");
    private static final String pasword2 = ReadFileJson.getJsonValue("Register.json", "password2");
    private static final String confirmPass = ReadFileJson.getJsonValue("Register.json", "confirm password");
    private static final String PID = ReadFileJson.getJsonValue("Register.json", "pid password");
    private static final String registSuccessMsg = ReadFileJson.getJsonValue("Register.json", "mgs register success");
    private static final String registErrorMsg = ReadFileJson.getJsonValue("Register.json", "msg register error");
    private static final String registPasswordError = ReadFileJson.getJsonValue("Register.json", "msg password validation");
    private static final String registPIDError = ReadFileJson.getJsonValue("Register.json", "msg pid validation");

    private static final GeneralPage generalPage = new GeneralPage();
    private static final RegisterPage registerPage = new RegisterPage();
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
    public void TC07_Verify_User_can_create_account_with_valid_data() {
        logger.info("TC07_Verify_User can create new account");
        logger.info("Step 1: Create new account with valid data");
        registerPage.register(emailTC07, password, confirmPass, PID);
        logger.info("Check success message appear");
        utilities.checkTextContent(registerPage.getSuccessMsg(), registSuccessMsg);
    }

    @Test
    public void TC10_Verify_User_cannot_create_account_with_mismatched_passwords() {
        logger.info("TC10_Verify_User can't create account with Confirm password is not the same with Password");
        logger.info("Step 1: Create new account with confirm password is not the same with password");
        registerPage.register(emailTC10, password, pasword2, PID);
        logger.info("Check error message appear");
        utilities.checkTextContent(registerPage.getErrorMsg(), registErrorMsg);
    }

    @Test
    public void TC11_Verify_User_cannot_create_account_without_PID() {
        logger.info("TC11_Verify_User can't create account while password and PID fields are empty");
        logger.info("Step 1: Create new account with blank password and pid");
        registerPage.register(emailTC11, "", "", "");
        logger.info("Check error message appear");
        utilities.checkTextContent(registerPage.getErrorMsg(), registErrorMsg);
        utilities.checkTextContent(registerPage.getPasswordError(), registPasswordError);
        utilities.checkTextContent(registerPage.getPIDError(), registPIDError);
    }
}
