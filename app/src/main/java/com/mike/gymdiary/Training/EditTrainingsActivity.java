package com.mike.gymdiary.Training;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mike.gymdiary.Model.Exercise;
import com.mike.gymdiary.Model.Exercises;
import com.mike.gymdiary.Model.Training;
import com.mike.gymdiary.Model.Trainings;
import com.mike.gymdiary.R;
import com.mike.gymdiary.Utility.DataUtility;

import java.util.ArrayList;

public class EditTrainingsActivity extends AppCompatActivity {

    Exercises exercises = new Exercises();
    Exercise exercise = new Exercise();
    Training trng = new Training();
    Trainings trngs = new Trainings();
    DataUtility dataUtility = new DataUtility();
    Spinner spinner;
    ArrayList<String> exForSpinner = new ArrayList<String>();
    ImageView image;
    TextView name;
    TextView description;
    EditText sets;
    EditText reps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trainings);

        dataUtility.initFiles(this);
        exercises = dataUtility.deserialize(dataUtility.getEf(), exercises);
        image = findViewById(R.id.imageIVEdTr);
        spinner = findViewById(R.id.exerciseScheduleSpEdTr);
        name = findViewById(R.id.nameTVEdTr);
        description = findViewById(R.id.descriptionTVEdTr);
        sets = findViewById(R.id.setsETEdTr);
        reps = findViewById(R.id.repETEdTr);

        initSpinner();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                String choise = spinner.getSelectedItem().toString();
                System.out.println(choise + "selected");
                exercise = exercises.ex.get(choise);
                initExercise();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dataUtility.initFiles(this);
        exercises = dataUtility.deserialize(dataUtility.getEf(), exercises);
        initSpinner();

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.addExBtnEdTr:{
                System.out.println("Function is executing");
                Intent intent = new Intent(this, EditExercisesActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.editExBtnEdTr:{
                if(exercise.getName() != "") {
                    exercises.setCurrent(exercise.getName());
                }
            }

            case R.id.saveBtnEdTr:{
                exercise.setSets(Integer.parseInt(sets.getText().toString()));
                exercise.setRepetitions(Integer.parseInt(reps.getText().toString()));

                trng.setExercises(exercises);
                finish();
                break;
            }
        }
    }


    public void initSpinner(){
        exForSpinner = new ArrayList<String>();
        System.out.println("Init Spinneeeeeer!!!!!!!!!!!!!!!!");
        exForSpinner.addAll(exercises.ex.keySet());
        System.out.println("keys" + exForSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exForSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void initExercise(){
        image.setImageBitmap(BitmapFactory.decodeFile(exercise.getImagelink()));
        if(exercise.getBm()!= null){
        image.setImageBitmap(exercise.getBm());
        }
        name.setText(exercise.getName());
        description.setText(exercise.getDescription());
    }



}

