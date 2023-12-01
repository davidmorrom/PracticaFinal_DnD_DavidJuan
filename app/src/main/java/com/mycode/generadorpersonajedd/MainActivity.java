package com.mycode.generadorpersonajedd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombrePersonaje;
    private Spinner spinnerClase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombrePersonaje = findViewById(R.id.editTextNombrePersonaje);
        spinnerClase = findViewById(R.id.spinnerClase);


        Button botonCrearPersonaje = findViewById(R.id.botonCrearPersonaje);
        botonCrearPersonaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearPersonaje();
            }
        });
    }

    public void crearPersonaje() {
        String nombrePersonaje = editTextNombrePersonaje.getText().toString();
        String clasePersonaje = spinnerClase.getSelectedItem().toString();
        if (!nombrePersonaje.isEmpty()) {
            //Esto lo he hecho para ver si funcionaba pero creo que crashea
            Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, introduce un nombre de personaje", Toast.LENGTH_SHORT).show();
        }
    }
}

