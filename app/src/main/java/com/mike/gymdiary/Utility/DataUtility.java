package com.mike.gymdiary.Utility;

import android.content.Context;
import android.os.Environment;

import com.mike.gymdiary.Model.Exercise;
import com.mike.gymdiary.Model.Training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataUtility {
    public File directoryConnect(String folderName, Context context){
        File directory = new File (context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                folderName);
        if(!directory.exists()) directory.mkdirs();
        return directory;
    }

public void serialize(File file, Exercise exercise) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(exercise);
        oos.flush();
        oos.close();
}
public void serialize(File file, Training training) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(training);
        oos.flush();
        oos.close();
}

public Exercise deserialize (File file, Exercise exercise) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);
    Exercise ex = (Exercise) ois.readObject();
    return ex;
}

public Training deserialize (File file, Training training) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);
    Training tr = (Training) ois.readObject();
    return tr;
}

public void resetTraining(Training training, File file) throws IOException{
        Training tr = new Training();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tr);
        oos.flush();
        oos.close();
}
public void resetExercise(Exercise exercise, File file) throws IOException{
        Exercise ex = new Exercise();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ex);
        oos.flush();
        oos.close();
}

}
