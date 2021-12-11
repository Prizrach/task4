package app.servlet;

import app.domain.Order;
import app.domain.PriceList;
import app.domain.Product;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "orderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {

    private List<Product> pickedProducts = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setAttribute("priceList", PriceList.INIT_PRICE_LIST());

            String value = req.getParameter("selected");

            if(value!=null) {
                Product product = new Product();
                product.setName(value);
                product.setPrice(PriceList.INIT_PRICE_LIST().get(value));
                pickedProducts.add(product);
            }

            req.getSession().setAttribute("pickedProducts",pickedProducts);
            //req.setAttribute("pickedProducts", pickedProducts);
            req.getRequestDispatcher("WEB-INF/jsp/orderPage.jsp").forward(req, resp);
    }
}
