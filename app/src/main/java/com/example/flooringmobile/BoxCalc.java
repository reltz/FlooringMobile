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
    protected double totalPrice;

    protected TextView display;
    protected TextView finalPrice;
    protected TextView pricePerFoot;

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



        display = findViewById(R.id.outputBox);
        calculate.setOnClickListener( b-> {
            //exception handling needed -> boxes cant be empty!
                if (ten.isChecked()) {
                    try {measure = Float.valueOf(myMeasure.getText().toString())*1.1;}
                    catch (RuntimeException e) {
                        if (!Double.isNaN(measure)) {
                            measure=0d;
                        }
                    }

                }
                else {
                    try {measure = Float.valueOf(myMeasure.getText().toString()); }
                    catch (RuntimeException e) {
                        if (!Double.isNaN(measure)) {
                            measure=0d;
                        }
                    }

                }

               try {
                   thePrice = Float.valueOf(price.getText().toString());
               } catch (RuntimeException e) {
                   if (!Double.isNaN(thePrice)) {
                       thePrice=0d;
                   }
               }

                coverage = Float.valueOf(boxCoverage.getText().toString());
                //measure = Float.valueOf(myMeasure.getText().toString());


                    boxNumber = Math.ceil(measure  / coverage);

                String output1 = String.format("%s %d %s","You need ",(int) boxNumber," boxes!");
                display.setText(output1);


                totalPrice=thePrice*boxNumber;
                String output2 = String.format("Total price is: $ %.2f",totalPrice);
                finalPrice = findViewById(R.id.totalPrice);
                finalPrice.setText(output2);

                pricePerFoot = findViewById(R.id.pricePerSquare);
                priceSqFt = thePrice/coverage;
                String output3= String.format("Price per SqFt is $ %.2f",priceSqFt);
                pricePerFoot.setText(output3);




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
