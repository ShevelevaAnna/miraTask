package framework.base_element.elements;

import framework.base_element.BaseElement;
import framework.logger.Logger;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement {
    private WebElement textBox;

    public TextBox(String locator, String name) {
        super(locator, name);
        textBox = findElement();
    }

    public void clearAndType(String text){
        Logger.getLogger().info("Clear and type textbox "+getName()+", locator - "+getLocator());
        textBox.clear();
        textBox.sendKeys(text);
    }
}
