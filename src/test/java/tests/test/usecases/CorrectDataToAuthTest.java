package tests.test.usecases;

import framework.logger.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.page.AuthPage;
import tests.page.StudentStartPage;
import tests.test.BaseTest;
import utils.ConfigManager;

public class CorrectDataToAuthTest extends BaseTest {
    private final String login = ConfigManager.readTestDataTag("login");
    private final String password = ConfigManager.readTestDataTag("password");
    /**
     * Шаг 1: Ввод корректного пароля и логина. Нажать на показать пароль. Сделать скриншот
     * Ожидание: На скриншоте введены верные пароль и логин
     * Шаг 2: Кликнуть на вход.
     * Ожидание: Перешли на стартовую студенческую страницу.
     */
    @Test
    public void correctDataToAuth() {
        Logger.getLogger().info( "Correct data to auth test" );
        AuthPage authPage = new AuthPage();
        authPage.inputLogin(login);
        authPage.inputPassword(password);
        authPage.clickMiraLogin();
        browser.takeScreenshot();
        authPage.clickEntry();

        StudentStartPage studentStartPage = new StudentStartPage();
        Assert.assertTrue(studentStartPage.pageIsDisplayed(),"Student start page is not displayed");
    }
}
