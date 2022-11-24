package railway;

import org.testng.annotations.Test;

public class Test_draft {
    private static Logger logger = new Logger();
    private static GeneralPage generalPage = new GeneralPage();
    private static LoginPage loginPage = new LoginPage();
    private static Utilities utilities = new Utilities();
    private static BookTicketPage bookTicketPage = new BookTicketPage();
    private static MyTicketPage myTicketPage = new MyTicketPage();

    private final String departStation = "Quảng Ngãi";
    private final String arriveStation = "Nha Trang";
    private final String seatType = "Soft seat with air conditioner";
    private final String amount = "1";
    private final String email = "almond.dh@yopmail.com";
    private final String password = "Password123";

    @Test
    public void draft_test() {
        logger.info("Additional test case for book and cancel multiple tickets");

        generalPage.openSite(Constant.RAILWAY_SITE);
        loginPage.login(email, password);
        for (int i = 0; i < 6; i++) {
            bookTicketPage.bookTicket(
                    utilities.getDateLaterFromCurrentDate(7), departStation, arriveStation, seatType, amount);
        }
        generalPage.goToTab("My ticket");
        generalPage.scrollPageDown();
        myTicketPage.cancelAllTickets();
        String myTableInfo = myTicketPage.getMyTableTextContent();
        String ticketInfo = departStation + " " + arriveStation + " " + seatType + " " + utilities.getDateLaterFromCurrentDate(7);
        utilities.checkTextDoesNotContain(myTableInfo, ticketInfo);
        BrowserManager.DRIVER.quit();
    }
}
