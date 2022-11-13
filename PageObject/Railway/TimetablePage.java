package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {

    String timeTable = "MyTable WideTable";

    public int getTimeTableRow(String departStation, String arriveStation, int rows, String table) {
        for (int i = 1; i < rows; i++) {
            if (getTableCellValue(table, "Depart Station", i) == departStation && getTableCellValue(table, "Arrive Station", i) == arriveStation) {

                i = rows;
                return rows;
            }
        }
        return 1;
    }

    public void clickBtnBookTicketFromTrainTable(String departStation, String arriveStation) {
        int a = getTimeTableRow(departStation, arriveStation, 25, timeTable);

        if (a != 0) {
            WebElement btnBookTicket = Constant.DRIVER.findElement(By.xpath("//table[@class='" + timeTable + "']//tr[" + a + "]/td[7]/a"));
            btnBookTicket.click();

        } else {
            System.out.println("This train is not found");

        }
    }


}



