package com.example.unitconverter;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VolumeActivity extends AppCompatActivity
{

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
    }
}