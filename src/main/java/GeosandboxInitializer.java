import geosandbox.Geosandbox;
import sql.SQLConnector;
import geosandbox.ShapeList;

public class GeosandboxInitializer {
    public static void main(String[] args) {
        SQLConnector conn = new SQLConnector();
        ShapeList list = conn.download();
        Geosandbox geosandbox = new Geosandbox(list);
        conn.upload(geosandbox.start());
    }
}