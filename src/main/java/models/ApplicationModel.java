package models;

public class ApplicationModel {
    private int id;
    private int jobId;
    private int prospectId;

    //This ApplicationModel is intended for a future enhancement to this application.
    //Its intended use will be to break out the functionality of applied jobs to be more efficient than the parsing it
    //currently needs to do (both done within JobModel, but speed of access to the database will greatly improve to separate
    //these functionalities. In addition, this will serve as the initialization of adding "employers" to this application,
    //who will eventually be able to add additional listings to the database instead of needing to contact our company
    //directly.
}