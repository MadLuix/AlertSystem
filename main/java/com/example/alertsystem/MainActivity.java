package com.example.alertsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void funcalerta(View view) {
        Intent intent = new Intent(MainActivity.this, geraralerta.class);
        startActivity(intent);
    }
    public void funcconsulta(View view) {
        Intent intent = new Intent(MainActivity.this, consultaral.class);
        startActivity(intent);
    }
    public void funcconfig(View view) {
        Intent intent = new Intent(MainActivity.this, configapp.class);
        startActivity(intent);
    }
}