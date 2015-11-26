package com.Jessy;


import java.util.Date;



//  CentralAC class extends ServiceCall
public class CentralAC extends ServiceCall{


    // declaring String variable name model;
    private String model;


    // Constructor for CentralAC class object
    public CentralAC(String serviceAddress, String problemDescription, Date date, String model) {
        super(serviceAddress, problemDescription, date);  // address, description and date data is in ServiceCall class

        this.model = model; // initialize  variable
    }


    // get and set method for variable name model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    // Using toString method to make the data ready for a display
    @Override
    public String toString() {

        // if resolvedDate or resolution is null...  than display "Unresolved" otherwise, initialize a variables
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Central AC  " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString ;

    }
}

