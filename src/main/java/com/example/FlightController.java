package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//data entry

@WebServlet("/submit")
public class FlightController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flightName = request.getParameter("flightName");
        String airlineName = request.getParameter("airlineName");
        String userName = request.getParameter("userName");

        boolean success1 = CsvUtils.writeToCsv(flightName, airlineName, userName);
        boolean success2 = CsvUtils.reduceAvailableSeats(airlineName);

        response.setContentType("text/html");
        response.getWriter().write("<!DOCTYPE html>");

        response.getWriter().write("<html><head><style>" +
                                "* {\r\n" + //
                                "    box-sizing: border-box;\r\n" + //
                                "    margin: 0;\r\n" + //
                                "    padding: 0;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "body {\r\n" + //
                                "    font-family: 'Roboto', sans-serif;\r\n" + //
                                "    background: linear-gradient(to right, #1c1c1c, #3a3a3a);\r\n" + //
                                "    color: #fff;\r\n" + //
                                "    display: flex;\r\n" + //
                                "    flex-direction: column;\r\n" + //
                                "    justify-content: center;\r\n" + //
                                "    align-items: center;\r\n" + //
                                "    height: 100vh;\r\n" + //
                                "    text-align: center;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "header {\r\n" + //
                                "    margin-bottom: 40px;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "h3 {\r\n" + //
                                "    font-size: 3em;\r\n" + //
                                "    margin-bottom: 10px;\r\n" + //
                                "    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "p {\r\n" + //
                                "    font-size: 1.2em;\r\n" + //
                                "    margin-bottom: 20px;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "a-container {\r\n" + //
                                "    display: flex;\r\n" + //
                                "    flex-direction: column;\r\n" + //
                                "    gap: 20px;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "a {\r\n" + //
                                "    background-color: #ff4757;\r\n" + //
                                "    color: #fff;\r\n" + //
                                "    padding: 15px 30px;\r\n" + //
                                "    text-decoration: none;\r\n" + //
                                "    border-radius: 50px;\r\n" + //
                                "    font-size: 1.2em;\r\n" + //
                                "    transition: all 0.3s ease;\r\n" + //
                                "    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);\r\n" + //
                                "    position: relative;\r\n" + //
                                "    overflow: hidden;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "a:hover {\r\n" + //
                                "    background-color: #ff6b81;\r\n" + //
                                "    transform: translateY(-3px);\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "a::before {\r\n" + //
                                "    content: '';\r\n" + //
                                "    position: absolute;\r\n" + //
                                "    top: 50%;\r\n" + //
                                "    left: 50%;\r\n" + //
                                "    width: 300%;\r\n" + //
                                "    height: 300%;\r\n" + //
                                "    background: rgba(255, 255, 255, 0.1);\r\n" + //
                                "    border-radius: 50%;\r\n" + //
                                "    transition: all 0.5s ease;\r\n" + //
                                "    z-index: 0;\r\n" + //
                                "    transform: translate(-50%, -50%) scale(0);\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "a:hover::before {\r\n" + //
                                "    transform: translate(-50%, -50%) scale(1);\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "a span {\r\n" + //
                                "    position: relative;\r\n" + //
                                "    z-index: 1;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "footer {\r\n" + //
                                "    position: absolute;\r\n" + //
                                "    bottom: 20px;\r\n" + //
                                "    font-size: 0.8em;\r\n" + //
                                "    color: #ccc;\r\n" + //
                                "}"+
                                "</style></head><body>");

        if (success1 && success2) {
            response.getWriter().write("<h3>Data saved successfully!</h3><br>");
            response.getWriter().write("<a href='/main.html class='button'>Home</a>");
            
        } else {
            response.getWriter().write("<h3>Incorrect data</h3><br>");
            response.getWriter().write("<a href='/main.html class='button'>Home</a>");
        }

        response.getWriter().write("</body></html>");
        
        
    }
}
