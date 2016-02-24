package com.kmbapps.motivationalbudget.implementation;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Kyle on 2/23/2016.
 */
public class BudgetManager {

    private Context context;
    private Budget budget;

    public BudgetManager(Context context){
        this.context = context;
        budget = StorageHandler.loadBudget(context);
    }

    public void updateBudget(){
        Checklist fullChecklist = StorageHandler.loadChecklists(context);
        double changeAmount = getChangeAmount(fullChecklist);
        budget.addTransaction(new Transaction(changeAmount, "daily goals satisfied"));
    }

    /**
     *This function will return the amount that the budget should change by based on the completed
     * tasks in the checklist and the rules the user has set.
     */
    private double getChangeAmount(Checklist fullChecklist){
        //default hardcoded rule for simplicity when first making app:
        //$1 if all mandatories are completed and at least 6 optionals are completed

        double changeAmount = 0;
        double HARD_CODED_GOALS_NEEDED = 6;

        ArrayList<Goal> completedGoals = new ArrayList<>();

        for(Goal goal : fullChecklist.getGoals()){
            if(goal.isMandatory()){
                if (!goal.isCompleted()) {
                    return changeAmount;
                }
            }
            else {
                if (goal.isCompleted()){
                    completedGoals.add(goal);
                }
            }
        }

        if (completedGoals.size()>=HARD_CODED_GOALS_NEEDED){
            changeAmount = 1;
        }
        return changeAmount;
    }


}
