package com.kmbapps.motivationalbudget.implementation;

/**
 * Created by Kyle on 2/23/2016.
 */
public class Transaction {

    private double value;
    private String date;
    private String details;
    private String vendor;

    public Transaction(double value, String details){
        this.value = value;
        this.details = details;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
