package com.example.flooringmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boxes = findViewById(R.id.boxCalc);

        boxes.setOnClickListener(b -> {
            Intent goBoxes = new Intent(MainActivity.this, BoxCalc.class);
            startActivity(goBoxes);
        });



    }




}
