import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashMap;

public class JsonBuilder {
    Gson gson;

    public void toJSON(HashMap<String, Shape> shapeList, String nameFIle) throws IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(shapeList);
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFIle + ".json"));
        writer.write(json);
        writer.close();
    }

    public ShapeList fromJSON(String pathWay) throws FileNotFoundException {
        gson = new GsonBuilder()
                .registerTypeAdapter(ShapeList.class, new ShapeListDeserializer())
                .create();
        BufferedReader reader = new BufferedReader(new FileReader(pathWay));
        return gson.fromJson(reader, ShapeList.class);
    }
}