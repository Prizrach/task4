package app.servlet;

import app.domain.*;
import app.repository.GoodRepository;
import app.repository.PriceListRepository;
import app.repository.UserRepository;
import app.service.OrderService;
import app.service.PriceListService;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@WebServlet(name = "orderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {

    PriceList priceList = new PriceListService();
    User user = new User();
    OrderGood orderGood = new OrderGood();
    Order order = new Order();
    List<Good> list = new ArrayList<>();
    UserRepository userRepository = new UserRepository();
    GoodRepository goodRepository = new GoodRepository();
    List<Good> pickedProducts = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("priceList", priceList.getPriceList());

        user.setLogin(req.getSession().getAttribute("userLogin").toString());
        userRepository.add(user);

        if (req.getParameter("selected") != null) {
            pickedProducts.add(goodRepository.getByTitle(req.getParameter("selected")));

        }

        System.out.println(userRepository.getAll());
        req.setAttribute("pickedProducts", pickedProducts);


        req.getRequestDispatcher("WEB-INF/jsp/orderPage.jsp").forward(req, resp);
    }
}
