package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public void openSite(String site) {
        //Creating an object of ChromeDriver
        Constant.DRIVER = new ChromeDriver();
        System.setProperty(Constant.CHROMEDRIVER, Constant.CHROMEDRIVER_PATH);
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        Constant.DRIVER.manage().window().maximize();
        //Deleting all the cookies
        Constant.DRIVER.manage().deleteAllCookies();
        //Specifiying pageLoadTimeout and Implicit wait
        Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //launching the specified URL
        Constant.DRIVER.get(site);
        Constant.DRIVER.navigate().refresh();
    }
}
