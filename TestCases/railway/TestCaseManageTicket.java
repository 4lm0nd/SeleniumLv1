package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseManageTicket {
    private final String email = "alTC14" + Utilities.convertDateToString() + "@yopmail.com";
    private final String password = ReadFileJson.getJsonValue("Register.json", "password");
    private final String confirmPass = ReadFileJson.getJsonValue("Register.json", "confirm password");
    private final String PID = ReadFileJson.getJsonValue("Register.json", "pid password");
    private final String departStation = ReadFileJson.getJsonValue("BookTicket.json", "depart station");
    private final String arriveStation = ReadFileJson.getJsonValue("BookTicket.json", "arrive station");
    private final String seatType = ReadFileJson.getJsonValue("BookTicket.json", "seat type");
    private final String amount = ReadFileJson.getJsonValue("BookTicket.json", "amount");
    private final String bookingSuccessMsg = ReadFileJson.getJsonValue("BookTicket.json", "msg book ticket success");
    private final Utilities utilities = new Utilities();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private final LoginPage loginPage = new LoginPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final GeneralPage generalPage = new GeneralPage();
    private final Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.DRIVER.quit();
    }

    @Test
    public void TC14_TC16_Verify_User_can_book_and_cancel_for_A_ticket() {
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
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Depart Date"),
                utilities.getDateLaterFromCurrentDate(7));
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Amount"), amount);
        logger.info("TC16_Verify_User can cancel a ticket");
        logger.info("Step 1: Go to My Ticket tab");
        generalPage.goToTab("My ticket");
        logger.info("Step 3: Cancel ticket");
        myTicketPage.cancelTicket();
        logger.info("Check the ticket disappears");
        String ticketInfo = departStation +" "+ arriveStation +" "+ seatType +" "+ utilities.getDateLaterFromCurrentDate(7).toString();
        String myTableInfo = myTicketPage.getMyTableTextContent();
        utilities.checkTextDoesNotContent(myTableInfo,ticketInfo);
    }
}





