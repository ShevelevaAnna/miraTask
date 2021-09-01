package framework.base_element;

import framework.browser_factory.BrowserFactory;
import framework.logger.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.utils.DriverUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public abstract class BaseElement {
    private String locator;
    private String name;
    private WebElement baseElement;

    public BaseElement(String locator, String name){
        Logger.getLogger().info("Create element "+name+", locator - "+locator);
        this.locator = locator;
        this.name = name;
        baseElement = findElement();
    }

    public String getLocator(){ return locator; }

    public String getName(){ return name; }

    protected WebElement findElement(){
        Logger.getLogger().info("Find element "+name+", locator - "+locator);
        List<WebElement> element = BrowserFactory.getBrowser(DriverUtils.typeDriver).findElements(By.xpath(locator));
        if (element.size() == 0) {
            Logger.getLogger().error( "Element was not found on the page");
            return null;
        } else return element.get(0);
    }

    public String getText(){
        Logger.getLogger().info("Get text element element "+name+", locator - "+locator);
        return baseElement.getText();
    }

    public boolean isDisplayed(){
        Logger.getLogger().info("Is displayed element "+name+", locator - "+locator);
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getBrowser(DriverUtils.typeDriver),
                DriverUtils.timeWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return baseElement.isDisplayed();
    }

    public void click(){
        Logger.getLogger().info("Click on "+name+", locator - "+locator);
        baseElement.click();
    }
}
