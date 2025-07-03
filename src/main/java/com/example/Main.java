package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HomePageController.class, "/"); // Map HomePage
        handler.addServletWithMapping(FlightController.class, "/submit");
        handler.addServletWithMapping(DisplayController.class, "/display");
        handler.addServletWithMapping(FlightBookingController.class, "/flights");

        server.start();
        server.join();
    }
}
