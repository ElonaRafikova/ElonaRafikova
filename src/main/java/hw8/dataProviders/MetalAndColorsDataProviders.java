package hw8.dataProviders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MetalAndColorsDataProviders {
    private static String filePath = "src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider
    public static Object[] metalAndColorsDataProvider() throws FileNotFoundException {
        Map<String, MetalAndColorsTemplate> result = new HashMap<>();
        File file = new File(filePath);
        try (JsonReader jsonReader = new JsonReader(new FileReader(file))) {
            Type token = new TypeToken<Map<String, MetalAndColorsTemplate>>() {{
            }}.getType();
            result = new Gson().fromJson(jsonReader, token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.values().toArray();

    }
}
