package com.example.final_project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.UserModel;
import services.MySQLdb;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value ="/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        MySQLdb db = MySQLdb.getInstance();
        UserModel userModel = null;
        try {
            userModel = db.doLogin(username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        if (userModel != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user_id", userModel);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("myjobs.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("error", "Incorrect username or password..!!!");
            requestDispatcher.forward(request, response);
        }
    }

        // Check if username exists
//        MySQLdb db = MySQLdb.getInstance();
//        try {
//            boolean usernameExists = db.checkUsername(username);
//            if (!usernameExists) {
//                // Username does not exist, handle the case accordingly
//                response.getWriter().println("Username does not exist. Please try again.");
//                return; // Stop further processing
//            }
//
//            // Proceed with login
//            UserModel userModel = db.doLogin(username, password);
//            if (userModel != null) {
//                // Successful login
//                HttpSession session = request.getSession();
//                session.setAttribute("userModel", userModel);
//
//                // Redirect to homepage
//                response.sendRedirect("/myjobs.jsp");
//            } else {
//                // Failed login
//                response.getWriter().println("Invalid username or password. Please try again.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().println("Database error. Please try again later.");
//        }
  //  }
}

