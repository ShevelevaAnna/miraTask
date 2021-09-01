package framework.utils;

import utils.ConfigManager;

public class DriverUtils {
    public static char typeDriver = ConfigManager.readTestSettingsTag("browser").charAt(0);
    public static int timeWait = Integer.parseInt(ConfigManager.readTestSettingsTag("timeWait"));
}
