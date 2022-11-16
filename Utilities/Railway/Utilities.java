package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utilities {

    //Variation
    String tabMenu = "//span[text()='%s']/ancestor::a";

    //Element
    WebElement getTabMenu(String tabName) {
        return Constant.DRIVER.findElement(By.xpath(String.format(tabMenu, tabName)));
    }

    //Method
    public static String convertDateToString() {
        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyymmmddhhmmss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public void checkTextContent(String actualMsg, String expectedMsg) {
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(actualMsg, expectedMsg);
            softAssert.assertAll();

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public boolean doesElementDisplay(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public void checkTabExist(String tabName) {
        try {

            Assert.assertTrue(doesElementDisplay(getTabMenu(tabName)));

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void checkSelectedItemList(WebElement selection, String option) {
        Select selectedValue = new Select(selection);
        WebElement optionA = selectedValue.getFirstSelectedOption();
        String selectedOption = optionA.getText().toString();
        try {
            Assert.assertEquals(selectedOption, option);
        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void checkElementDoesNotExist(WebElement element) {
        try {
            Assert.assertFalse(doesElementDisplay(element) == true);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}


