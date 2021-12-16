package app.dao;



import app.domain.OrderGood;

import java.util.List;

public interface OrderGoodDao {

    void add(OrderGood orderGood);

    List<OrderGood> getAll();

    OrderGood getBuId(int id);

    OrderGood getByOrderIdAndGoodId(int orderID, int goodId);

    void update(OrderGood orderGood);

    void remove(OrderGood orderGood);

}
