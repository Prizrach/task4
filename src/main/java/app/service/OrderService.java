package app.service;

import app.domain.Order;
import app.domain.User;
import app.repository.OrderRepository;

public class OrderService {

    public static Order createOrGetOrderByUser(User user){
        Order order = OrderRepository.getByUserId(user.getId());
        if(order!=null){
            return order;
        }else {
            OrderRepository.add(new Order(user.getId()));
            return OrderRepository.getByUserId(user.getId());
        }
    }





}
