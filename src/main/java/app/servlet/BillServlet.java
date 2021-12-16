package app.servlet;

import app.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "billServlet", urlPatterns = "/billServlet")
public class BillServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Order order = (Order) req.getSession().getAttribute("order");

        req.setAttribute("totalPrice", order.getTotalPrice());
      //  req.setAttribute("pickedProducts",order.getPickedProducts());

        req.getRequestDispatcher("WEB-INF/jsp/billPage.jsp").forward(req, resp);
    }
}