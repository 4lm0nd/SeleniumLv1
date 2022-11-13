package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage extends GeneralPage {
    //Locator
    private By listDepartDate = By.xpath("//select[@name = 'Date']");
    private By btnBookTicket = By.xpath("//input[@value ='Book ticket']");
    private By listDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private By listArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private By listSeatType = By.xpath("//select[@name ='SeatType']");
    private By listTicketAmount = By.xpath("//select[@name ='TicketAmount']");
    private By msgSuccess = By.xpath("//div[@id='content']/h1");

    //Element
    public WebElement getListDepartDate() {
        return Constant.DRIVER.findElement(listDepartDate);
    }

    public WebElement getBtnBookTicket() {
        return Constant.DRIVER.findElement(btnBookTicket);
    }

    public WebElement getListDepartFrom() {
        return Constant.DRIVER.findElement(listDepartFrom);
    }

    public WebElement getListArriveAt() {
        return Constant.DRIVER.findElement(listArriveAt);
    }

    public WebElement getListSeatType() {
        return Constant.DRIVER.findElement(listSeatType);
    }

    public WebElement getListTicketAmount() {
        return Constant.DRIVER.findElement(listTicketAmount);
    }

    public WebElement getMsgSuccess() {
        return Constant.DRIVER.findElement(msgSuccess);
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        goToTab("Book ticket");
        scrollByPage();
        selectItemFromList(listDepartDate, departDate);
        selectItemFromList(listDepartFrom, departStation);
        selectItemFromList(listArriveAt, arriveStation);
        selectItemFromList(listSeatType, seatType);
        selectItemFromList(listTicketAmount, ticketAmount);
        waitForControl(btnBookTicket,5);
        getBtnBookTicket().click();

    }
}







