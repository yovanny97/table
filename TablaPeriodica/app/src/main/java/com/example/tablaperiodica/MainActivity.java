package com.example.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioButton rbazul,rbrojo,rbverde;
    CheckBox cbSimbolo,cbnum,cbmasa,cbgrupo;
    Button btn;
    ListView list;
    String Nombre,Simbolo,NumeroA,Masa,Grupo;
    ArrayList<String> elementList = new ArrayList<String>();

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

        leerArchivo();

    }

    private void leerArchivo(){
        try{

            InputStream file = getResources().openRawResource(R.raw.datos);
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while (line != null){
                String [] element = line.split(":");


                elementList.add(element[1]);

                line = bufferedReader.readLine();


            }

            for (String l : elementList){
                Log.i("Elements",l);
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,elementList);
            list.setAdapter(arrayAdapter);



        }catch (Exception e){

        }
    }
}
