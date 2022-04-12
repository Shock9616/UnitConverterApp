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

import com.google.android.material.floatingactionbutton.FloatingActionButton;;

public class SpeedActivity extends AppCompatActivity
{
    //variables that we will use to aid us access the data from the app template
    private EditText text1;
    private EditText text2;
    private Button convert;
    private Spinner fromUnit;
    private Spinner toUnit;
    private final String[] vals = new String[]
            {
                    "Miles per Hour", //0
                    "Km Per Hour", //1
                    "Meters per Second", //2
                    "Feet per Second" //3
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        FloatingActionButton speedBackButton = findViewById(R.id.speed_back_button);
        speedBackButton.setOnClickListener(v -> startActivity(new Intent(SpeedActivity.this, MainActivity.class)));

        ArrayAdapter<CharSequence> speedUnitsAdapter = ArrayAdapter.createFromResource(this, R.array.speed_units, android.R.layout.simple_spinner_item);
        speedUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner spinnerSpeedFromUnits = findViewById(R.id.speed_value_from_unit);
        spinnerSpeedFromUnits.setAdapter(speedUnitsAdapter);

        Spinner spinnerSpeedToUnits = findViewById(R.id.speed_value_to_unit);
        spinnerSpeedToUnits.setAdapter(speedUnitsAdapter);

        text1 = (EditText) findViewById(R.id.speed_value_from_view);
        text2 = (EditText) findViewById(R.id.speed_value_to_view);
        convert = (Button) findViewById(R.id.speed_convert_button);
        fromUnit = (Spinner) findViewById(R.id.speed_value_from_unit);
        toUnit = (Spinner) findViewById(R.id.speed_value_to_unit);
        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(text1.getText().length()>0)
                {
                    double result = 0;
                    double oper1 = Double.parseDouble(text1.getText().toString());

                    //retrieve the selection from the first drop down.
                    //default all values into kph and calculate from there onwards.
                    if(fromUnit.getSelectedItem().equals(vals[0]))
                        oper1 *= 1.60934;
                    else if(fromUnit.getSelectedItem().equals(vals[1]))
                        oper1 *= 1;
                    else if(fromUnit.getSelectedItem().equals(vals[2]))
                        oper1 *= 3.6;
                    else if(fromUnit.getSelectedItem().equals(vals[3]))
                        oper1 *= 1.09728;

                    //retrieve the selections from the second drop down.
                    //convert from base value of kph to selected unit.
                    if(toUnit.getSelectedItem().equals(vals[0]))
                        result = oper1 * 0.621371;
                    else if(toUnit.getSelectedItem().equals(vals[1]))
                        result = oper1 * 1;
                    else if(toUnit.getSelectedItem().equals(vals[2]))
                        result = oper1 * 0.27777;
                    else if(toUnit.getSelectedItem().equals(vals[3]))
                        result = oper1 * 0.911344;


                    //prints results in the second textbox
                    String s = String.format("%.6f", result);
                    text2.setText(s);
                }
                else
                {
                    Toast toast= Toast.makeText(SpeedActivity.this,"Enter The Required Field!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
