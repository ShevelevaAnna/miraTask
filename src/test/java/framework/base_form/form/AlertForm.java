package framework.base_form.form;

import framework.browser_factory.BrowserFactory;
import framework.logger.Logger;
import framework.utils.DriverUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertForm {
    private Alert alert;

    public void waitAlertForm(){
        Logger.getLogger().info("Wait load alert");
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getBrowser(DriverUtils.typeDriver),
                DriverUtils.timeWait);
        alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    public void pressOK(){
        Logger.getLogger().info("Accept with alert");
        alert.accept();
        alert = null;
    }

    public String getText(){
        Logger.getLogger().info("Get text alert");
        return alert.getText();
    }
}
