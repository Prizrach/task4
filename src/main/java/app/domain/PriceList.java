package app.domain;

import app.repository.PriceListRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class PriceList {



    private Map<String,Double> priceList = new HashMap<>();



//    public  List<Product> getPriceList() {
//        priceList.add(new Product("cola", 12.50));
//        priceList.add(new Product("fanta", 13.50));
//        priceList.add(new Product("sprite", 14.50));
//        return priceList;
//    }


        public static Map<String, Double> INIT_PRICE_LIST() {
            return PriceListRepository.getPriceListFromDB();
        }



}