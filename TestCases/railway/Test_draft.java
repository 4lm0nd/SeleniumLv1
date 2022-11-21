package railway;

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

    public static void main(String[] args) {
        logger.info("TC14_Verify_User can book 1 ticket at a time");
        logger.info("Step 1: Login");
        generalPage.openSite(Constant.RAILWAY_SITE);
        loginPage.login("almond.dh@yopmail.com", ReadFileJson.getJsonValue("Login.json","password"));
        logger.info("Step 2: Book a ticket");
        bookTicketPage.bookTicket(
                utilities.getDateLaterFromCurrentDate(7),
                ReadFileJson.getJsonValue("BookTicket.json","depart station"),
                ReadFileJson.getJsonValue("BookTicket.json","arrive station"),
                ReadFileJson.getJsonValue("BookTicket.json","seat type"),
                ReadFileJson.getJsonValue("BookTicket.json","amount"));
    }
}
