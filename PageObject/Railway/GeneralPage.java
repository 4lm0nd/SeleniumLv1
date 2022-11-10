package Railway;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import Railway.Constant;

public class GeneralPage {

    //Method
        public void scrollByPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void goToTab(String tab) {
        Constant.DRIVER.findElement(By.xpath("//span[text()='" + tab + "']/ancestor::a")).click();
    }
}



