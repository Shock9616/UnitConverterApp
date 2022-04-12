package com.example.unitconverter;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VolumeActivity extends AppCompatActivity
{
    //variables that we will use to aid us access the data from the app template
    private EditText text1;
    private EditText text2;
    private Button convert;
    private Spinner fromUnit;
    private Spinner toUnit;
    //string array with the values of the dropdowns.
    private final String[] vals = new String[]
            {
                    "Gallons", //0
                    "Cups", //1
                    "Tablespoons", //2
                    "Teaspoons", //3
                    "Liters",  //4
                    "Milliliters" //5
            };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        FloatingActionButton volumeBackButton = findViewById(R.id.volume_back_button);
        volumeBackButton.setOnClickListener(v -> startActivity(new Intent(VolumeActivity.this, MainActivity.class)));

        ArrayAdapter<CharSequence> volumeUnitsAdapter = ArrayAdapter.createFromResource(this, R.array.volume_units, android.R.layout.simple_spinner_item);
        volumeUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinnerVolumeFromUnits = findViewById(R.id.volume_value_from_unit);
        spinnerVolumeFromUnits.setAdapter(volumeUnitsAdapter);

        Spinner spinnerVolumeToUnits = findViewById(R.id.volume_value_to_unit);
        spinnerVolumeToUnits.setAdapter(volumeUnitsAdapter);

        text1 = (EditText) findViewById(R.id.volume_value_from_view);
        text2 = (EditText) findViewById(R.id.volume_value_to_view);
        convert = (Button) findViewById(R.id.volume_convert_button);
        fromUnit = (Spinner) findViewById(R.id.volume_value_from_unit);
        toUnit = (Spinner) findViewById(R.id.volume_value_to_unit);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text1.getText().length()>0)
                {
                    double result = 0;
                    double oper1 = Double.parseDouble(text1.getText().toString());

                    //retrieve the selection from the first drop down.
                    //default all values into ml and calculate from there onwards.
                    if(fromUnit.getSelectedItem().equals(vals[0]))
                        oper1 *= 3785.41;
                    else if(fromUnit.getSelectedItem().equals(vals[1]))
                        oper1 *= 236.588;
                    else if(fromUnit.getSelectedItem().equals(vals[2]))
                        oper1 *= 14.7868;
                    else if(fromUnit.getSelectedItem().equals(vals[3]))
                        oper1 *= 4.92892;
                    else if(fromUnit.getSelectedItem().equals(vals[4]))
                        oper1 *= 1000;
                    else if(fromUnit.getSelectedItem().equals(vals[5]))
                        oper1 *= 1;

                    //retrieve the selections from the second drop down.
                    //convert from base value of ml to selected unit.
                    if(toUnit.getSelectedItem().equals(vals[0]))
                        result = oper1 * 0.000264172;
                    else if(toUnit.getSelectedItem().equals(vals[1]))
                        result = oper1 * 0.00422675;
                    else if(toUnit.getSelectedItem().equals(vals[2]))
                        result = oper1 * 0.067628;
                    else if(toUnit.getSelectedItem().equals(vals[3]))
                        result = oper1 * 0.202884;
                    else if(toUnit.getSelectedItem().equals(vals[4]))
                        result = oper1 * 0.001;
                    else if(toUnit.getSelectedItem().equals(vals[5]))
                        result = oper1 * 1;

                    //prints results into second textbox
                    String s = String.format("%.4f", result);

                    text2.setText(s);



                }
                else
                {
                    Toast toast= Toast.makeText(VolumeActivity.this,"Enter The Required Field!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}