package com.mike.gymdiary.Utility;

import android.content.Context;
import android.os.Environment;

import com.mike.gymdiary.Model.Exercises;
import com.mike.gymdiary.Model.Trainings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataUtility {

    File ef;
    File tf;

    public File getEf() {
        return ef;
    }

    public void setEf(File ef) {
        this.ef = ef;
    }

    public File getTf() {
        return tf;
    }

    public void setTf(File tf) {
        this.tf = tf;
    }

    public void initFiles(Context context) {
        try {

            ef = new File(directoryConnect("Exercises", context), "Exercises.bin");
            if (!ef.exists()) {
                Exercises exercises = new Exercises();
                serialize(tf, exercises);
            }

            tf = new File(directoryConnect("Trainings", context), "Trainings.bin");
            if (!tf.exists()) {
                Trainings trainings = new Trainings();
                serialize(tf, trainings);
            }

        } catch (
                Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public File directoryConnect(String folderName, Context context) {
        File directory = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                folderName);
        if (!directory.exists()) directory.mkdirs();
        return directory;
    }

    public void serialize(File file, Exercises exercises) {
      try{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(exercises);
        oos.flush();
        oos.close();
    }catch(Exception ex){
    }
    }

    public void serialize(File file, Trainings trainings) {
      try {
          FileOutputStream fos = new FileOutputStream(file);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(trainings);
          oos.flush();
          oos.close();

      }catch(Exception ex){
      }
    }

    public Exercises deserialize(File file, Exercises exercises) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Exercises ex = (Exercises) ois.readObject();
            return ex;

        } catch (Exception ex) {
            Exercises error = new Exercises();
            return exercises;
        }
    }

    public Trainings deserialize(File file, Trainings trainings) {
        try{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Trainings tr = (Trainings) ois.readObject();
        return tr;

    }catch(Exception ex) {
        Trainings error = new Trainings();
        return trainings;
    }
}

public void resetTrainings(Trainings trainings, File file) {
       try{
        Trainings tr = new Trainings();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tr);
        oos.flush();
        oos.close();

       }catch(Exception ex){
        }
}
public void resetExercises(Exercises exercises, File file) {
     try{
        Exercises ex = new Exercises();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ex);
        oos.flush();
        oos.close();

        }catch(Exception ex){
        }
}

}
