package com.example.flooringmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class BoxCalc extends AppCompatActivity {
    protected double measure;
    protected EditText myMeasure;
    protected Button calculate;
    protected Button resetIt;

    protected EditText boxCoverage;
    protected double coverage;
    protected CheckBox ten;

    protected EditText price;
    protected double thePrice;

    protected TextView display;

    protected String output;
    protected double boxNumber;
    protected double priceSqFt;


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

        //10percent
        ten = findViewById(R.id.checkBox);

        ten.setOnClickListener(t -> {
            if (ten.isChecked()) {
                measure = Float.valueOf(myMeasure.getText().toString())*1.1;
            }
            else {
                measure = Float.valueOf(myMeasure.getText().toString());
            }

        });




        display = findViewById(R.id.outputBox);
        calculate.setOnClickListener( b-> {
            //exception handling needed -> boxes cant be empty!


                thePrice = Float.valueOf(price.getText().toString());
                coverage = Float.valueOf(boxCoverage.getText().toString());
                //measure = Float.valueOf(myMeasure.getText().toString());


                    boxNumber = (measure  / coverage);

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
