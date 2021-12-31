package app.repository;

import app.domain.Order;
import app.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {


    public static void add(Order order) {
        String sql = "INSERT INTO `Order` (user_id, total_price) VALUES(?,?)";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setDouble(2, order.getTotalPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Order> getAll() {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM `ORDER`";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("id"));
                    order.setUserId(resultSet.getInt("user_id"));
                    order.setTotalPrice(resultSet.getDouble("total_price"));
                    orderList.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public Order getById(int id) {
        return null;
    }

    public static void update(Order order) {
        String sql = "UPDATE `Order` SET  total_price = ? WHERE id = ?";
        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, order.getTotalPrice());
            preparedStatement.setInt(2, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void remove(Order order) {

    }

    public static Order getByUserId(int id) {
        Order order = new Order();

        String sql = "SELECT * FROM `Order` WHERE USER_ID = ?";

        try (Connection connection = SqlHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setTotalPrice(resultSet.getDouble("total_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return order;
    }

    public static double getTotalPrice(Order order){
        String sql = "SELECT SUM (price) FROM (SELECT id, title, price FROM Good  INNER JOIN (SELECT good_id FROM Order_Good WHERE order_id = ?) ON id = good_id)";
        double sum = 0;
        try(Connection connection = SqlHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, order.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                sum = resultSet.getDouble(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sum;
    }

}


