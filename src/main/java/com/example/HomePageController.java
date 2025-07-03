package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//returning to home page

@WebServlet("/")
public class HomePageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filePath = "D:\\JAVA\\JAVA Project\\code\\FlightEntryApp\\src\\main\\resources\\templates\\main.html"; // Path to your static file
        response.setContentType("text/html");
        response.getWriter().write(new String(Files.readAllBytes(Paths.get(filePath))));
    }
}
