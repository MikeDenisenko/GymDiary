package com.mike.gymdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mike.gymdiary.Progress.StartTrainingActivity;
import com.mike.gymdiary.Schedule.ScheduleActivity;
import com.mike.gymdiary.Training.EditTrainingsActivity;
import com.mike.gymdiary.Utility.DataUtility;

public class MainActivity extends AppCompatActivity {

    DataUtility dataUtility = new DataUtility();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataUtility.initFiles(this);

    }

    public void onClick (View view){
        switch (view.getId()){
            case R.id.createBtnMain: {
                Intent intent = new Intent(this, EditTrainingsActivity.class);
                startActivity (intent);
                break;
            }

            case R.id.sheduleBtnMain: {
                Intent intent = new Intent(this, ScheduleActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.startBtnMain: {
                Intent intent = new Intent(this, StartTrainingActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
