package tests.page;

import framework.base_element.elements.Label;
import framework.base_form.BaseForm;

public class StudentStartPage extends BaseForm {
    private final Label lblUniqElement = new Label("//*[@name=\"StudentStartPage\"]","Uniq Element Student Start Page");

    public StudentStartPage() {
        super("Student Start Page","//*[@name=\"StudentStartPage\"]","Uniq Element Student Start Page");
    }

    public boolean pageIsDisplayed(){
        return lblUniqElement.isDisplayed();
    }
}
