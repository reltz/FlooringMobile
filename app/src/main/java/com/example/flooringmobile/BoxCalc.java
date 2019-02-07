package com.example.flooringmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BoxCalc extends AppCompatActivity {
    protected float measure;
    protected EditText myMeasure;
    protected Button calculate;
    protected Button resetIt;

    protected EditText boxCoverage;
    protected float coverage;

    protected EditText price;
    protected float thePrice;

    protected TextView display;

    protected String output;
    protected float boxNumber;
    protected float priceSqFt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_calc);

        calculate = findViewById(R.id.calculateBoxes);

        //measures
        myMeasure = findViewById(R.id.measure1);

        //coverage
        boxCoverage = findViewById(R.id.boxSize1);

        //price
        price = findViewById(R.id.price1);



        display = findViewById(R.id.outputBox);
        calculate.setOnClickListener( b-> {
            //exception handling needed -> boxes cant be empty!
                thePrice = Float.valueOf(price.getText().toString());
                coverage = Float.valueOf(boxCoverage.getText().toString());
                measure = Float.valueOf(myMeasure.getText().toString());
                boxNumber = (measure / coverage);
                output = "You need " + boxNumber + " boxes!";
                display.setText(output);



        });

//        resetIt.setOnClickListener( r -> {
//            myMeasure.setText("");
//            price.setText("");
//            boxCoverage.setText("");
//            display.setText("");
//
//
//
//        });


    }
}
