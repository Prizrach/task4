package app.service;

import app.domain.Product;

import java.util.ArrayList;

public class BillService {

public static double getTotalPrice(ArrayList<Product> list) {

    double total = 0;
    for (
            Product product: list){
        total+= product.getPrice();
    }
    return total;
}


}
