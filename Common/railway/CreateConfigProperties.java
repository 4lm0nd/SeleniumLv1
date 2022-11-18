package railway;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CreateConfigProperties {

    public static void main(String[] args) {

        String configPropertiesPath = "Resources/config.properties";

        try (OutputStream output = new FileOutputStream(configPropertiesPath)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("RAILWAY_SITE","http://www.railwayb1.somee.com");
            prop.setProperty("USER_NAME","almond.dh@yopmail.com");
            prop.setProperty("PASSWORD","Password123");
            prop.setProperty("PID_PASSWORD","Password123");
            prop.setProperty("PASSWORD2","Password122");
            prop.setProperty("WEB_DRIVER","webdriver.chrome.driver");
            prop.setProperty("DRIVER_PATH","Executables/chromedriver.exe");
            prop.setProperty("BROWSER","CHROME");

            // save properties to project root folder
            prop.store(output, null);
            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

