package Railway;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class Logger {

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(Logger.class);

    static {
        String log4jConfPath = "Resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    public static void info(String message) {
        logger.info(String.format(message));
    }

}

