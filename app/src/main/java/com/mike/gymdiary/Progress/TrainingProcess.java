package com.mike.gymdiary.Progress;

import android.content.Context;

import com.mike.gymdiary.Model.Training;
import com.mike.gymdiary.Utility.DataUtility;

import java.io.File;
import java.io.IOException;

public class TrainingProcess {

    int exerciseCounter = 0;
    Training training = new Training();

    public TrainingProcess(Context context, Training training, String type) throws IOException, ClassNotFoundException {
        training = initTraining(context, training, type);
    }

    public Training initTraining (Context context, Training training, String type) throws IOException, ClassNotFoundException {
        String fileName = type + ".bin";
        DataUtility dataUtility = new DataUtility();
        File directory = dataUtility.directoryConnect("Trainings", context);
        File tF = new File (directory, fileName);
        Training tr = dataUtility.deserialize(tF, training);
        return tr;
    }
}

