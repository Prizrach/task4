package app.servlet;

import app.domain.*;
import app.repository.*;
import app.service.OrderGoodService;
import app.service.OrderService;
import app.service.PriceListService;
import app.service.UserService;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;


@WebServlet(name = "orderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("priceList", PriceListService.getPriceList());

        User user = UserService.createOrGetUser(req.getSession().getAttribute("login").toString());

        Order order = OrderService.createOrGetOrderByUser(user);

        OrderGoodService.addGoodToOrderGood(req.getParameter("selected"),order);

        List<Good> pickedGoods = OrderGoodRepository.getGoodsFromOrderGood(order);

        order.setTotalPrice(OrderRepository.getTotalPrice(order));

        req.setAttribute("pickedGoods", pickedGoods);

        req.getRequestDispatcher("WEB-INF/jsp/orderPage.jsp").forward(req, resp);
    }
}
