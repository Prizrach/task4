package app.repository;

import app.dao.OrderDao;
import app.domain.Order;
import app.domain.User;
import app.sql.SqlHelper;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderRepository extends SqlHelper implements OrderDao {

    Connection connection = getConnection();


    @Override
    public void add(Order order) {
        String sql = "INSERT INTO ORDER (ID, USER_ID, TOTAL_PRICE) VALUES(?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2,order.getUserId());
            preparedStatement.setDouble(3, order.getTotalPrice());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order getBuId(int id) {
        return null;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void remove(Order order) {

    }

    @Override
    public Order getByUserId(int id) {
        Order order = new Order();

        String sql = "SELECT * FROM ORDER WHERE USER_ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }
}


