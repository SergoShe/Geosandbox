import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JSONWorker {

    public void toJSON(HashMap<String, Shape> shapeList, String nameFIle) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(shapeList);
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFIle + ".json"));
        writer.write(String.valueOf(json));
        writer.close();
    }

    public HashMap<String, Shape> fromJSON() {
        HashMap<String, Shape> shapeList = new LinkedHashMap<>();
        //для следующего этапа
        return shapeList;
    }
}
