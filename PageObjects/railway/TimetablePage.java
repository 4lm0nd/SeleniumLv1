package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    //Locator
    String timeTable = "MyTable WideTable";
    String bookTicketBtn = "//table[@class='%s']//tr[%d]/td[last()]/a";

    WebElement getBtnBookTicket(String table, int row) {
        return Constant.DRIVER.findElement(By.xpath(String.format(bookTicketBtn, table, row)));
    }
    public void selectTrainFromTrainTimeTable(String departStation, String arriveStation) {
        int a = getTableRow(timeTable,departStation, arriveStation, 25);
        if (a != 0) {
            scrollToFindElement(getBtnBookTicket(timeTable,a));
            getBtnBookTicket(timeTable, a).click();
        } else {
            System.out.println("This train is not found");
        }
    }
}



