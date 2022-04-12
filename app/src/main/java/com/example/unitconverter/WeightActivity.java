package com.example.unitconverter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WeightActivity extends AppCompatActivity
{
    //variables that we will use to aid us access the data from the app template
    private EditText text1;
    private EditText text2;
    private Button convert;
    private Spinner fromUnit;
    private Spinner toUnit;
    private final String[] vals = new String[]
            {
                    "Grams", //0
                    "Milligrams", //1
                    "Kilograms", //2
                    "Pounds" //3
            };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        FloatingActionButton weightBackButton = findViewById(R.id.weight_back_button);
        weightBackButton.setOnClickListener(v -> startActivity(new Intent(WeightActivity.this, MainActivity.class)));

        ArrayAdapter<CharSequence> weightUnitsAdapter = ArrayAdapter.createFromResource(this, R.array.weight_units, android.R.layout.simple_spinner_item);
        weightUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinnerWeightFromUnits = findViewById(R.id.weight_value_from_unit);
        spinnerWeightFromUnits.setAdapter(weightUnitsAdapter);

        Spinner spinnerWeightToUnits = findViewById(R.id.weight_value_to_unit);
        spinnerWeightToUnits.setAdapter(weightUnitsAdapter);

        text1 = (EditText) findViewById(R.id.weight_value_from_view);
        text2 = (EditText) findViewById(R.id.weight_value_to_view);
        convert = (Button) findViewById(R.id.weight_convert_button);
        fromUnit = (Spinner) findViewById(R.id.weight_value_from_unit);
        toUnit = (Spinner) findViewById(R.id.weight_value_to_unit);
        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(text1.getText().length()>0)
                {
                    double result = 0;
                    double oper1 = Double.parseDouble(text1.getText().toString());

                    //retrieve the selection from the first drop down.
                    //default all values into mg and calculate from there onwards.
                    if(fromUnit.getSelectedItem().equals(vals[0]))
                        oper1 *= 1;
                    else if(fromUnit.getSelectedItem().equals(vals[1]))
                        oper1 *= 1000;
                    else if(fromUnit.getSelectedItem().equals(vals[2]))
                        oper1 *= 1000000;
                    else if(fromUnit.getSelectedItem().equals(vals[3]))
                        oper1 *= 453592;

                    //retrieve the selections from the second drop down.
                    //convert from base value of mg to selected unit.
                    if(toUnit.getSelectedItem().equals(vals[0]))
                        result = oper1 * 0.001;
                    else if(toUnit.getSelectedItem().equals(vals[1]))
                        result = oper1 * 1;
                    else if(toUnit.getSelectedItem().equals(vals[2]))
                        result = oper1 * 0.000001;
                    else if(toUnit.getSelectedItem().equals(vals[3]))
                        result = oper1 * 0.00000220462;


                    //prints results in the second textbox
                    String s = String.format("%.6f", result);
                    text2.setText(s);
                }
                else
                {
                    Toast toast= Toast.makeText(WeightActivity.this,"Enter The Required Field!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}