package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Railway_TC14_15_VerifyBookTicket {

    Utilities utilities = new Utilities();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    DriverManager driverManager = new DriverManager();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimetablePage timetablePage = new TimetablePage();
    GeneralPage generalPage = new GeneralPage();
    String email = "al" + Constant.convertDateToString() + "@yopmail.com";

    @BeforeMethod
    public void beforeMethod() {
        driverManager = new DriverManager();
        driverManager.openSite(Constant.RAILWAY_SITE);
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }
    @Test
    public void TC14() {
        System.out.println("TC14_Verify_User can book 1 ticket at a time");
        bookTicketPage.bookTicket("11/20/2022", "Quảng Ngãi", "Nha Trang", "Soft seat with air conditioner", "1");
        String actualMsg = "Ticket booked successfully!";
        String expectedMsg = bookTicketPage.getMsgSuccess().getText().toString();
        utilities.checkTextContent(actualMsg, expectedMsg);
        utilities.checkBookedTicketInfo("11/20/2022", "Quảng Ngãi", "Nha Trang", "Soft seat with air conditioner", "1");
    }
    @Test
    public void TC15(){
        System.out.println("TC15_Verify_User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        generalPage.goToTab("Timetable");
        generalPage.scrollByPage();
        timetablePage.clickBtnBookTicketFromTrainTable("Phan Thiết", "Sài Gòn");
        utilities.checkSelectedItemList(bookTicketPage.getListDepartFrom(), "Phan Thiết");
        utilities.checkSelectedItemList(bookTicketPage.getListArriveAt(), "Sài Gòn");
    }
}
