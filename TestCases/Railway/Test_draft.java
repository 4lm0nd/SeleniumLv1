package Railway;

import org.apache.log4j.Logger;
import org.example.Main;

public class Test_draft {

     private static Logger logger = Logger.getRootLogger();
    static GeneralPage generalPage = new GeneralPage();
    static LoginPage loginPage = new LoginPage();
    static DriverManager driverManager;
    static Utilities utilities = new Utilities();
    static RegisterPage registerPage = new RegisterPage();
    static BookTicketPage bookTicketPage = new BookTicketPage();
    static MyTicketPage myTicketPage = new MyTicketPage();
    static TimetablePage timetablePage = new TimetablePage();

    public static void main(String[] args) {
        logger.info("This is a test test");
        System.out.println("hi hi hi");
        driverManager = new DriverManager();
        driverManager.openSite(Constant.RAILWAY_SITE);
        loginPage.login(Constant.USER_NAME2, Constant.PASSWORD);
        generalPage.goToTab("Timetable");
        generalPage.scrollByPage();
        timetablePage.clickBtnBookTicketFromTrainTable("Huế", "Sài Gòn");
        utilities.checkSelectedItemList(bookTicketPage.getListDepartFrom(), "Huế");
        utilities.checkSelectedItemList(bookTicketPage.getListArriveAt(), "Sài Gòn");
    }
}
