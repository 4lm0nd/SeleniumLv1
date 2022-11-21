package railway;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadFileJson {

    public static String getJsonValue(String dataFileName, String jsonText) {
        try {
            JSONParser jsonParse = new JSONParser();

            //parsing the content of json file
            JSONObject jsonObject = (JSONObject) jsonParse.parse(new FileReader("TestData" + "/" + dataFileName));

            //reading the data from the json file
            String js = (String) jsonObject.get(jsonText);
            return js;

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }

    }
}



