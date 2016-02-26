package com.kmbapps.motivationalbudget;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.kmbapps.motivationalbudget.implementation.Goal;
import com.kmbapps.motivationalbudget.implementation.StorageHandler;

public class EditGoalActivity extends AppCompatActivity {

    private Goal mGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_goal);

        Intent intent = getIntent();
        mGoal = (Goal) intent.getSerializableExtra("goal");

        EditText nameEditText = (EditText) findViewById(R.id.goalName);
        if(!mGoal.getName().equals("")) {
            nameEditText.setText(mGoal.getName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_goal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (item.getItemId()){
            case R.id.action_save:
                saveGoal();
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveGoal(){
        EditText nameEditText = (EditText) findViewById(R.id.goalName);
        mGoal.setName(nameEditText.getText().toString());
        StorageHandler.saveGoal(this, mGoal);
    }
}
