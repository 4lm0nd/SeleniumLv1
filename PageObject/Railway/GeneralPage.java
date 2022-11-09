package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;
import Railway.Constant;

public class GeneralPage {

    //Method
    public void openSite(String site) {
        //Creating an object of ChromeDriver
        System.setProperty(Constant.CHROMEDRIVER, Constant.CHROMEDRIVER_PATH);
        Constant.DRIVER.manage().window().maximize();
        //Deleting all the cookies
        Constant.DRIVER.manage().deleteAllCookies();
        //Specifiying pageLoadTimeout and Implicit wait
        Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //launching the specified URL
        Constant.DRIVER.get(site);
    }

    public void goToTab(String tab) {
        Constant.DRIVER.findElement(By.xpath("//span[text()='" + tab + "']/ancestor::a")).click();
    }

    public void scrollByPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
}



