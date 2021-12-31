package app.servlet;

import app.domain.Good;
import app.domain.Order;
import app.domain.User;
import app.repository.OrderGoodRepository;
import app.repository.OrderRepository;
import app.repository.UserRepository;
import app.service.OrderGoodService;
import app.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "billServlet", urlPatterns = "/billServlet")
public class BillServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = UserRepository.getByLogin(req.getSession().getAttribute("login").toString());

        Order order = OrderService.createOrGetOrderByUser(user);

        List<Good> pickedGoods = OrderGoodRepository.getGoodsFromOrderGood(order);

        req.setAttribute("pickedGoods", pickedGoods);

        req.setAttribute("totalPrice", OrderRepository.getTotalPrice(order));


        req.getRequestDispatcher("WEB-INF/jsp/billPage.jsp").forward(req, resp);
    }
}