package framework.base_element.elements;

import framework.base_element.BaseElement;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement {
    private WebElement label;

    public Label(String locator, String name) {
        super(locator, name);
        label = findElement();
    }
}
