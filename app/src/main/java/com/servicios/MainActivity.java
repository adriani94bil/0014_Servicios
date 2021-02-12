package com.servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.servicios.servicios.MiService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton=findViewById(R.id.btnIniciar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent servicio= new Intent(MainActivity.this, MiService.class);
                startService(servicio);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent servicio= new Intent(MainActivity.this, MiService.class);
        stopService(servicio);
    }
}