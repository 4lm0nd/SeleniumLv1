package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import Railway.Constant;

import static org.openqa.selenium.By.*;

public class GeneralPage {

    public void OpenRailway() {



//Creating an object of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        Constant.driver.manage().window().maximize();

//Deleting all the cookies
        Constant.driver.manage().deleteAllCookies();

//Specifiying pageLoadTimeout and Implicit wait
        Constant.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        Constant.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//launching the specified URL
        Constant.driver.get(Constant.Railway_Site);

     }

     public void GotoTab (String _tab){

    Constant.driver.findElement(By.xpath("//span[text()='"+_tab+"']/ancestor::a")).click();


     }

}



