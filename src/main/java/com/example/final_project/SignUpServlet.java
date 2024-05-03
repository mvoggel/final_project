package com.example.final_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UserModel;
import services.MySQLdb;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a new user model without user_id
        UserModel userModel = new UserModel(0, username, password); // user_id will be generated automatically

        // Save user to database
        MySQLdb db = MySQLdb.getInstance();
        try {
            boolean success = db.doSignUp(userModel);
            if (success) {
                // Redirect to login page after successful signup
                response.sendRedirect("login.jsp");
            } else {
                // Handle signup failure
                // You can redirect to an error page or display a message
                response.getWriter().println("Signup failed. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            // You can redirect to an error page or display a message
            response.getWriter().println("Database error. Please try again later.");
        }
    }
}
