package com.example.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rbGroup ;

    Button btn;
    Spinner spinner;
    String Nombre="",Salida="",Simbolo="",NumeroA="",Masa="",Grupo="",formatoElemneto;
    ArrayList<String> elementList = new ArrayList<String>();
    ArrayList<String> formato = new ArrayList<String>();
    CheckBox checkBoxes [] = new CheckBox[4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbGroup = (RadioGroup) findViewById(R.id.rbGroup);





        btn=(Button)findViewById(R.id.button);

        spinner=(Spinner) findViewById(R.id.spinner);

        checkBoxes [0] = (CheckBox) findViewById(R.id.checkBoxSimbolo);
        checkBoxes [1] = (CheckBox) findViewById(R.id.checkBoxNumero);
        checkBoxes [2] = (CheckBox) findViewById(R.id.checkBoxMasa);
        checkBoxes [3] = (CheckBox) findViewById(R.id.checkBoxGupo);



        btn.setOnClickListener(this);


        leerArchivo();






    }

    private void leerArchivo(){
        try{

            InputStream file = getResources().openRawResource(R.raw.datos);
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

            while (line != null){
                String [] element = line.split("-");


                formato.add(element[0]);

                line = bufferedReader.readLine();


            }

            for (int i = 0 ; i < formato.size(); i++){
                String [] element = formato.get(i).split(":");
                elementList.add(element[1]);
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,elementList);
            spinner.setAdapter(arrayAdapter);



        }catch (Exception e){

        }
    }

    private void obtenerInfo(){

        String selectedElement = (String) spinner.getSelectedItem();

        switch (selectedElement){
            case "Hidrogeno":
                formatoElemneto = formato.get(0);
                break;
            case "Helio":
                formatoElemneto = formato.get(1);
                break;
            case "Litio":
                formatoElemneto = formato.get(2);
                break;
            case "Berilio":
                formatoElemneto = formato.get(3);
                break;
            case "Boro":
                formatoElemneto = formato.get(4);
                break;

                default:
                    formatoElemneto = "";

        }
        String informacion [] = formatoElemneto.split(":");







        if(checkBoxes[0].isChecked()){
            Simbolo = "Simbolo: "+informacion[0];
        }
        if(checkBoxes[1].isChecked()){
            NumeroA = "Número atómico: "+informacion[2];
        }
        if(checkBoxes[2].isChecked()){
            Masa = "Masa atómica: "+informacion[3];
        }
        if(checkBoxes[3].isChecked()){
            Grupo = "Grupo: "+informacion[4];
        }

        String color = "";

        int idbox = rbGroup.getCheckedRadioButtonId();



        switch (idbox){
            case R.id.radioButtonAzul:

                color = "AZUL" ;

                break;
            case R.id.radioButtonRojo:

                color = "ROJO";

                break;
            case R.id.radioButtonVerde:

                color = "VERDE";

                break;
        }







        Salida = "Nombre: "+selectedElement+"\n"+Simbolo+"\n"+NumeroA+"\n"+Masa+"\n"+Grupo;







        Toast.makeText(getApplicationContext(),Salida,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),Resultado.class);

        intent.putExtra("SALIDA",Salida);
        intent.putExtra("COLOR",color);


        startActivity(intent);




    }





    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.button){



            obtenerInfo();
        }

    }
}
