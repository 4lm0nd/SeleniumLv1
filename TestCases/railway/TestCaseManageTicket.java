package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseManageTicket {
    private static final String email = "al" + Utilities.convertDateToString() + "@yopmail.com";
    private static final String password = ReadFileJson.getJsonValue("Register.json", "password");
    private static final String confirmPass= ReadFileJson.getJsonValue("Register.json", "confirm password");
    private static final String PID = ReadFileJson.getJsonValue("Register.json", "pid password");
    private static final String departStation = ReadFileJson.getJsonValue("BookTicket.json", "depart station");
    private static final String arriveStation = ReadFileJson.getJsonValue("BookTicket.json", "arrive station");
    private static final String seatType = ReadFileJson.getJsonValue("BookTicket.json", "seat type");
    private static final String amount = ReadFileJson.getJsonValue("BookTicket.json", "amount");
    private static final String bookingSuccessMsg = ReadFileJson.getJsonValue("BookTicket.json", "msg book ticket success");
    private static final Utilities utilities = new Utilities();
    private static final MyTicketPage myTicketPage = new MyTicketPage();
    private static final LoginPage loginPage = new LoginPage();
    private static final RegisterPage registerPage = new RegisterPage();
    private static final BookTicketPage bookTicketPage = new BookTicketPage();
    private static final GeneralPage generalPage = new GeneralPage();
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
    public void TC14_TC16_Book_and_Cancel_Ticket() {
        logger.info("Preconditions: Register a new account");
        registerPage.register(email, password, confirmPass, PID);
        logger.info("TC14_Verify_User can book 1 ticket at a time");
        logger.info("Step 1: Login");
        loginPage.login(email, password);
        logger.info("Step 2: Book a ticket");
        bookTicketPage.bookTicket(
                utilities.getDateLaterFromCurrentDate(7), departStation, arriveStation, seatType, amount);
        logger.info("Verify book ticket successfully");
        utilities.checkTextContent(bookTicketPage.getSuccessMsg(), bookingSuccessMsg);
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Depart Station"), departStation);
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Arrive Station"), arriveStation);
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Seat Type"), seatType);
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Depart Date"), utilities.getDateLaterFromCurrentDate(7));
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Amount"), amount);
        logger.info("TC16_Verify_User can cancel a ticket");
        logger.info("Step 1: Go to My Ticket tab");
        generalPage.goToTab("My ticket");
        logger.info("Step 3: Cancel ticket");
        myTicketPage.cancelTicket();
        logger.info("Check the ticket disappears");
        utilities.checkElementDoesNotExist(myTicketPage.getMyTable());

    }
}





