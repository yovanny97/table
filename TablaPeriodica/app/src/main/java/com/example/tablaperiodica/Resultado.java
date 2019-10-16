package com.example.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String Salida = getIntent().getStringExtra("SALIDA");

        String color = getIntent().getStringExtra("COLOR");

        textView = (TextView) findViewById(R.id.textViewR);

        textView.setText(Salida+" "+color);

        if(color.equalsIgnoreCase("ROJO")){
            textView.setTextColor(Color.RED);
        }
        if(color.equalsIgnoreCase("AZUL")){
            textView.setTextColor(Color.BLUE);
        }
        if(color.equalsIgnoreCase("VERDE")){
            textView.setTextColor(Color.GREEN);
        }

        //textView.setTextColor();





    }
}
