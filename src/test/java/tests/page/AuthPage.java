package tests.page;

import framework.base_element.elements.Button;
import framework.base_element.elements.Label;
import framework.base_element.elements.Link;
import framework.base_element.elements.TextBox;
import framework.base_form.BaseForm;

public class AuthPage extends BaseForm {
    private final TextBox tbLogin= new TextBox("//*[@name=\"user\"]","Login text box");
    private final TextBox tbPassword = new TextBox("//*[@name=\"password\"]","Password text box");
    private final Button btnEntry = new Button("//*[@id=\"button_submit_login_form\"]","Entry button");
    private final Button btnMiraLogin = new Button("//*[@class=\"mira-widget-login-button\"]","Mira login button");
    private final Link linkForgotPassword = new Link("//*[@class=\"mira-default-login-page-link\"]","Link forgot password");
    private final Label lblUniqElement = new Label("//*[@class=\"mira-page-login\"]","Uniq Element Auth Page");

    public AuthPage() {
        super("Auth Page","//*[@class=\"mira-page-login\"]","Uniq Element Auth Page");
    }

    public void inputLogin(String login){
        tbLogin.clearAndType(login);
    }

    public void inputPassword(String password){
        tbPassword.clearAndType(password);
    }

    public void clickEntry(){
        btnEntry.click();
    }

    public void clickMiraLogin(){
        btnMiraLogin.click();
    }

    public void clickForgotPassword(){linkForgotPassword.click();}

    public boolean pageIsDisplayed(){ return lblUniqElement.isDisplayed(); }
}
