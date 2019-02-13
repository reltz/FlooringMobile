package com.example.flooringmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class BlindCutting extends AppCompatActivity {
    protected EditText initialBlind;
    protected EditText finalBlind;
    protected Switch twoSided;
    protected TextView output;
    protected TextView outputFraction;
    protected Button calculate;
    protected Button resetIt;

    protected double initialBlindDouble;
    protected double finalBlindDouble;
    protected double cut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blind_cutting);
        initialBlind = findViewById(R.id.intialBlind);
        finalBlind = findViewById(R.id.finalBlind);
        twoSided = findViewById(R.id.switch1);
        output = findViewById(R.id.outputBlind);
        outputFraction = findViewById(R.id.outputFraction);
        calculate = findViewById(R.id.calculateCut);
        resetIt = findViewById(R.id.resetBlind);


        calculate.setOnClickListener(b -> {
            try {
                initialBlindDouble = Float.valueOf(initialBlind.getText().toString());
                finalBlindDouble = Float.valueOf(finalBlind.getText().toString());
                if (twoSided.isChecked()) {
                    cut = (initialBlindDouble - finalBlindDouble) / 2;
                    output.setText(String.format(Locale.CANADA,
                            "You have to cut %.2f from each side", cut));

                } else {
                    cut = initialBlindDouble - finalBlindDouble;
                    output.setText(String.format(Locale.CANADA,
                            "You have to cut %.2f from one side", cut));
                }

                

            } catch (RuntimeException e) {
                if (!Double.isNaN(initialBlindDouble) || !Double.isNaN(finalBlindDouble)) {
                    output.setText("Enter valid number values");
                }
            }


        });

        resetIt.setOnClickListener(r -> {
            initialBlind.setText("");
            finalBlind.setText("");
            output.setText("");

        });


    }
}
