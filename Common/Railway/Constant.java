package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constant {

    public static WebDriver DRIVER;
    public static final String RAILWAY_SITE = "http://www.railwayb1.somee.com/";
    public static final String USER_NAME = "almond.dh@yopmail.com";
    public static final String USER_NAME2 = "almond.dh1@yopmail.com";
    public static final String PASSWORD = "Password1@!";
    public static final String CHROMEDRIVER = "webdriver.chrome.driver";
    public static final String CHROMEDRIVER_PATH = "Executables/chromedriver.exe";
    public static  String convertDateToString()
    {
        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyymmmddhhmmss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

}

