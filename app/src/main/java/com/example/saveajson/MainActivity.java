package com.example.saveajson;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {
    String prova = "Ciao Come stai\n come va la vita \t a me male\t che pd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToFile(prova);

        File file = new File(getApplicationContext().getFilesDir(),"gino.txt");

        int len = (int) file.length();

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[len];
            in.read(bytes);
            String contents = new String(bytes);
            Log.i("RESULT", contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }
        }



    }

    private void writeToFile(String data) {
        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "prova.txt");
        Log.i("[PATH]", path.toString());

        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
            stream.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
