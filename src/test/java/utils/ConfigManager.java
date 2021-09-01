package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import framework.logger.Logger;
import tests.utils.JsonUtils;

public class ConfigManager {
    private final static String settingsPath = "src/test/resources/settings.json";
    private final static String testDataPath = "src/test/resources/testData.json";

    public static String readTestSettingsTag(String tag){
        Logger.getLogger().info("Read test settings parameter "+tag);
        String json = JsonUtils.readJSONParam("testSettings", settingsPath);
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        return jsonObject.get(tag).getAsString();
    }

    public static String readTestDataTag(String tag){
        Logger.getLogger().info("Read test data parameter "+tag);
        String json = JsonUtils.readJSONParam("userData", testDataPath);
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        return jsonObject.get(tag).getAsString();
    }
}