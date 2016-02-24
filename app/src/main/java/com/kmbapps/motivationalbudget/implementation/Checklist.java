package com.kmbapps.motivationalbudget.implementation;

import java.util.ArrayList;

/**
 * Created by Kyle on 2/23/2016.
 */
public class Checklist {

    private ArrayList<Goal> goals;
    private ArrayList<Goal> completedGoals;

    public Checklist(ArrayList<Goal> goals){
        this.goals = goals;
        this.completedGoals = new ArrayList<Goal>();
    }

    public Checklist() {
        this.goals = new ArrayList<Goal>();
        this.completedGoals = new ArrayList<Goal>();
    }

    /**
    * This method lets the checklist know that the status of a specific goal has been accounted for.
    * At this point the checklist will reset the goal if it is a recurring goal, or move it to
    * completed goals if it is not.
    * */
    public void log(Goal checkedGoal){
        //all goals are currently recurring, so just reset goal.
        for (Goal goal : goals) {
            if (goal == checkedGoal) {
                goal.reset();
            }
        }
    }

    public void addGoal(Goal newGoal){
        goals.add(newGoal);
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    public ArrayList<Goal> getCompletedGoals() {
        return completedGoals;
    }

    public void setCompletedGoals(ArrayList<Goal> completedGoals) {
        this.completedGoals = completedGoals;
    }
}
