package com.example.final_project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.UserModel;
import models.JobModel;
import services.MySQLdb;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/JobApplicationServlet")
public class JobApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve logged-in user information from session
        HttpSession session = request.getSession();
        UserModel userModel = (UserModel) session.getAttribute("userModel");

        // Check if user is logged in
        if (userModel != null) {
            // Get job id from form data
            int job_id = Integer.parseInt(request.getParameter("job_id"));

            // Update database to mark job as applied for by the logged-in user
            MySQLdb db = MySQLdb.getInstance();
            try {
                boolean success = db.applyForJob(userModel.getUserId(), job_id);
                if (!success) {
                    // Handle error if applying for job fails
                    response.getWriter().println("Failed to apply for job. Please try again.");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle database error
                response.getWriter().println("Database error. Please try again later.");
                return;
            }

            // Retrieve only the jobs that the logged-in user has applied for from the database
            try {
                List<JobModel> appliedJobs = db.getAppliedJobs(userModel.getUserId());

                // Pass the list of applied jobs to the myjobs.jsp page for display, this page has the list already referenced
                //from the page, so the connection should be there!
                request.setAttribute("appliedJobs", appliedJobs);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/webapp/myjobs.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle database error
                response.getWriter().println("Database error. Please try again later.");
            }
        } else {
            // If user is not logged in, redirect to login page
            response.sendRedirect("login.jsp");
        }
    }
}
