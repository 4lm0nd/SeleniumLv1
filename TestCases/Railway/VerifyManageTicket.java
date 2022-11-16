package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyManageTicket {
    String email = "al" + Utilities.convertDateToString() + "@yopmail.com";
    Utilities utilities = new Utilities();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimetablePage timetablePage = new TimetablePage();
    GeneralPage generalPage = new GeneralPage();
    Logger logger = new Logger();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
        logger.info("Preconditions: Register new account");
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC14() {
        logger.info("TC14_Verify_User can book 1 ticket at a time");
        logger.info("Step 1: Login");
        loginPage.login(email, Constant.PASSWORD);
        logger.info("Step 2: Book a ticket");
        bookTicketPage.bookTicket("11/20/2022", "Quảng Ngãi", "Nha Trang", "Soft seat with air conditioner", "1");
        String expectedMsg = "Ticket booked successfully!";
        logger.info("Verify book ticket successfully");
        utilities.checkTextContent(bookTicketPage.getSuccessMsg(), expectedMsg);
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Depart Station"), "Quảng Ngãi");
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Arrive Station"), "Nha Trang");
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Seat Type"), "Soft seat with air conditioner");
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Depart Date"), "11/20/2022");
        utilities.checkTextContent(bookTicketPage.getBookTicketInfo("Amount"), "1");
    }

    @Test
    public void TC15() {
        logger.info("TC15_Verify_User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        logger.info("Step 1: Login");
        loginPage.login(email, Constant.PASSWORD);
        logger.info("Step 2: Go to Timetable page");
        generalPage.goToTab("Timetable");
        generalPage.scrollDown();
        logger.info("Step 3: Click on book ticket button routed from Hue to Nha Trang");
        timetablePage.selectTrainFromTrainTimeTable("Huế", "Nha Trang");
        logger.info("Check book ticket page is loaded with correct Depart From and Arrive At");
        utilities.checkSelectedItemList(bookTicketPage.getListDepartFrom(), "Huế");
        utilities.checkSelectedItemList(bookTicketPage.getListArriveAt(), "Nha Trang");
    }

    @Test
    public void TC16() {
        logger.info("TC16_Verify_User can cancel a ticket");
        logger.info("Step 1: Login");
        loginPage.login(email, Constant.PASSWORD);
        logger.info("Step 2: go to My Ticket tab");
        generalPage.goToTab("My ticket");
        logger.info("Step 3: Cancel ticket");
        myTicketPage.cancelTicket();
        logger.info("Check the ticket disappears");
        utilities.checkElementDoesNotExist(myTicketPage.getMyTable());
    }
}

