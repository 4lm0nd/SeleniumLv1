package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyCancelTicket {

    static Logger logger = new Logger();
    static GeneralPage generalPage = new GeneralPage();
    static LoginPage loginPage = new LoginPage();
    static Utilities utilities = new Utilities();
    static RegisterPage registerPage = new RegisterPage();
    static BookTicketPage bookTicketPage = new BookTicketPage();
    static MyTicketPage myTicketPage = new MyTicketPage();
    static TimetablePage timetablePage = new TimetablePage();
    static HomePage homePage = new HomePage();
    String email = "al" + Utilities.convertDateToString() + "@yopmail.com";

    @BeforeMethod
    public void beforeMethod() {
        generalPage.openSite(Constant.RAILWAY_SITE);
        registerPage.register(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        loginPage.login(email,Constant.PASSWORD);
        bookTicketPage.bookTicket("11/20/2022", "Quảng Ngãi", "Nha Trang", "Soft seat with air conditioner", "1");
    }

    @AfterMethod
    public void afterMethod() {
        Constant.DRIVER.close();
    }

    @Test
    public void TC16() {
        generalPage.goToTab("My ticket");
        myTicketPage.cancelTicket();
    }


}
