package framework.browser_factory;

import framework.logger.Logger;
import utils.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

class ChromeBrowser extends BrowserFactory {
    private static WebDriver driver;
    private static final String localization = ConfigManager.readTestSettingsTag("localization");

    ChromeBrowser(char typeBrowser) {
        super(typeBrowser);
    }

    static WebDriver getDriver(){
        Logger.getLogger().info( "get chrome driver" );
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    static void driverClose(){
        if (driver != null) {
            driver = null;
        }
    }

    private static void createDriver(){
        Logger.getLogger().info( "create chrome driver" );
        WebDriverManager.chromedriver().setup();
        Logger.getLogger().info( "set localization: " + localization );
        ChromeOptions chromeOptions = new ChromeOptions();
        Map prefs = new HashMap();
        prefs.put("intl.accept_languages", localization);
        chromeOptions.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver();
    }
}