package app.repository;

import app.dao.PriceListDao;
import app.domain.PriceList;
import app.domain.Product;
import app.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PriceListRepository implements PriceListDao {

    @Override
    public Map<String, Double> getPriceListFromDb() {
        Map<String,Double> priceList = new HashMap<>();

        Connection connection = SqlHelper.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GOOD")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                priceList.put(resultSet.getString("title"), resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return priceList;
    }

}

