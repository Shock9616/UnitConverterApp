package com.example.unitconverter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;;

public class SpeedActivity extends AppCompatActivity
{

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
    }
}