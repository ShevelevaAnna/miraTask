package framework.base_element.elements;

import framework.base_element.BaseElement;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {
    private WebElement button;

    public Button(String locator, String name) {
        super(locator, name);
        button = findElement();
    }
}
