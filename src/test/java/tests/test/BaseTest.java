package tests.test;
import framework.browser_factory.BrowserFactory;
import framework.logger.Logger;
import utils.ConfigManager;
import framework.utils.DriverUtils;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected static BrowserFactory browser;
    private static final String mainPage = ConfigManager.readTestSettingsTag("mainPage");

    @BeforeTest
    public static void setUp() {
        Logger.getLogger().info( "Setting setUp" );
        browser = BrowserFactory.createBrowser(DriverUtils.typeDriver);
        BrowserFactory.getBrowser(DriverUtils.typeDriver);
        browser.openURL(mainPage);
        browser.windowMaximize();
    }

    @AfterTest
    public static void tearDown() {
        Logger.getLogger().info( "Setting tearDown" );
        browser.closeBrowser();
    }
}