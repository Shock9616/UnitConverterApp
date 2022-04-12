package com.example.unitconverter;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LengthActivity extends AppCompatActivity
{

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
    }
}

