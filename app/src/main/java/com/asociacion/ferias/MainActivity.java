package com.asociacion.ferias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asociacion.ferias.conciertos.Lista_Conciertos;
import com.asociacion.ferias.cultura.Lista_Cultura;
import com.asociacion.ferias.patrocinadores.Lista_Patrocinadores;

public class MainActivity extends AppCompatActivity {

    Button btncultura, btnconciertos, btnpatrocinadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncultura = (Button) findViewById(R.id.btncultura);
        btnconciertos = (Button) findViewById(R.id.btnconciertos);
        btnpatrocinadores = (Button) findViewById(R.id.btnpatrocinadores);

        btncultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lista_Cultura.class);
                startActivity(intent);
            }
        });

        btnconciertos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lista_Conciertos.class);
                startActivity(intent);
            }
        });

        btnpatrocinadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lista_Patrocinadores.class);
                startActivity(intent);
            }
        });

    }
}
