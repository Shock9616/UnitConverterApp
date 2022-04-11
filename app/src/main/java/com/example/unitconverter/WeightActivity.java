package com.example.unitconverter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WeightActivity extends AppCompatActivity
{

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
    }
}