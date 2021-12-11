package app.repository;

import app.domain.Product;
import app.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PriceListRepository {


    public static Map<String, Double> getPriceListFromDB() {
        Map<String, Double> priseList = new HashMap<>();
        ResultSet rs = null;
        Connection connection = SqlHelper.getConnection();

        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM GOOD")) {
            rs = ps.executeQuery();
            while (rs.next()) {
                priseList.put(rs.getString("title"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priseList;
    }

}

