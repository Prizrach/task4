package app.service;


import app.domain.Order;
import app.domain.PriceList;
import app.domain.Product;
import app.repository.PriceListRepository;

import java.util.ArrayList;

public class OrderService {


    ArrayList<Product> pickedProducts = new ArrayList();
    PriceListRepository priceListRepository = new PriceListRepository();

    public  ArrayList<Product> addProductToPickedProducts (String pickedProduct) {

        if(pickedProduct!=null) {
            Product product = new Product();
            product.setName(pickedProduct);
            product.setPrice(priceListRepository.getPriceListFromDb().get(pickedProduct));
            pickedProducts.add(product);
        }
        return pickedProducts;
    }

    public static double getTotalPrice(ArrayList<Product> list) {
        double total = 0;
        for (
                Product product: list){
            total+= product.getPrice();
        }
        return total;
    }


}
