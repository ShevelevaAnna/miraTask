package tests.utils;

import org.testng.annotations.DataProvider;
import utils.ConfigManager;

public class ParametersForTest {
   @DataProvider(name = "wrongDataToAuthData")
   public Object[][] wrongDataToAuthData() {
       return new Object[][]{
            {RandomUtils.randomText(10), RandomUtils.randomText(10)},
            {ConfigManager.readTestDataTag("login"), RandomUtils.randomText(10)},
            {RandomUtils.randomText(10), ConfigManager.readTestDataTag("password")}
       };
   }
}
