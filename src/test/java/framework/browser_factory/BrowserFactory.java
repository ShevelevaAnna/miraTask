package framework.browser_factory;

import framework.logger.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utils.ConfigManager;
import java.io.File;
import java.io.IOException;

public abstract class BrowserFactory {
    private static char typeBrowser;

    BrowserFactory(char typeBrowser){
        BrowserFactory.typeBrowser = typeBrowser;
    }

    public static BrowserFactory createBrowser(char typeBrowser){
        Logger.getLogger().info( "Create object browser ("+typeBrowser+")" );
        switch (typeBrowser){
            case 'c':
                return new ChromeBrowser(typeBrowser);
            default:
                Logger.getLogger().error( "don't find browser:" + typeBrowser +". use Chrome");
                return new ChromeBrowser(typeBrowser);
        }
    }

    public static WebDriver getBrowser (char nameBrowser){
        Logger.getLogger().info( "Get driver (browser - "+nameBrowser+")" );
        WebDriver driver;
        switch (nameBrowser){
            case 'c':
                driver = ChromeBrowser.getDriver();
                return driver;
            default:
                Logger.getLogger().error( "don't find browser:" + nameBrowser +". use Chrome");
                driver = ChromeBrowser.getDriver();
                return driver;
        }
    }

    public void windowMaximize(){
        Logger.getLogger().info( "Window maximize" );
        BrowserFactory.getBrowser(typeBrowser).manage().window().maximize();
    }

    public void openURL(String urlPath) {
        Logger.getLogger().info( "Open url - " + urlPath );
        BrowserFactory.getBrowser(typeBrowser).navigate().to(urlPath);
    }

    public void closeBrowser(){
        Logger.getLogger().info( "Close browser" );
        if (BrowserFactory.getBrowser(typeBrowser) != null) {
            BrowserFactory.getBrowser(typeBrowser).quit();
        }
        switch (typeBrowser){
            case 'c':
                ChromeBrowser.driverClose();
                break;
            default:
                Logger.getLogger().error( "don't find browser:" + typeBrowser +". use Chrome");
                ChromeBrowser.driverClose();
                break;
        }
    }

    public void takeScreenshot(){
        Logger.getLogger().info( "Take screenshot" );
        File scrFile = ((TakesScreenshot)BrowserFactory.getBrowser(typeBrowser)).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(scrFile, new File(ConfigManager.readTestSettingsTag("pathScreenshot")));
        }catch (IOException ex){Logger.getLogger().error( "Copy file is fail" );}

    }
}
