package app.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderGood {
    private int id;
    private int orderId;
    private int goodId;

    private List<Good> pickedGoods = new ArrayList<>();

    public OrderGood() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public List<Good> getPickedGood() {
        return pickedGoods;
    }

    public void setPickedGood(List<Good> pickedGood) {
        this.pickedGoods = pickedGood;
    }
}
