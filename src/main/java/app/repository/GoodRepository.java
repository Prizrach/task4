package app.repository;

import app.dao.GoodDao;
import app.domain.Good;
import app.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodRepository implements GoodDao {


    @Override
    public void add(Good good) {
    }

    @Override
    public List<Good> getAll() {
        List<Good> goodList = new ArrayList<>();
        String sql = "SELECT * FROM GOOD";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Good good = new Good();
                    good.setId(resultSet.getInt("ID"));
                    good.setTitle(resultSet.getString("TITLE"));
                    good.setPrice(resultSet.getDouble("PRICE"));
                    goodList.add(good);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodList;
    }

    @Override
    public Good getBuId(int id) {
        return null;
    }

    @Override
    public void update(Good good) {

    }

    @Override
    public void remove(Good good) {

    }

    @Override
    public Good getByTitle(String title) {
        String sql = "SELECT * FROM GOOD WHERE TITLE = ?";
        Good good = new Good();
        Connection connection = SqlHelper.getConnection();
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, title);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                good.setId(resultSet.getInt("ID"));
                good.setTitle(resultSet.getString("TITLE"));
                good.setPrice(resultSet.getDouble("PRICE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return good;
    }




}
