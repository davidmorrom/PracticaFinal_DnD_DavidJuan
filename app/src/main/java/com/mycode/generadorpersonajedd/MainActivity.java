package com.mycode.generadorpersonajedd;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
    private String[] clases_dnd;

    private int[] imagenes_dnd;
    private int[] estadisticas = new int[6];
    private String skills="";
    private String playerName;
    private Button botonGuardar, botonEstadisticas, botonHabilidades;
    private BDHelper BDHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BDHelper = new BDHelper(this, "Personajes", null, 1);
        Intent intent = getIntent();
        playerName = intent.getStringExtra("playerName");

        botonGuardar = findViewById(R.id.botonCrearPersonaje);
        botonEstadisticas = findViewById(R.id.botonEstadisticas);
        botonHabilidades = findViewById(R.id.botonHabilidades);

        botonGuardar.setEnabled(false);
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

            }
        });
        Button botonEstadisticas = findViewById(R.id.botonEstadisticas);
        botonEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ponerEstadisticas();
            }
        });

    }

    public void crearPersonaje() {
        String nombrePersonaje = editTextNombrePersonaje.getText().toString().trim();
        String clasePersonaje = spinnerClase.getSelectedItem().toString().trim();
        if (!nombrePersonaje.isEmpty()) {
            ContentValues values = new ContentValues();
            values.put("NombreJugador", playerName);
            values.put("NombrePersonaje", nombrePersonaje);
            values.put("Clase", clasePersonaje);
            values.put("Fuerza", estadisticas[0]);
            values.put("Destreza", estadisticas[1]);
            values.put("Constitucion", estadisticas[2]);
            values.put("Inteligencia", estadisticas[3]);
            values.put("Sabiduria", estadisticas[4]);
            values.put("Carisma", estadisticas[5]);
            values.put("Habilidades", skills.toString());
            long newRowId = BDHelper.insert("Personajes", null, values);
            Toast.makeText(this, "Se ha introducido con exito", Toast.LENGTH_SHORT).show();
            editTextNombrePersonaje.setText("");
            spinnerClase.setSelection(0);
            skills = "";
            estadisticas = new int[6];
            botonGuardar.setEnabled(false);
            botonEstadisticas.setEnabled(true);
            botonHabilidades.setEnabled(true);
        } else {
            Toast.makeText(this, "Por favor, introduce un nombre de personaje", Toast.LENGTH_SHORT).show();
        }
    }

    public void elegirHabilidades() {
        Intent intent = new Intent(this, Habilidades.class);
        startForResultHabil.launch(intent);
    }

    public void ponerEstadisticas() {
        Intent intent = new Intent(this, Estadisticas.class);
        startForResultEstats.launch(intent);
        actualizarBoton();
    }

    public void actualizarBoton() {
        if (!skills.equals("") && estadisticas[0] != 0 && estadisticas[1] != 0 && estadisticas[2] != 0 && estadisticas[3] != 0 && estadisticas[4] != 0 && estadisticas[5] != 0) {
            botonGuardar.setEnabled(true);
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

    ActivityResultLauncher<Intent> startForResultEstats = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                estadisticas = (int[]) result.getData().getExtras().get("estadisticas");
            }
            actualizarBoton();
            botonEstadisticas.setEnabled(false);
        }
    });
    ActivityResultLauncher<Intent> startForResultHabil = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                skills = (String) result.getData().getExtras().get("Skills-selecionadas");
            }
            actualizarBoton();
            botonHabilidades.setEnabled(false);
        }
    });
}

