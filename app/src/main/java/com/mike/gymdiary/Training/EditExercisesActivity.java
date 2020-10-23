package com.mike.gymdiary.Training;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.mike.gymdiary.Model.Exercise;
import com.mike.gymdiary.Model.Exercises;
import com.mike.gymdiary.R;
import com.mike.gymdiary.Utility.DataUtility;

import java.io.File;


public class EditExercisesActivity extends AppCompatActivity {

    int IMAGE = 1;
    DataUtility dataUtility = new DataUtility();
    Exercises exercises = new Exercises();
    Exercise exercise = new Exercise();
    File fileFromGallery;
    ImageView image;
    EditText name;
    EditText description;
    Bitmap bm;
    SimpleAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercises);

        dataUtility.initFiles(this);
        exercises = dataUtility.deserialize(dataUtility.getEf(), exercises);

        System.out.println("onCreAAAAte edit exercises");

        image = findViewById(R.id.imegeIVEdEx);
        name = findViewById(R.id.nameETEdEx);
        description = findViewById(R.id.descriptionETEdEx);



    }

    public void onClick(View view){
        switch (view.getId()){

           case R.id.imegeIVEdEx: {
               if (ActivityCompat.checkSelfPermission(
                       this,
                       Manifest.permission.RECORD_AUDIO
               ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                       this,
                       Manifest.permission.WRITE_EXTERNAL_STORAGE
               ) != PackageManager.PERMISSION_GRANTED
               ) {
                   String[] permissions = new String[]{
                           android.Manifest.permission.RECORD_AUDIO,
                           android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                           android.Manifest.permission.READ_EXTERNAL_STORAGE
                   };
                   ActivityCompat.requestPermissions(this, permissions, 0);
               } else {
                   Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   intent.setType("image/*");
                   startActivityForResult(intent, IMAGE);
                   break;
               }
           }
            case R.id.saveBtnEdEx:{
                exercise.setName(name.getText().toString());
                exercise.setDescription(description.getText().toString());
                exercise.setBm(bm);
                exercise.setImagelink(fileFromGallery.getAbsolutePath());
                exercises.addEx(exercise.getName(),  exercise);
                dataUtility.serialize(dataUtility.getEf(), exercises);
                finish();
                break;
            }

            case R.id.doneBtnEdEx:{
                finish();
                break;
            }
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case 1: {
                if (resultCode == Activity.RESULT_OK) {

                    if (intent == null) {

                    } else if (intent.getData() != null) {
                        Uri uri = intent.getData();
                        fileFromGallery = new File(uri.getLastPathSegment());
                        if (fileFromGallery.exists()) {
                            Bitmap bm = BitmapFactory.decodeFile(fileFromGallery.getAbsolutePath());
                            image.setImageBitmap(bm);

                        }

                        dataUtility.serialize(dataUtility.getEf(), exercises);
                    }
                }
                break;
            }
        }
    }


}
