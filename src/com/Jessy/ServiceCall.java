package com.Jessy;

import java.util.Date;

/**
 * Created by Jessy on 11/21/2015.
 */


public class ServiceCall {


    // declaring variables;
    protected String serviceAddress;
    protected String problemDescription;
    protected Date reportedDate;
    protected Date resolvedDate;

    protected final static double UNRESOLVED = -1  ;  //Flag to indicate this hasn't been resolved so we don't have a fee yet

    protected String resolution;
    protected double fee;


    // Constructor for a ServiceCall class object
    public ServiceCall(String serviceAddress, String problemDescription, Date date) {
        this.serviceAddress = serviceAddress;
        this.problemDescription = problemDescription;
        this.reportedDate = date;
        this.fee = UNRESOLVED;
    }


    // get and set method for a resolvedDate
    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }




    // get and set method for a variables
    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }


    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


}

