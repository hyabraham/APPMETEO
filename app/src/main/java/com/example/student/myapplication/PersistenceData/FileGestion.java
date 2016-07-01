package com.example.student.myapplication.PersistenceData;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Student on 21/06/2016.
 */
public class FileGestion {

    private File file;
    private Context context;
    private boolean appendable;

    public FileGestion(Context context,String fileName, boolean appendable) {
        this.context = context;
        this.appendable = appendable;
        this.file = new File(context.getFilesDir(),fileName);

    }

    public boolean deleteFile(){
        return file.delete();
    }

    public String readFromFile() throws IOException{
        StringBuilder sb = new StringBuilder();
        String line = null;

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
            Log.d("readFromFile : ",line);

            br.close();
            fr.close();

        return sb.toString();
    }

    public void saveToFile(String str) throws IOException{
        FileWriter fw = new FileWriter(file,appendable);
        Log.d("saveToFile : ",str);
        fw.append(str);
        fw.flush();
        fw.close();
    }
}
