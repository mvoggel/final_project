Prospect Job Application Site
Login yes (HAS a login) (login.jsp) -> calls LoginServlet -> if success, goes to myjobs.jsp (homepage). This shows all their applied to jobs (jobs in the database that have an "isApplied" value of "1")

Login no (NEW login) (signup.jsp) -> calls SignUpServlet via the UserModel and creates a new one, brings them then to myjobs.jsp (will assign a user id)

To "apply" to a job, go to "alljobs.jsp" which calls JobListingServlet (maybe JobListingModel too) to just bring in ALL jobs that exist, there should be a button on each one that says "Add" on it, which will flip it in our db to a "1" as it defaults to "0" which we're calling "not applied." It should show ones that have been clicked, which is the trigger to bring it to the main alljobs.jsp page, but once clicked, should populate in your myjobs.jsp page 

Pages needed 
- index.jsp
- login.jsp 
- signup.jsp 
- myjobs.jsp (home for prospects) 
- alljobs.jsp (listing of all the jobs) 
Servlets needed
- LoginServlet 
- SignUpServlet 
- JobApplicationServlet (getting the jobs for myjobs.jsp page) 
- JobListingServlet (getting ALL jobs for alljobs.jsp)

DB 
- MySQLdb (select statements and logic to pull from the db)

Models needed
- UserModel (outlines user id and information) 
- JobModel
- ApplicationModel (not sure what we'll need here, but maybe this is easier to split JobModel, UserModel, into 2 parts to separate onto a page where a user's applied jobs live?) 
