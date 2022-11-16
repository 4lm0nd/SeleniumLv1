package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static void openBrowser(String browserName, String webDriver, String driverPath) {
        System.setProperty(webDriver,driverPath);
        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                Constant.DRIVER = new FirefoxDriver();
                Constant.DRIVER.manage().window().maximize();
                Constant.DRIVER.manage().deleteAllCookies();
                FirefoxOptions firefoxOptions = new FirefoxOptions().setHeadless(true);
                Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "CHROME":
                Constant.DRIVER = new ChromeDriver();
                Constant.DRIVER.manage().window().maximize();
                Constant.DRIVER.manage().deleteAllCookies();
                ChromeOptions chromeOptions = new ChromeOptions().setHeadless(true);
                Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "IE":
                Constant.DRIVER = new InternetExplorerDriver();
                Constant.DRIVER.manage().window().maximize();
                Constant.DRIVER.manage().deleteAllCookies();
                Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            case "SAFARI":
                Constant.DRIVER = new SafariDriver();
                Constant.DRIVER.manage().window().maximize();
                Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            default:
                Constant.DRIVER = new ChromeDriver();
                Constant.DRIVER.manage().window().maximize();
                Constant.DRIVER.manage().deleteAllCookies();
                ChromeOptions options = new ChromeOptions().setHeadless(true);
                Constant.DRIVER.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                Constant.DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }
}
