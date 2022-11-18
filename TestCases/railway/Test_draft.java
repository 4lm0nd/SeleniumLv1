package railway;

public class Test_draft {

    static Logger logger = new Logger();
    static GeneralPage generalPage = new GeneralPage();
    static LoginPage loginPage = new LoginPage();
    static Utilities utilities = new Utilities();
    static RegisterPage registerPage = new RegisterPage();
    static BookTicketPage bookTicketPage = new BookTicketPage();
    static MyTicketPage myTicketPage = new MyTicketPage();
    static TimetablePage timetablePage = new TimetablePage();
    static HomePage homePage = new HomePage();

    public static void main(String[] args) {
        logger.info("TC15_Verify_User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        System.out.println("This for test github");
        generalPage.openSite(Constant.RAILWAY_SITE);
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
        generalPage.goToTab("Timetable");
        timetablePage.selectTrainFromTrainTimeTable("Huế", "Nha Trang");
    }
}
