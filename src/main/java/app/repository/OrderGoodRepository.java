package app.repository;

import app.domain.Good;
import app.domain.Order;
import app.domain.OrderGood;
import app.domain.User;
import app.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderGoodRepository {


    public static void add(int orderId, int goodId) {
        String sql = "INSERT INTO Order_Good (order_id, good_id) VALUES(?,?)";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.setDouble(2, goodId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<OrderGood> getAll() {
        List<OrderGood> orderGoods = new ArrayList<>();
        String sql = "SELECT * FROM Order_Good";

        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    OrderGood orderGood = new OrderGood();
                    orderGood.setId(resultSet.getInt("id"));
                    orderGood.setOrderId(resultSet.getInt("order_id"));
                    orderGood.setGoodId(resultSet.getInt("good_id"));
                    orderGoods.add(orderGood);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderGoods;
    }

    public static List<Good> getGoodsFromOrderGood(Order order) {
        List<Good> orderGoods = new ArrayList<>();
        String sql = "SELECT id, title, price FROM Good  INNER JOIN (SELECT good_id FROM Order_Good WHERE order_id = ?) ON id = good_id";

        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, order.getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Good good = new Good();
                    good.setId(resultSet.getInt("id"));
                    good.setTitle(resultSet.getString("title"));
                    good.setPrice(resultSet.getDouble("price"));
                    orderGoods.add(good);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderGoods;
    }

    public void update(OrderGood orderGood) {
    }

    public void remove(OrderGood orderGood) {
    }



}







