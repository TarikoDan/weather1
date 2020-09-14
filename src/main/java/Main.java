import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter CityName: ");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        String apiKey = "121d8eace6bdeffca7a277879789f63d";

        String pass = "http://api.openweathermap.org/data/2.5/weather?q="
                .concat(city)
                .concat("&appid=")
                .concat(apiKey);
        String dataString = new Connection().getDataString(pass);

        Gson gson = new Gson();
        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();

        JsonElement jsonElement = gson.fromJson(dataString, JsonElement.class);
        System.out.println(jsonElement);
        String prettyObject = gson1.toJson(jsonElement);
        System.out.println(prettyObject);

        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        System.out.println(asJsonObject.keySet());
        JsonElement main = asJsonObject.get("main");
        System.out.println(main);
        MainFields mainFields = gson.fromJson(main, MainFields.class);
        System.out.println(mainFields.getTemp());
//        JSONObject jsonObject = new JSONObject(dataString);
//        JSONObject main = jsonObject.getJSONObject("main");
//        System.out.println(main);
//        System.out.println(main.getDouble("temp"));
//        Gson gson = new Gson();
//        MainFields mainFields = gson.fromJson(main.toString(), MainFields.class);
//        System.out.println(mainFields.getHumidity());
//        mainFields.tempFtoC();
//        System.out.println(mainFields.getTemp());

    }
}
