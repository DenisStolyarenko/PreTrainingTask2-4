package services;

import flowers.interfaces.ReaderData;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ReadFromDB extends ReaderData {


    @Override
    public Map<Integer, String[]> readFile(String Path) throws ParserConfigurationException, IOException, SAXException {
        Map<Integer,String[]> flowerValueMap = new HashMap<>();
        String login = "sa";
        String password = "";
        String sql = "select * from test";
        int keyMap = 0;

        try (
                Connection connection = DriverManager.getConnection(Path, login, password);
                Statement statement = connection.createStatement();

        ){
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()){
                String name = resultSet.getString("NAME");
                String color = resultSet.getString("COLOR");
                String length = resultSet.getString("LENGTH");
                String price = resultSet.getString("PRICE");
                String[] mas = {name, color, length, price};
                flowerValueMap.put(keyMap++,mas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flowerValueMap;
    }
}
