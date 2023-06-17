package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Order;
import org.example.entities.enums.DeliveryType;
import org.example.services.OrderService;

import java.io.IOException;
import java.util.Date;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/createPage.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String address = req.getParameter("address");
        String deliveryType = req.getParameter("deliveryType");
        try {
            if (!address.isEmpty()) {
                orderService.saveOrder(new Order(
                        orderService.getLastId() + 1L,
                        1L,
                        new Date(),
                        address,
                        DeliveryType.fromString(deliveryType)
                ));
            } else {
                req.getSession().setAttribute("error", "Не выбран адрес доставки");
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } catch (IllegalAccessException e) {
            req.getSession().setAttribute("error", "Некорректный тип доставки");
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
