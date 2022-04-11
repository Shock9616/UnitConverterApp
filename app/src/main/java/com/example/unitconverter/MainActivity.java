package com.example.unitconverter;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lengthButton = findViewById(R.id.length_button);
        lengthButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LengthActivity.class)));

        Button weightButton = findViewById(R.id.weight_button);
        weightButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WeightActivity.class)));

        Button speedButton = findViewById(R.id.speed_button);
        speedButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SpeedActivity.class)));

        Button volumeButton = findViewById(R.id.volume_button);
        volumeButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, VolumeActivity.class)));
    }
}