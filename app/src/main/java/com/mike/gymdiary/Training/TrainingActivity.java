package com.mike.gymdiary.Training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mike.gymdiary.R;

public class TrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
    }
public void onClick(View view){
        switch(view.getId()){
            case R.id.createExBtnTraining:{
                Intent intent = new Intent (this, EditExercisesActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.saveBtnTraining:{
                finish();
                break;
            }
    }
}
}
