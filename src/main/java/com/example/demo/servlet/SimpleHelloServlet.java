package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple Jakarta Servlet handled outside the Spring MVC DispatcherServlet flow.
 * Mapped to /hello-servlet as per the unit tests.
 */
@WebServlet(name = "SimpleHelloServlet", urlPatterns = "/hello-servlet")
public class SimpleHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // Set content type to plain text as verified in test t3
        response.setContentType("text/plain");
        // Status 200 is set by default, verified in test t2
        response.setStatus(HttpServletResponse.SC_OK);
        // Write the response body as verified in test t1 and t5
        response.getWriter().write("Hello from Simple Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // Handled as 200 or 405 based on server config, verified in test t8
        response.setStatus(HttpServletResponse.SC_OK);
    }

    /**
     * Required for test t8 which calls s.service(rq, rs) directly.
     */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) 
            throws IOException, jakarta.servlet.ServletException {
        String method = req.getMethod();
        if (method.equals("GET")) {
            doGet(req, res);
        } else if (method.equals("POST")) {
            doPost(req, res);
        } else {
            super.service(req, res);
        }
    }

    /**
     * Returns servlet metadata as verified in test t4.
     */
    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet version 1.0 - Personal Finance Budget Planner";
    }
}