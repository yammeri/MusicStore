package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.TravelHistory;
import org.example.services.TravelHistoryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/track")
public class TrackServlet extends HttpServlet {
    TravelHistoryService travelHistoryService = new TravelHistoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long orderId = Long.valueOf(String.valueOf(req.getSession().getAttribute("orderNumber")));
        List<TravelHistory> travelHistoriesList = travelHistoryService.getListOfTravels(orderId);
        req.setAttribute("travelHistoriesList", travelHistoriesList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/trackPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
