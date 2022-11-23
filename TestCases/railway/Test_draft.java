package railway;

import org.testng.annotations.Test;

public class Test_draft {

    private static String jsFile = "TestData/Login.json";
    private static Logger logger = new Logger();
    private static GeneralPage generalPage = new GeneralPage();
    private static LoginPage loginPage = new LoginPage();
    private static Utilities utilities = new Utilities();
    private static RegisterPage registerPage = new RegisterPage();
    private static BookTicketPage bookTicketPage = new BookTicketPage();
    private static MyTicketPage myTicketPage = new MyTicketPage();
    private static TimetablePage timetablePage = new TimetablePage();
    private static HomePage homePage = new HomePage();
    private static final String departStation = ReadFileJson.getJsonValue("BookTicket.json", "depart station");
    private static final String arriveStation = ReadFileJson.getJsonValue("BookTicket.json", "arrive station");
    private static final String seatType = ReadFileJson.getJsonValue("BookTicket.json", "seat type");
    private static final String amount = ReadFileJson.getJsonValue("BookTicket.json", "amount");
    private final String email = ReadFileJson.getJsonValue("Login.json", "username");
    private final String password = ReadFileJson.getJsonValue("Login.json", "password");

    @Test
    public void draft_test() {
        logger.info("Additional test case for book and cancel multiple tickets");

        generalPage.openSite(Constant.RAILWAY_SITE);
        loginPage.login(email, password);
        for (int i = 0; i < 6; i++)
        {
            bookTicketPage.bookTicket
                    (utilities.getDateLaterFromCurrentDate(7), departStation, arriveStation, seatType, amount);
        }
        generalPage.goToTab("My ticket");
        generalPage.scrollPageDown();
        myTicketPage.cancelAllTickets();
        String myTableInfo = myTicketPage.getMyTableTextContent();
        String ticketInfo = departStation + " " + arriveStation + " " + seatType + " " + utilities.getDateLaterFromCurrentDate(7).toString();
        utilities.checkTextDoesNotContent(myTableInfo, ticketInfo);
        BrowserManager.DRIVER.quit();
    }
}
