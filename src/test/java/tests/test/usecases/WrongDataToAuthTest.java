package tests.test.usecases;

import framework.base_form.form.AlertForm;
import framework.logger.Logger;
import org.testng.Assert;
import tests.page.AuthPage;
import org.testng.annotations.Test;
import tests.test.BaseTest;
import tests.utils.ParametersForTest;

public class WrongDataToAuthTest extends BaseTest {
    /**
     * Шаг 1: Ввод неверных логина и пароля / верного логина и неверного пароля / неверного логина и верного пароля. Кликнуть на вход.
     * Ожидание: Появление алерт-формы с текстом: Неверные данные для авторизации.
     */
    @Test(dataProvider = "wrongDataToAuthData",dataProviderClass = ParametersForTest.class)
    public void wrongDataToAuth(String login, String password) {
        Logger.getLogger().info( "Wrong data to auth test" );
        AuthPage authPage = new AuthPage();
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickEntry();
        AlertForm alert = new AlertForm();
        alert.waitAlertForm();
        Assert.assertEquals(alert.getText(),"Неверные данные для авторизации","Alert is not correct");
        alert.pressOK();
    }
}
