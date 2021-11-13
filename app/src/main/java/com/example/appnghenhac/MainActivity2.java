package com.example.appnghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button buttonSo1, buttonSo2, buttonSo3, buttonSo4, buttonSo5, buttonSo6, buttonSo7, btnChon;
    TextView textSttBai;
    ArrayList<Button> listBtn=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();


    }

    private void AnhXa() {
        buttonSo1 = (Button) findViewById(R.id.buttonSo1);
        buttonSo2 = (Button) findViewById(R.id.buttonSo2);
        buttonSo3 = (Button) findViewById(R.id.buttonSo3);
        buttonSo4 = (Button) findViewById(R.id.buttonSo4);
        buttonSo5 = (Button) findViewById(R.id.buttonSo5);
        buttonSo6 = (Button) findViewById(R.id.buttonSo6);
        buttonSo7 = (Button) findViewById(R.id.buttonSo7);
        btnChon = (Button) findViewById(R.id.buttonSelect);
        textSttBai = (TextView) findViewById(R.id.textSttBai);

    }



    public void Textchange(View view) {
        Button btn = (Button) view;
        textSttBai.setText(btn.getText());
    }

    public void clickChon(View v){
        Button btn = (Button) v;
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        i.putExtra("index", textSttBai.getText());
        startActivity(i);

    }
}