package app.dao;


import app.domain.Order;
import app.domain.User;

import java.util.List;

public interface OrderDao {

    void add(Order order);

    List<Order> getAll();

    Order getBuId(int id);

    void update(Order order);

    void remove(Order order);

    Order getByUserId(int id);

}
