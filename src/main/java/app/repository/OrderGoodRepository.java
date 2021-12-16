package app.repository;


import app.dao.OrderGoodDao;
import app.domain.Good;
import app.domain.Order;
import app.domain.OrderGood;
import app.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderGoodRepository implements OrderGoodDao {
    Connection connection = SqlHelper.getConnection();
    Order order = new Order();
    Good good = new Good();

    @Override
    public void add(OrderGood orderGood) {

    }

    @Override
    public List<OrderGood> getAll() {
        return null;
    }

    @Override
    public OrderGood getBuId(int id) {
        return null;
    }

    @Override
    public OrderGood getByOrderIdAndGoodId(int orderID, int goodId) {
        OrderGood orderGood = new OrderGood();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO ORDER_GOOD (ORDER_ID, GOOD_ID) VALUES (?,?)")) {
            ps.setInt(1, order.getId());
            ps.setInt(2, good.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderGood;
    }

    @Override
    public void update(OrderGood orderGood) {

    }

    @Override
    public void remove(OrderGood orderGood) {

    }

    }







