package com.mycode.generadorpersonajedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombrePersonaje;
    private Spinner spinnerClase;
    private String [] clases_dnd;;
    private int [] imagenes_dnd;
    private int[] estadisticas = new int[6];
    ArrayList<String> skills = new ArrayList<>();

    Button botonGuardar,botonEstadisticas,botonHabilidades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonGuardar = findViewById(R.id.botonCrearPersonaje);
        botonEstadisticas = findViewById(R.id.botonEstadisticas);
        botonHabilidades = findViewById(R.id.botonHabilidades);

        botonGuardar.setActivated(false);
        clases_dnd = getResources().getStringArray(R.array.clases_dnd);
        imagenes_dnd = new int[]{R.drawable.barbaro, R.drawable.bardo, R.drawable.brujo, R.drawable.clerigo, R.drawable.druida, R.drawable.explorador, R.drawable.guerrero, R.drawable.hechicero, R.drawable.mago, R.drawable.monje, R.drawable.paladin, R.drawable.picaro};

        editTextNombrePersonaje = findViewById(R.id.editTextNombrePersonaje);
        spinnerClase = findViewById(R.id.spinnerClase);
        ClasesAdapter adapter = new ClasesAdapter();
        spinnerClase.setAdapter(adapter);

        Button botonCrearPersonaje = findViewById(R.id.botonCrearPersonaje);
        botonCrearPersonaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearPersonaje();
            }
        });
        Button botonHabilidades = findViewById(R.id.botonHabilidades);
        botonHabilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirHabilidades();
                actualizarBoton();
            }
        });
        Button botonEstadisticas = findViewById(R.id.botonEstadisticas);
        botonEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ponerEstadisticas();
                actualizarBoton();
            }
        });
    }

    public void crearPersonaje() {
        String nombrePersonaje = editTextNombrePersonaje.getText().toString();
        String clasePersonaje = spinnerClase.getSelectedItem().toString();
        if (!nombrePersonaje.isEmpty()) {
            Toast.makeText(this, "Se ha introducido con exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, introduce un nombre de personaje", Toast.LENGTH_SHORT).show();
        }
    }

    public void elegirHabilidades(){
        Intent intent = getIntent();
        skills = (ArrayList<String>) intent.getExtras().get("Skills-selecionadas");
    }
    public void ponerEstadisticas(){
        Intent intent = getIntent();
        estadisticas = (int[]) intent.getExtras().get("estadisticas");
    }
    public void actualizarBoton(){
        if (!skills.isEmpty() && estadisticas[0] != 0 && estadisticas[1] != 0 && estadisticas[2] != 0 && estadisticas[3] != 0 && estadisticas[4] != 0 && estadisticas[5] != 0) {
            botonGuardar.setActivated(true);
        }
    }
    class ClasesAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return clases_dnd.length;
        }

        @Override
        public Object getItem(int position) {
            return clases_dnd[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.itemspinner, null);
            ImageView iv1 = convertView.findViewById(R.id.ivDnD);
            TextView tv1 = convertView.findViewById(R.id.tvDnD);
            iv1.setImageResource(imagenes_dnd[position]);
            tv1.setText(clases_dnd[position]);
            return convertView;
        }
    }
}

