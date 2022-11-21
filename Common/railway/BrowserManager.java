package railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static void openBrowser(String browserName, String webDriver, String driverPath) {
        driverBrowser(browserName, webDriver, driverPath);
        Constant.DRIVER.manage().window().maximize();
        Constant.DRIVER.manage().deleteAllCookies();
        Constant.DRIVER.manage().timeouts().pageLoadTimeout(Constant.WAIT_SHORT_TIME, TimeUnit.SECONDS);
        Constant.DRIVER.manage().timeouts().implicitlyWait(Constant.WAIT_SHORT_TIME, TimeUnit.SECONDS);
    }

    public static void driverBrowser(String browserName, String webDriver, String driverPath) {
        System.setProperty(webDriver, driverPath);
        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                Constant.DRIVER = new FirefoxDriver();
                break;
            case "CHROME":
                Constant.DRIVER = new ChromeDriver();
                break;
            case "IE":
                Constant.DRIVER = new InternetExplorerDriver();
                break;
            case "SAFARI":
                Constant.DRIVER = new SafariDriver();
                break;
        }
    }
}

