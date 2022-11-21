package railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    //Locator
   private static final String timeTable = "MyTable WideTable";
    private final String bookTicketBtn = "//table[@class='%s']//tr[%d]/td[last()]/a";

    WebElement getBtnBookTicket(int row) {
        return Constant.DRIVER.findElement(By.xpath(String.format(bookTicketBtn, timeTable, row)));
    }
    public void selectTrainFromTrainTimeTable(String departStation, String arriveStation) {
        int a = getTableRow(timeTable,departStation, arriveStation, 25);
        if (a != 0) {
            scrollToFindElement(getBtnBookTicket(a));
            getBtnBookTicket(a).click();
        } else {
            System.out.println("This train is not found");
        }
    }
}



