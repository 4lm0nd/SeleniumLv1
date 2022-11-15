package Railway;

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
        logger.info("Step 1: Login");
        generalPage.openSite(Constant.RAILWAY_SITE);
        loginPage.login(Constant.USER_NAME, Constant.PASSWORD);
        logger.info("Step 2: Go to Timetable page");
        generalPage.goToTab("Timetable");
        generalPage.scrollDown();
        logger.info("Step 3: Click on book ticket button routed from Phan Thiet to Sai Gon");
        timetablePage.selectTrainFromTrainTimeTable("Huế", "Nha Trang");
        logger.info("Check book ticket page is loaded with correct Depart From and Arrive At");
        utilities.checkSelectedItemList(bookTicketPage.getListDepartFrom(), "Huế");
        utilities.checkSelectedItemList(bookTicketPage.getListArriveAt(), "Nha Trang");
    }
}
