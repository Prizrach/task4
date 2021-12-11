package app.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String userName;
    private double totalPrice;
    private List<Product> pickedProducts = new ArrayList<>();



    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getPickedProducts() {
        return pickedProducts;
    }

    public void setPickedProducts(List<Product> pickedProducts) {
        this.pickedProducts = pickedProducts;
    }
}
