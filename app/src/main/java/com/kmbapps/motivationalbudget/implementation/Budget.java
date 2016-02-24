package com.kmbapps.motivationalbudget.implementation;

import java.util.ArrayList;

/**
 * Created by Kyle on 2/23/2016.
 */
public class Budget {

    private double value;
    private ArrayList<Transaction> history;

    public void addTransaction(Transaction newTransaction){
        value += newTransaction.getValue();
        history.add(newTransaction);
    }

}
