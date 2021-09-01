package tests.page;

import framework.base_element.elements.Button;
import framework.base_element.elements.Label;
import framework.base_element.elements.Link;
import framework.base_element.elements.TextBox;
import framework.base_form.BaseForm;

public class ForgotPasswordPage extends BaseForm {
    TextBox tbLoginOrEmail = new TextBox("//*[@name=\"loginOrEmail\"]","Login or email textbox");
    Link linkBack = new Link("//*[contains(@class,\"forgot-password-link\")]","Back link");
    Label lblSuccessLogin = new Label("//*[@class=\"success\"]","Success login label");
    Label lblFailLogin = new Label("//*[@class=\"alert\"]","Fail login label");
    Button btnSendLogin = new Button("//*[contains(@class,\"forgot-password-button\")]","Send login button");
    private final Label lblUniqElement = new Label("//*[@class=\"mira-forgot-password-form\"]","Uniq Element Forgot Password Page");

    public ForgotPasswordPage() {
        super("Forgot Password Page","//*[@class=\"mira-forgot-password-form\"]","Uniq Element Forgot Password Page");
    }

    public boolean formIsDisplayed(){return lblUniqElement.isDisplayed();}

    public void clickBack(){linkBack.click();}

    public void inputLoginOrEmail(String login){ tbLoginOrEmail.clearAndType(login); }

    public String getTextSuccess(){ return lblSuccessLogin.getText(); }

    public String getTextFail(){ return lblFailLogin.getText(); }

    public void clickSendLogin(){btnSendLogin.click();}
}
