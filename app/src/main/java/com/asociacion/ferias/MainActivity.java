package com.asociacion.ferias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.asociacion.ferias.conciertos.Lista_Conciertos;
import com.asociacion.ferias.cultura.Lista_Cultura;
import com.asociacion.ferias.patrocinadores.Lista_Patrocinadores;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btncultura, btnconciertos, btnpatrocinadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.textDate);
        textViewDate.setText(currentDate);


        btncultura =  findViewById(R.id.btncultura);
        btnconciertos =  findViewById(R.id.btnconciertos);
        btnpatrocinadores = findViewById(R.id.btnpatrocinadores);

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
