package framework.base_element.elements;

import framework.base_element.BaseElement;
import org.openqa.selenium.WebElement;

public class Link extends BaseElement {
    private WebElement link;

    public Link(String locator, String name) {
        super(locator, name);
        link = findElement();
    }
}