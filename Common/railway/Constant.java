package railway;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver DRIVER;
    public static String RAILWAY_SITE = GetConfigProperties.getProperty("RAILWAY_SITE");
    public static String USER_NAME = GetConfigProperties.getProperty("USER_NAME");
    public static String PASSWORD = GetConfigProperties.getProperty("PASSWORD");
    public static String PID_PASSWORD = GetConfigProperties.getProperty("PID_PASSWORD");
    public static String PASSWORD2 = GetConfigProperties.getProperty("PASSWORD2");
    public static String WEB_DRIVER = GetConfigProperties.getProperty("WEB_DRIVER");
    public static String DRIVER_PATH = GetConfigProperties.getProperty("DRIVER_PATH");
    public static String BROWSER = GetConfigProperties.getProperty("BROWSER");

}

