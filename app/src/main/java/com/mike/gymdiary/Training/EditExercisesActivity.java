package com.mike.gymdiary.Training;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mike.gymdiary.Model.Exercise;
import com.mike.gymdiary.Model.Exercises;
import com.mike.gymdiary.R;
import com.mike.gymdiary.Utility.DataUtility;

public class EditExercisesActivity extends AppCompatActivity {

    int IMAGE = 1;
    DataUtility dataUtility;
    Exercises exercises;
    Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercises);

        dataUtility.initFiles(this);
        exercises = dataUtility.deserialize(dataUtility.getEf(), exercises);

    }

    public void onClick(View view){
        switch (view.getId()){

           case R.id.imegeIVEdEx: {

               Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent, IMAGE);
               break;
            }

            case R.id.saveBtnEdEx:{
                exercises.addEx(exercise.getName(), exercise);

                dataUtility.serialize(dataUtility.getEf(), exercises);
                finish();
                break;

            }
        }
    }

}
