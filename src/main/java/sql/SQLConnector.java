package sql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import geosandbox.ExternalShapeType;
import geosandbox.ShapeList;
import geosandbox.shape.Circle;
import geosandbox.shape.Rectangle;
import geosandbox.shape.Shape;
import geosandbox.shape.Triangle;

import java.sql.*;
import java.util.*;

public class SQLConnector {
    Gson gson;
    String user = "root";
    String password = "k!HriA)NM3";
    String url = "jdbc:mysql://localhost:3306/shapes";
    String driver = "com.mysql.cj.jdbc.Driver";

    public ShapeList download() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        ShapeList shapeList = new ShapeList();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from shape");
            while (resultSet.next()) {
                ExternalShapeType shapeType = ExternalShapeType.valueOf(resultSet.getString(2).toUpperCase());
                switch (shapeType) {
                    case RECTANGLE -> shapeList.setRectangle(gson.fromJson(resultSet.getString(3), Rectangle.class));
                    case TRIANGLE -> shapeList.setTriangle(gson.fromJson(resultSet.getString(3), Triangle.class));
                    case CIRCLE -> shapeList.setCircle(gson.fromJson(resultSet.getString(3), Circle.class));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return shapeList;
    }

    public void upload(HashMap<String, Shape> shapeList) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.execute("truncate table shape");
            shapeList.values().forEach(shape -> setShape(shape, statement));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setShape(Shape shape, Statement statement) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        String shapeType = shape.getType().toString().toLowerCase();
        String body = gson.toJson(shape);
        try {
            statement.executeUpdate("insert into shape (shapeType, body) values ('" + shapeType + "','" + body + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}