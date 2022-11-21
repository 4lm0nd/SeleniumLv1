package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage extends GeneralPage {

    //Locator
    private static final By listDepartDate = By.xpath("//select[@name = 'Date']");
    private static final By btnBookTicket = By.xpath("//input[@value ='Book ticket']");
    private static final By listDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private static final By listArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private static final By listSeatType = By.xpath("//select[@name ='SeatType']");
    private static final By listTicketAmount = By.xpath("//select[@name ='TicketAmount']");
    private static final By msgSuccess = By.xpath("//div[@id='content']/h1");

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
        scrollToFindElement(getBtnBookTicket());
        selectItemFromList(listDepartDate, departDate);
        selectItemFromList(listDepartFrom, departStation);
        waitForControl(listArriveAt, 3);
        selectItemFromList(listArriveAt, arriveStation);
        selectItemFromList(listSeatType, seatType);
        selectItemFromList(listTicketAmount, ticketAmount);
        waitForControl(btnBookTicket, Constant.WAIT_CONTROL_TIME);
        getBtnBookTicket().click();
    }

    public String getSuccessMsg() {
        return getMsgSuccess().getText();
    }

    public String getBookTicketInfo(String column) {
        return getTableCellValue("MyTable WideTable", column, 2);
    }
}








