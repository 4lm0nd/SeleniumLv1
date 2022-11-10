package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Utilities {


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
            Assert.assertEquals(doesElementDisplay(item),true);

        } catch (AssertionError ex) {

            System.out.println(ex.getMessage());
        }

        }
}

