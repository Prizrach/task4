package app.service;


import app.domain.Good;
import app.repository.PriceListRepository;
import java.util.ArrayList;


public class OrderService {

    public static Good getGood (String pickedGood) {
        if(pickedGood!=null) {
            Good good = new Good();
            good.setTitle(pickedGood);
            good.setPrice(PriceListRepository.getPriceListFromDb().get(good));
            return good;
        }
        return null;
    }

    public static double getTotalPrice(ArrayList<Good> list) {
        double totalPrice = 0;
        for (
                Good good: list){
            totalPrice+= good.getPrice();
        }
        return totalPrice;
    }


}
