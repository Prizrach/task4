package app.service;

import app.domain.Good;
import app.domain.Order;
import app.repository.GoodRepository;
import app.repository.OrderGoodRepository;


public class OrderGoodService {

    public static void addGoodToOrderGood(String goodTitle, Order order) {
        if (goodTitle != null) {
            Good good = GoodRepository.getByTitle(goodTitle);
            OrderGoodRepository.add(order.getId(), good.getId());

        }
    }

}
