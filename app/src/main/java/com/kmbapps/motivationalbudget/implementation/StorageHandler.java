package com.kmbapps.motivationalbudget.implementation;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Kyle on 2/23/2016.
 */
public class StorageHandler {

    private static boolean checklistsLoaded = false;
    private static Checklist myChecklist;
    
    private static boolean budgetLoaded = false;
    private static Budget myBudget;

    private static String savedChecklistFile = "checklists.txt";
    private static String savedBudgetFile = "budget.txt";
    
    public static Checklist loadChecklists(Context context) {
        if(!checklistsLoaded){
            try {
                FileInputStream fis = context.openFileInput(savedChecklistFile);
                ObjectInputStream is = new ObjectInputStream(fis);
                System.out.println(is.toString());

                myChecklist = (Checklist) is.readObject();
                checklistsLoaded = true;
                is.close();
            }
            catch (FileNotFoundException e){
                System.out.println("FileNotFoundException: " + e.getMessage());
            }
            catch (IOException e){
                System.out.println("IOException: " + e.getMessage());
            }
            catch (ClassNotFoundException e){
                System.out.println("SystemNotFoundException: " + e.getMessage());
            }
        }

        return myChecklist;
    }

    public static void saveChecklist(Context context, Checklist checklist){
        try{
            myChecklist = checklist;
            FileOutputStream fos = context.openFileOutput(savedChecklistFile, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(myChecklist);
            os.close();
        }
        catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static Budget loadBudget(Context context) {
        if(!budgetLoaded){
            try {
                FileInputStream fis = context.openFileInput(savedBudgetFile);
                ObjectInputStream is = new ObjectInputStream(fis);
                System.out.println(is.toString());

                myBudget = (Budget) is.readObject();
                budgetLoaded = true;
                is.close();
            }
            catch (FileNotFoundException e){
                System.out.println("FileNotFoundException: " + e.getMessage());
            }
            catch (IOException e){
                System.out.println("IOException: " + e.getMessage());
            }
            catch (ClassNotFoundException e){
                System.out.println("SystemNotFoundException: " + e.getMessage());
            }
        }

        return myBudget;
    }

    public static void saveBudget(Context context, Budget budget){
        try{
            myBudget = budget;
            FileOutputStream fos = context.openFileOutput(savedBudgetFile, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(myBudget);
            os.close();
        }
        catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
