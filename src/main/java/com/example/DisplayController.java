package com.example;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//displaying user data

@WebServlet("/display")
public class DisplayController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String[]> records = CsvUtils.readFromCsv();

        response.setContentType("text/html");
        response.getWriter().write("<!DOCTYPE html>");

        response.getWriter().write("<html><head><meta charset=\"UTF-8\">\r\n" + //
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><style>" +
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
                                "h1 {\r\n" + //
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
                                ".button-container {\r\n" + //
                                "    display: flex;\r\n" + //
                                "    flex-direction: column;\r\n" + //
                                "    gap: 20px;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                ".button {\r\n" + //
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
                                ".button:hover {\r\n" + //
                                "    background-color: #ff6b81;\r\n" + //
                                "    transform: translateY(-3px);\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                ".button::before {\r\n" + //
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
                                ".button:hover::before {\r\n" + //
                                "    transform: translate(-50%, -50%) scale(1);\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                ".button span {\r\n" + //
                                "    position: relative;\r\n" + //
                                "    z-index: 1;\r\n" + //
                                "}\r\n" + //
                                "\r\n" + //
                                "table {width: 100%; border-collapse: collapse;} " +
                                "th, td {border: 1px solid black; padding: 8px; text-align: left;} " +
                                "</style></head><body>");

        response.getWriter().write("<h1>Flight Data</h1>");
        response.getWriter().write("<table><tr><th>Flight Name</th><th>Airline Name</th><th>User Name</th></tr>");

        for (String[] record : records) {
            response.getWriter().write("<tr>");
            for (String field : record) {
                response.getWriter().write("<td>" + field + "</td>");
            }
            response.getWriter().write("</tr>");
        }
        response.getWriter().write("</table><br><br>");
        response.getWriter().write("<a href='/main.html' class = 'button'>Home</a><br>");
        response.getWriter().write("</body></html>");

        
    }
}
