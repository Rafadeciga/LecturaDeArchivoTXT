package com.upiita.lecturadearchivodetxt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt1 = findViewById(R.id.tx1);
        InputStream entradaDeDatos = getResources().openRawResource(R.raw.datoss);
        InputStreamReader stream1 = new InputStreamReader(entradaDeDatos);
        BufferedReader buffer1 = new BufferedReader(stream1);


        txt1.setText("Archivo de datos.txt \n ");

        try {
            String linea_datos;

            while(true){
                linea_datos = buffer1.readLine();
                if(linea_datos==null) break;
                txt1.append("\n "+ linea_datos);

            }

            entradaDeDatos.close();
            stream1.close();
            buffer1.close();
        }
        catch (Exception e){

            txt1.append("\n" + e);

        }

        txt1.append("\n\n" + "FIN DEL ARCHIVO" );

    }
}