package com.example.matala10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Solution_Activity extends AppCompatActivity {
    Button btn_2;
    TextView tv2, tv3;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        btn_2 = findViewById(R.id.btn_2);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        iv = findViewById(R.id.iv);
        double result1 = 0.0;
        double result2 = 0.0;
        Intent intent = getIntent();
        double a = intent.getDoubleExtra("a", 0.0);
        double b = intent.getDoubleExtra("b", 0.0);
        double c = intent.getDoubleExtra("c", 0.0);
        Toast.makeText(this, " "+ a + " " + b + " " + c , Toast.LENGTH_SHORT).show();
        if ((c*4*a)>(b*b)){
            Toast.makeText(this, "There is no solution", Toast.LENGTH_SHORT).show();
            if (a>0){
                iv.setImageResource(R.drawable.five);
            }
            else{
                iv.setImageResource(R.drawable.one);
            }
        }
        else if (c*4*a==b*b){
            Toast.makeText(this, "There is only one solution", Toast.LENGTH_SHORT).show();
            if (a>0){
                iv.setImageResource(R.drawable.six);
            }
            else{
                iv.setImageResource(R.drawable.four);
            }
            result1 = -b / (2*a);
            tv2.setText("the only solution is: " + String.valueOf(result1));
        }
        else{
            Toast.makeText(this, "There is two solution", Toast.LENGTH_SHORT).show();
            if (a>0){
                iv.setImageResource(R.drawable.two);
            }
            else{
                iv.setImageResource(R.drawable.three);
            }
            result1 = (-b + Math.sqrt(b*b-(4*a*c)))/(2*a);
            result2 = (-b - Math.sqrt(b*b-(4*a*c)))/(2*a);
            tv2.setText("the first solution is: " + String.valueOf(result1));
            tv3.setText("the second solution is: " + String.valueOf(result2));
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}