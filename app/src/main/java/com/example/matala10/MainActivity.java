package com.example.matala10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    EditText et1, et2, et3;
    Boolean bool1 = true;
    Boolean bool2 = true;
    Boolean bool3 = true;
    Boolean bool4 = true;
    double a;
    double b;
    double c;
    String st1;
    String st2;
    String st3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
    }

    public void random_numbers(View view){
        Random rnd = new Random();
            a = (double)rnd.nextInt(19)+1;
            b = (double)rnd.nextInt(19)+1;
            c = (double)rnd.nextInt(19)+1;
            et1.setText(String.valueOf(a));
            et2.setText(String.valueOf(b));
            et3.setText(String.valueOf(c));
            bool1 = false;
    }

    public void go(View view) {
        a = Double.parseDouble(et1.getText().toString());
        if (a==0.0){
            Toast.makeText(this, "the firs number can not be zero", Toast.LENGTH_SHORT).show();
        }
        b = Double.parseDouble(et2.getText().toString());
        c = Double.parseDouble(et3.getText().toString());
        st1 = et1.getText().toString();
        st2 = et2.getText().toString();
        st3 = et3.getText().toString();
        if (st1.equals("")){
            bool1 = true;
        }
        else{
            bool1 = false;
        }
        if (st2.equals("")){
            bool2 = true;
        }
        else{
            bool2 = false;
        }
        if (st3.equals("")){
            bool3 = true;
        }
        else{
            bool3 = false;
        }
        if (bool1==true && bool2==true && bool3==true && bool4==true){
            Toast.makeText(this, "you can not do it, i'll choose random numbers for you", Toast.LENGTH_SHORT).show();
            random_numbers(view);
        }
        Intent intent = new Intent(this, Solution_Activity.class);
        intent.putExtra("a", a);
        intent.putExtra("b", b);
        intent.putExtra("c", c);
        startActivity(intent);
    }
}