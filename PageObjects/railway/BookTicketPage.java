package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage extends GeneralPage {

    //Locator
    private final By listDepartDate = By.xpath("//select[@name = 'Date']");
    private final By btnBookTicket = By.xpath("//input[@value ='Book ticket']");
    private final By listDepartFrom = By.xpath("//select[@name ='DepartStation']");
    private final By listArriveAt = By.xpath("//select[@name ='ArriveStation']");
    private final By listSeatType = By.xpath("//select[@name ='SeatType']");
    private final By listTicketAmount = By.xpath("//select[@name ='TicketAmount']");
    private final By msgSuccess = By.xpath("//div[@id='content']/h1");

    //Element
    private WebElement getListDepartDate() {
        return BrowserManager.DRIVER.findElement(listDepartDate);
    }

    private WebElement getBtnBookTicket() {
        return BrowserManager.DRIVER.findElement(btnBookTicket);
    }

    private WebElement getListDepartFrom() {
        return BrowserManager.DRIVER.findElement(listDepartFrom);
    }

    private WebElement getListArriveAt() {
        return BrowserManager.DRIVER.findElement(listArriveAt);
    }

    private WebElement getListSeatType() {
        return BrowserManager.DRIVER.findElement(listSeatType);
    }

    private WebElement getListTicketAmount() {
        return BrowserManager.DRIVER.findElement(listTicketAmount);
    }

    private WebElement getMsgSuccess() {
        return BrowserManager.DRIVER.findElement(msgSuccess);
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        goToTab("Book ticket");
        scrollToFindElement(getBtnBookTicket());
        selectItemFromList(listDepartDate, departDate);
        selectItemFromList(listDepartFrom, departStation);
        waitForControl(listArriveAt, Constant.WAIT_CONTROL_TIME);
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

    public String getDepartStation() {
        return getSelectedItem(getListDepartFrom());
    }

    public String getArriveStation() {
        return getSelectedItem(getListArriveAt());
    }

}








