
import Common.Constants;
import org.openqa.selenium;


public class GeneralPage {

    //locator

    private By _hometab = By.XPath("//a[@href='../']");
    private By _logintab = By.XPath("//a[@href='/Account/Login.cshtml']");
    private By _registab = By.XPath("//a[@href='/Account/Register.cshtml']");
    private By _changepasstab = By.XPath("//a[@href='/Account/ChangePassword.cshtml']");
    private By _logouttab = By.XPath("//a[@href='/Account/Logout']");
    private By _booktickettab = By.XPath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By _timetabletab = By.XPath("//a[@href='TrainTimeListPage.cshtml']");
    private By _ticketpricetab = By.XPath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private By _mytickettab = By.XPath("//a[@href='/Page/ManageTicket.cshtml']");

}
