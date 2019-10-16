package com.example.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rbazul,rbrojo,rbverde;
    CheckBox cbSimbolo,cbnum,cbmasa,cbgrupo;
    Button btn;
    ListView list;
    String Nombre,Simbolo,NumeroA,Masa,Grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbazul=(RadioButton)findViewById(R.id.radioButtonAzul);
        rbrojo=(RadioButton)findViewById(R.id.radioButtonRojo);
        rbverde=(RadioButton)findViewById(R.id.radioButtonVerde);

        cbSimbolo=(CheckBox)findViewById(R.id.checkBoxSimbolo);
        cbnum=(CheckBox)findViewById(R.id.checkBoxNumero);
        cbmasa=(CheckBox)findViewById(R.id.checkBoxMasa);
        cbgrupo=(CheckBox)findViewById(R.id.checkBoxGupo);

        btn=(Button)findViewById(R.id.button);

        list=(ListView)findViewById(R.id.lista);

    }
}
