package app.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int userId;
    private double totalPrice;

    private User user;
    private OrderGood orderGood;

    public Order() {
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderGood getOrderGood() {
        return orderGood;
    }

    public void setOrderGood(OrderGood orderGood) {
        this.orderGood = orderGood;
    }
}
