package models;

public class JobModel {
    private int job_id;
    private String title;
    private String description;
    private double salary;
    private boolean isApplied; // This field indicates whether the job is applied for or not

    // Constructors
    public JobModel() {
    }

    public JobModel(int job_id, String title, String description, double salary, boolean isApplied, String category) {
        this.job_id = job_id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.isApplied = isApplied;
    }


    // Getters and setters
    public int job_id() {
        return job_id;
    }

    public void job_id(int job_id) {
        this.job_id = job_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isApplied() {
        return isApplied;
    }

    public void setApplied(boolean applied) {
        isApplied = applied;
    }
}
