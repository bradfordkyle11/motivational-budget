package com.kmbapps.motivationalbudget.implementation;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Kyle on 2/23/2016.
 */
public class Goal implements Serializable{

    private String name;
    private boolean mandatory;
    private boolean completed;
    private String uID = UUID.randomUUID().toString();

    public Goal(){
        name = "";
        mandatory = false;
        completed = false;
    }

    public Goal(String name, boolean mandatory){
        this.name = name;
        this.mandatory = mandatory;
    }

    /**
     * This method resets the status of a goal, setting it to not completed. If the goal is a
     * recurring one, the due date will be updated.
     */
    public void reset(){
        completed = false;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getUID() {
        return uID;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()){
            return false;
        }
        Goal oGoal = (Goal) o;
        return oGoal.getUID().equals(uID);
    }
}
