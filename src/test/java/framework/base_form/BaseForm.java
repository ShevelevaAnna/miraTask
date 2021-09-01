package framework.base_form;

import framework.base_element.elements.Label;
import framework.browser_factory.BrowserFactory;
import framework.logger.Logger;
import framework.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseForm {
    private Label uniqElement;

    public BaseForm(String nameForm, String locator, String nameElement){
        Logger.getLogger().info( "Create Base form "+nameForm+", element "+nameElement+" (locator - "+locator+")" );
        uniqElement = new Label(locator, nameElement);
        waitTextToBe();
    }

    private void waitTextToBe(){
        Logger.getLogger().info("Wait load element ");
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getBrowser(DriverUtils.typeDriver),
                DriverUtils.timeWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uniqElement.getLocator())));
    }
}
