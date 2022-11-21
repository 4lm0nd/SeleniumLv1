package railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseOpenBookTicketFromTimeTable {

    private static final String email = ReadFileJson.getJsonValue("Login.json", "username");
    private static final String password = ReadFileJson.getJsonValue("Login.json", "password");
    private static final Utilities utilities = new Utilities();
    private static final LoginPage loginPage = new LoginPage();
    private static final BookTicketPage bookTicketPage = new BookTicketPage();
    private static final TimetablePage timetablePage = new TimetablePage();
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
    public void TC15_Open_BookTicketPage_from_TrainTimeTable() {
        logger.info("TC15_Verify_User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        logger.info("Step 1: Login");
        loginPage.login(email, password);
        logger.info("Step 2: Go to Timetable page");
        generalPage.goToTab("Timetable");
        logger.info("Step 3: Click on book ticket button routed from Hue to Nha Trang");
        generalPage.scrollPageDown();
        timetablePage.selectTrainFromTrainTimeTable("Huế", "Nha Trang");
        logger.info("Check book ticket page is loaded with correct Depart From and Arrive At");
        utilities.checkSelectedItem(bookTicketPage.getListDepartFrom(), "Huế");
        utilities.checkSelectedItem(bookTicketPage.getListArriveAt(), "Nha Trang");
    }
}

