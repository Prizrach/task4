package app.servlet;

import app.domain.Order;
import app.domain.PriceList;
import app.domain.Product;
import app.domain.User;
import app.repository.PriceListRepository;
import app.repository.UserRepository;
import app.service.OrderService;
import app.sql.SqlHelper;


import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "orderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {
    PriceListRepository priceListRepository = new PriceListRepository();
    ResultSet rs = null;
    Order order = new Order();
    OrderService orderService = new OrderService();
    User user = new User();
    UserRepository userRepository = new UserRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("priceList", priceListRepository.getPriceListFromDb());

        user.setLogin(req.getSession().getAttribute("userName").toString());
        userRepository.add(user);

        String pickedProduct = req.getParameter("selected");

        ArrayList pickedProducts = orderService.addProductToPickedProducts(pickedProduct);



        order.setTotalPrice(OrderService.getTotalPrice(pickedProducts));
        req.getSession().setAttribute("order", order);


            req.getSession().setAttribute("pickedProducts",pickedProducts);
            req.getRequestDispatcher("WEB-INF/jsp/orderPage.jsp").forward(req, resp);
    }
}
