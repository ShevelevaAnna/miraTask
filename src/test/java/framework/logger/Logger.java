package framework.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.apache.log4j.PropertyConfigurator;

public class Logger {
    private final static Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(Logger.class);
    static {
        PropertyConfigurator.configure(Logger.class.getClassLoader().getResource("log4j.properties"));
    }

    public static Log4jLoggerAdapter getLogger() {
        return log;
    }
}
