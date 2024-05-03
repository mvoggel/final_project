package com.example.final_project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.JobModel;
import services.MySQLdb;

import java.io.IOException;
import java.util.List;

public class JobListingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all jobs from the database
        // Forward the jobs list to alljobs.jsp
        MySQLdb db = MySQLdb.getInstance();
        try {
            List<JobModel> jobsList = db.getJobs();
            request.setAttribute("jobsList", jobsList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("alljobs.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("Database error, try again please!");
        }
    }
}
