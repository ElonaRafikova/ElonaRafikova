package hw8.dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MetalAndColorsDataProviders {
    @DataProvider
    public static Object[][] metalAndColorsDataProvider() throws FileNotFoundException {

        Gson gson = new Gson();
        JsonObject jDataSet = new JsonParser().parse(new FileReader
                ("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json")).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()][1];
        int counter = 0;
        for (String key : jDataSet.keySet()) {
            result[counter][0] = gson.fromJson(jDataSet.get(key), MetalAndColorsTemplate.class);
            counter++;
        }
        return result;

    }
}
