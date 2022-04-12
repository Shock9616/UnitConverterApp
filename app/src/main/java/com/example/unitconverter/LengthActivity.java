package com.example.unitconverter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.widget.Button;
import android.widget.Toast;

public class LengthActivity extends AppCompatActivity
{
    private EditText text1;
    private EditText text2;
    private Button convert;
    private Spinner fromUnit;
    private Spinner toUnit;
    private final String[] vals = new String[]
            {
                    "Millimeters", //0
                    "Centimeters", //1
                    "Decimeters", //2
                    "Meters", //3
                    "Kilometers" //4
            };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        FloatingActionButton lengthBackButton = findViewById(R.id.length_back_button);
        lengthBackButton.setOnClickListener(v -> startActivity(new Intent(LengthActivity.this, MainActivity.class)));

        ArrayAdapter<CharSequence> lengthUnitsAdapter = ArrayAdapter.createFromResource(this, R.array.length_units, android.R.layout.simple_spinner_item);
        lengthUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinnerLengthFromUnits = findViewById(R.id.length_value_from_unit);
        spinnerLengthFromUnits.setAdapter(lengthUnitsAdapter);
        
        Spinner spinnerLengthToUnits = findViewById(R.id.length_value_to_unit);
        spinnerLengthToUnits.setAdapter(lengthUnitsAdapter);

        text1 = (EditText) findViewById(R.id.length_value_from_view);
        text2 = (EditText) findViewById(R.id.length_value_to_view);
        convert = (Button) findViewById(R.id.length_convert_button);
        fromUnit = (Spinner) findViewById(R.id.length_value_from_unit);
        toUnit = (Spinner) findViewById(R.id.length_value_to_unit);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text1.getText().length()>0)
                {
                    double result = 0;
                    double oper1 = Double.parseDouble(text1.getText().toString());

                    //retrieve the selection from the first drop down.
                    //default all values into millimeters and calculate from there onwards.
                    if(fromUnit.getSelectedItem().equals(vals[0]))
                        oper1 *= 1;
                    else if(fromUnit.getSelectedItem().equals(vals[1]))
                        oper1 *= 10;
                    else if(fromUnit.getSelectedItem().equals(vals[2]))
                        oper1 *= 100;
                    else if(fromUnit.getSelectedItem().equals(vals[3]))
                        oper1 *= 1000;
                    else if(fromUnit.getSelectedItem().equals(vals[4]))
                        oper1 *= 1000000;

                    //retrieve the selections from the second drop down.
                    //convert from base value of millimeters to selected unit.
                    if(toUnit.getSelectedItem().equals(vals[0]))
                        result = oper1 * 1;
                    else if(toUnit.getSelectedItem().equals(vals[1]))
                        result = oper1 * 0.10;
                    else if(toUnit.getSelectedItem().equals(vals[2]))
                        result = oper1 * 0.01;
                    else if(toUnit.getSelectedItem().equals(vals[3]))
                        result = oper1 * 0.001;
                    else if(toUnit.getSelectedItem().equals(vals[4]))
                        result = oper1 * 0.000001;

                    //prints results in the second textbox
                    text2.setText(Double.toString(result));
                }
                else
                {
                    Toast toast= Toast.makeText(LengthActivity.this,"Enter The Required Field!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}

