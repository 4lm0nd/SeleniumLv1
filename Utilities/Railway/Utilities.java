package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Utilities extends GeneralPage {

    public void checkTextContent(String actualMsg, String expectedMsg) {
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(actualMsg, expectedMsg);
            softAssert.assertAll();

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public boolean doesElementDisplay(By by) {
        try {
            Constant.DRIVER.findElement(by).isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public void checkTabExist(String tab) {
        By item = (By.xpath("//span[text()='" + tab + "']/ancestor::a"));
        try {
            Assert.assertEquals(doesElementDisplay(item), true);

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void checkSelectedItemList(WebElement selection, String option) {
        Select selected1 = new Select(selection);
        WebElement optionA = selected1.getFirstSelectedOption();
        String a = optionA.getText().toString();
        try {
            Assert.assertEquals(a, option);
        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void checkBookedTicketInfo(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {

        String tableXpath = "MyTable WideTable";
        String departFrom = getTableCellValue(tableXpath, "Depart Station", 2);
        String arriveAt = getTableCellValue(tableXpath, "Arrive Station", 2);
        String seat = getTableCellValue(tableXpath, "Seat Type", 2);
        String dateDepart = getTableCellValue(tableXpath, "Depart Date", 2);
        String amountTicket = getTableCellValue(tableXpath, "Amount", 2);
        try {

            Assert.assertEquals(dateDepart, departDate);
            Assert.assertEquals(departFrom, departStation);
            Assert.assertEquals(arriveAt, arriveStation);
            Assert.assertEquals(seatType, seat);
            Assert.assertEquals(amountTicket, ticketAmount);

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }
}




