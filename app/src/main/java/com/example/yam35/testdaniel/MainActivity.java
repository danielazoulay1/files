package com.example.yam35.testdaniel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    String string;
    FileOutputStream fos;
    OutputStreamWriter osw;
    BufferedWriter bw;
    TextView tv1;
    InputStream is;
    InputStreamReader tmp;
    BufferedReader reader;
    String str;
    StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) (findViewById(R.id.et1));
        tv1 = (TextView) (findViewById(R.id.tv1));
    }
    public void write(View view) {
        string = et1.getText().toString();
        try {
            fos = openFileOutput(string, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        osw = new OutputStreamWriter(fos);
        bw = new BufferedWriter(osw);
        try {
            bw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read(View view) {
        try {
            is = openFileInput(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tmp = new InputStreamReader(is);
        reader = new BufferedReader(tmp);
        buffer = new StringBuffer();
        try {
            while ((str = reader.readLine()) != null) {
                buffer.append(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv1.setText(buffer);
    }




}
