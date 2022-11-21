package railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static void openBrowser(String browserName, String webDriver, String driverPath) {
        driverBrowser(browserName, webDriver, driverPath);
        maximizeWindow();
        deleteAllCookies();
        setImplicitlyWait(Constant.WAIT_SHORT_TIME);
        setPageLoadTimeout(Constant.WAIT_SHORT_TIME);
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

    public static void maximizeWindow() {
        Constant.DRIVER.manage().window().maximize();
    }

    public static void deleteAllCookies() {
        Constant.DRIVER.manage().deleteAllCookies();
    }

    public static void setImplicitlyWait(int timeToWait) {
        Constant.DRIVER.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public static void setPageLoadTimeout(int timeToWait) {
        Constant.DRIVER.manage().timeouts().pageLoadTimeout(timeToWait, TimeUnit.SECONDS);
    }


}

