package tests.test.usecases;

import framework.logger.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.page.AuthPage;
import tests.page.ForgotPasswordPage;
import tests.test.BaseTest;
import tests.utils.RandomUtils;
import utils.ConfigManager;

public class ForgotPasswordTest extends BaseTest {
    private final String wrongLogin = RandomUtils.randomText(10);
    private final String correctLogin = ConfigManager.readTestDataTag("login");

    /**
     * Шаг 1: Нажать на ссылку "Забыли пароль"
     * Ожидание: Перешли на страницу восстановления пароля
     * Шаг 2: Ввод некорректного логина
     * Ожидание: Сообщение о некорректном логине
     * Шаг 3: Ввод корректного логина
     * Ожидание: Сообщение, что на электронную почту отправлено письмо
     * Шаг 4: Нажать на ссылку вернуться назад
     * Ожидание: Открыта начальная страница
     */
    @Test
    public void correctDataToAuth() {
        Logger.getLogger().info( "Forgot password test" );
        AuthPage authPage = new AuthPage();
        authPage.clickForgotPassword();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        Assert.assertTrue(forgotPasswordPage.formIsDisplayed(),"Page forgot password is not displayed");

        forgotPasswordPage.inputLoginOrEmail(wrongLogin);
        forgotPasswordPage.clickSendLogin();
        forgotPasswordPage = new ForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getTextFail(),"Пользователь с таким именем не найден.", "Login is correct");

        forgotPasswordPage.inputLoginOrEmail(correctLogin);
        forgotPasswordPage.clickSendLogin();
        forgotPasswordPage = new ForgotPasswordPage();
        Assert.assertEquals(forgotPasswordPage.getTextSuccess(),"На ваш электронный адрес отправлена инструкция по восстановлению пароля.", "Login is not correct");

        forgotPasswordPage.clickBack();
        authPage = new AuthPage();
        Assert.assertTrue(authPage.pageIsDisplayed(),"Page auth is not displayed");
    }
}
