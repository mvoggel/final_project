package services;

import models.JobModel;
import models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLdb {
    String url = "jdbc:mysql://localhost:3306/final_project";
    String username = "root";
    String password = "test";
    Connection connection = null;
    static MySQLdb instance = null;

    public MySQLdb() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static synchronized MySQLdb getInstance() {
        if (instance == null) {
            instance = new MySQLdb();
        }
        return instance;
    }

    public boolean checkUsername(String username) throws SQLException {
        String qCheckUsername = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(qCheckUsername);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        boolean exists = resultSet.next();
        resultSet.close();
        statement.close();
        return exists;
    }

    public UserModel doLogin(String username, String password) throws SQLException {
        UserModel userModel = null;
        String qLogin = "SELECT user_id FROM users WHERE username = '"+ username +"' AND password = '"+ password +"'";
        PreparedStatement statement = connection.prepareStatement(qLogin);
        //statement.setString(1, username);
        //statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            userModel = new UserModel(id, username, password);
        }
        resultSet.close();
        statement.close();
        return userModel;
    }


//may not need this?
    public int generateUserID() throws SQLException {
        int numUsers = 0;
        String qCount = "SELECT COUNT(*) AS Count FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(qCount);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            numUsers = resultSet.getInt("Count");
        }
        resultSet.close();
        preparedStatement.close();
        return numUsers;
    }

    public boolean doSignUp(UserModel userModel) throws SQLException {
        boolean result = false;
        String qDoSignUp = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(qDoSignUp, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, userModel.getUsername());
            preparedStatement.setString(2, userModel.getPassword());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        userModel.setUserId(generatedKeys.getInt(1));
                    }
                }
                result = true;
            }
        }
        return result;
    }

    public boolean applyForJob(int userId, int job_id) throws SQLException {
        boolean success = false;
        String query = "UPDATE jobs SET isApplied = 1 WHERE job_id = ? AND user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, job_id);
            statement.setInt(2, userId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                success = true;
            }
        }
        return success;
    }

    public List<JobModel> getAppliedJobs(int user_id) throws SQLException {
        List<JobModel> appliedJobs = new ArrayList<>();
        String query = "SELECT * FROM jobs WHERE user_id = ? AND isApplied = 1";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int jobID = resultSet.getInt("job_id");
                    String jobTitle = resultSet.getString("title");
                    String jobDescription = resultSet.getString("description");
                    double salary = resultSet.getDouble("salary");
                    boolean isApplied = resultSet.getBoolean("isApplied");
                    String category = resultSet.getString("category");
                    // Retrieve other job details as needed
                    JobModel job = new JobModel(jobID, jobTitle, jobDescription, salary, isApplied, category);
                    appliedJobs.add(job);
                }
            }
        }
        return appliedJobs;
    }

    public List<JobModel> getJobs() throws SQLException {
        List<JobModel> jobs = new ArrayList<>();
        String query = "SELECT * FROM jobs";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int job_id = resultSet.getInt("job_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                double salary = resultSet.getDouble("salary");
                boolean isApplied = resultSet.getBoolean("isApplied");
                String category = resultSet.getString("category");

                jobs.add(new JobModel(job_id, title, description, salary, isApplied, category));
            }
        }
        return jobs;
    }



}