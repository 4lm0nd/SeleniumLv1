package railway;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {

    //Method
    public static String convertDateToString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constant.FULL_DATETIME);
        LocalDateTime localDate = LocalDateTime.now();
        String strDate = dateFormat.format(localDate);
        return strDate;
    }

    public static void checkTextContain(String actualMsg, String expectedMsg) {
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(actualMsg, expectedMsg);
            softAssert.assertAll();

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static boolean doesElementDisplay(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static void checkElementExist(WebElement element) {
        try {
            Assert.assertTrue(doesElementDisplay(element));
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        } catch (AssertionError error) {
            System.out.println(error.getMessage());

        }
    }

    public static void checkSelectedItem(WebElement selection, String option) {
        Select selectedValue = new Select(selection);
        WebElement optionA = selectedValue.getFirstSelectedOption();
        String selectedOption = optionA.getText();
        try {
            Assert.assertEquals(selectedOption, option);
        } catch (AssertionError ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkElementDoesNotExist(WebElement element) {

        try {
            Assert.assertFalse(doesElementDisplay(element));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (AssertionError error) {
            System.out.println(error.getMessage());
        }
    }

    public static String getDateLaterFromCurrentDate(int days) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constant.SHORT_DATE_US);
        LocalDate localDate = LocalDate.now().plusDays(days);
        String fromDateFormat = dateFormat.format(localDate);
        return fromDateFormat;
    }

    public static void checkTextDoesNotContain(String actualMsg, String expectedMsg) {
        try {
            Assert.assertFalse(actualMsg.contains(expectedMsg));

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        } catch (StringIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public String getExpectedMSg(String fileData, String jsNote) {
        String message = ReadFileJson.getJsonValue(fileData, jsNote);
        return message;
    }
}






