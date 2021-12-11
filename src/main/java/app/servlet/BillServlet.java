package app.servlet;

import app.domain.Order;
import app.domain.PriceList;
import app.domain.Product;
import app.service.BillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "billServlet", urlPatterns = "/billServlet")
public class BillServlet extends HttpServlet {


    double total = 0;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> list = (ArrayList) req.getSession().getAttribute("pickedProducts");




        req.setAttribute("total", BillService.getTotalPrice(list));
        req.setAttribute("pickedProducts",list);


        req.getRequestDispatcher("WEB-INF/jsp/billPage.jsp").forward(req, resp);
    }
}