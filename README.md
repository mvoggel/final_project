## Prospect Job Application Site
### General Overview
- This site application is intended to serve as a job finding website for prospective employees. Much like Indeed.com and others, this site will have user profiles, who can log in and see the jobs to which they've applied, as well as see a full list of "alljobs" to which they can additionally apply.
- Conditional logic is setup using Models (see /Models inside our src/main folder), and where Servlets are formatted to execute the necessary commands to our database in order to complete the following tasks:
  - Log in to the application with a username that's existing within our database
  - See all of your user_ids "appliedTo" jobs on your myjobs.jsp paage
  - Navigate to the full list of open jobs (pulled from the database), where you can further apply
  - Sign up if you do not have an existing user_id in our system (as well as username, password)
  - Visit our homepage to pick your path 

### Implementations
- We implemented our database tables and schemas for the final application, populating both our user and jobs tables with dummy content in order to be referenced/tested in our application. For this we used MySQL Workbench, and successfully connected it in Intellij
- Our application builds on a Tomcat Server, using a Java EE profile, that was exploded locally in our browser in order to simulate the site. With this final project submission is a video showcasing what we have fully implemented.
- Login experience - includes our login.jsp, calls our LoginServlet upon submission, references UserModel, MySQLdb methods
- Sign up experience - includes our signup.jsp, calls our SignUpServlet upon submission, references UserModel, MySQLdb methods, and creates a new instance of a user if it didn't formerly exist
- Job Application experience - includes our myjobs.jsp and alljobs.jsp, UserModel, JobModel, ApplicationModel, JobApplicationServlet, JobListingServlet, MySQLdb methods
  - myjobs experience shows all jobs appliedTo for a given user_id, indicated in our database in the jobs table with a 0 or 1 (0 being no, 1 being yes), if it's a yes, then it will list that job under the myjobs page
  - alljobs experience shows ALL jobs. There is a button on each job, and an action setup that calls our Servlets and models to trigger the change in our database, that will then send this listing to that users myjobs.jsp page


### Future Enhancements 
- While we have provided our technical outline, there were some issues that arose that will become future enhancements to the application
- Our Servlet handling and reference was not properly resolving after due diligence to setup our web.xml, and servlet class inclusion in the application build
  - This made our steps beyond our login and signup features not work as expected - an ongoing bug we are determined to fix beyond the scope of the assignment
- Implement full css design for homepage, myjobs and alljobs jsp page once access is granted


### Files included:
Pages  
- index.jsp
- login.jsp 
- signup.jsp 
- myjobs.jsp
- alljobs.jsp
Servlets 
- LoginServlet 
- SignUpServlet 
- JobApplicationServlet (getting the jobs for myjobs.jsp page) 
- JobListingServlet (getting ALL jobs for alljobs.jsp)
DB 
- MySQLdb (select statements and logic to pull from the db)
Models 
- UserModel 
- JobModel
- ApplicationModel
