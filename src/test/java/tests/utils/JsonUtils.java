package tests.utils;

import framework.logger.Logger;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {
    public static String readJSONParam(String param, String path){
        Logger.getLogger().info("Read JSON parameter "+param+", path = "+path);
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            JSONObject a = (JSONObject) parser.parse(new FileReader(path));
            json = (JSONObject) a.get(param);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return json.toJSONString();
    }
}
