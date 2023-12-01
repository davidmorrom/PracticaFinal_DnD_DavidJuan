package com.mycode.generadorpersonajedd;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Estadisticas extends AppCompatActivity {
    ImageView imgFuerza1, imgFuerza2, imgFuerza3, imgDestreza1, imgDestreza2, imgDestreza3, imgConstitucion1, imgConstitucion2, imgConstitucion3, imgInteligencia1, imgInteligencia2, imgInteligencia3, imgSabiduria1, imgSabiduria2, imgSabiduria3, imgCarisma1, imgCarisma2, imgCarisma3;
    EditText editTextFuerza, editTextDestreza, editTextConstitucion, editTextInteligencia, editTextSabiduria, editTextCarisma;
    Button botonFuerza, botonDestreza, botonConstitucion, botonInteligencia, botonSabiduria, botonCarisma;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        imgFuerza1 = findViewById(R.id.imgFuerza1);
        imgFuerza2 = findViewById(R.id.imgFuerza2);
        imgFuerza3 = findViewById(R.id.imgFuerza3);
        imgDestreza1 = findViewById(R.id.imgDestreza1);
        imgDestreza2 = findViewById(R.id.imgDestreza2);
        imgDestreza3 = findViewById(R.id.imgDestreza3);
        imgConstitucion1 = findViewById(R.id.imgConstitucion1);
        imgConstitucion2 = findViewById(R.id.imgConstitucion2);
        imgConstitucion3 = findViewById(R.id.imgConstitucion3);
        imgInteligencia1 = findViewById(R.id.imgInteligencia1);
        imgInteligencia2 = findViewById(R.id.imgInteligencia2);
        imgInteligencia3 = findViewById(R.id.imgInteligencia3);
        imgSabiduria1 = findViewById(R.id.imgSabiduria1);
        imgSabiduria2 = findViewById(R.id.imgSabiduria2);
        imgSabiduria3 = findViewById(R.id.imgSabiduria3);
        imgCarisma1 = findViewById(R.id.imgCarisma1);
        imgCarisma2 = findViewById(R.id.imgCarisma2);
        imgCarisma3 = findViewById(R.id.imgCarisma3);
        editTextFuerza = findViewById(R.id.edtFuerza);
        editTextDestreza = findViewById(R.id.edtDestreza);
        editTextConstitucion = findViewById(R.id.edtConstitucion);
        editTextInteligencia = findViewById(R.id.edtInteligencia);
        editTextSabiduria = findViewById(R.id.edtSabiduria);
        editTextCarisma = findViewById(R.id.edtCarisma);
        botonFuerza = findViewById(R.id.btnFuerza);
        botonDestreza = findViewById(R.id.btnDestreza);
        botonConstitucion = findViewById(R.id.btnConstitucion);
        botonInteligencia = findViewById(R.id.btnInteligencia);
        botonSabiduria = findViewById(R.id.btnSabiduria);
        botonCarisma = findViewById(R.id.btnCarisma);
        TextWatcher tWatch = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!editTextFuerza.getText().toString().isEmpty() && !editTextDestreza.getText().toString().isEmpty() && !editTextConstitucion.getText().toString().isEmpty() && !editTextInteligencia.getText().toString().isEmpty() && !editTextSabiduria.getText().toString().isEmpty() && !editTextCarisma.getText().toString().isEmpty()){
                    int[] estadisticas = new int[6];
                    estadisticas[0] = Integer.parseInt(editTextFuerza.getText().toString());
                    estadisticas[1] = Integer.parseInt(editTextDestreza.getText().toString());
                    estadisticas[2] = Integer.parseInt(editTextConstitucion.getText().toString());
                    estadisticas[3] = Integer.parseInt(editTextInteligencia.getText().toString());
                    estadisticas[4] = Integer.parseInt(editTextSabiduria.getText().toString());
                    estadisticas[5] = Integer.parseInt(editTextCarisma.getText().toString());

                    Intent intent = new Intent();
                    intent.putExtra("estadisticas", estadisticas);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        };
        editTextFuerza.addTextChangedListener(tWatch);
        editTextDestreza.addTextChangedListener(tWatch);
        editTextConstitucion.addTextChangedListener(tWatch);
        editTextInteligencia.addTextChangedListener(tWatch);
        editTextSabiduria.addTextChangedListener(tWatch);
        editTextCarisma.addTextChangedListener(tWatch);
    }
    public void onClick(View view){
        puntuacionAleatoria(view);
    }

    public void puntuacionAleatoria(View view) {
        int v1 = 1 + (int) (Math.random() * 6);
        int v2 = 1 + (int) (Math.random() * 6);
        int v3 = 1 + (int) (Math.random() * 6);
        if (view == botonFuerza) {
            switch (v1) {
                case 1:
                    imgFuerza1.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgFuerza1.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgFuerza1.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgFuerza1.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgFuerza1.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgFuerza1.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v2) {
                case 1:
                    imgFuerza2.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgFuerza2.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgFuerza2.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgFuerza2.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgFuerza2.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgFuerza2.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v3) {
                case 1:
                    imgFuerza3.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgFuerza3.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgFuerza3.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgFuerza3.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgFuerza3.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgFuerza3.setImageResource(R.drawable.dado6);
                    break;
            }
            botonFuerza.setClickable(false);
            editTextFuerza.setText(String.valueOf(v1 + v2 + v3));
        } else if (view == botonDestreza) {
            switch (v1) {
                case 1:
                    imgDestreza1.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgDestreza1.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgDestreza1.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgDestreza1.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgDestreza1.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgDestreza1.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v2) {
                case 1:
                    imgDestreza2.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgDestreza2.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgDestreza2.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgDestreza2.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgDestreza2.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgDestreza2.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v3) {
                case 1:
                    imgDestreza3.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgDestreza3.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgDestreza3.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgDestreza3.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgDestreza3.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgDestreza3.setImageResource(R.drawable.dado6);
                    break;
            }
            botonDestreza.setClickable(false);
            editTextDestreza.setText(String.valueOf(v1 + v2 + v3));
        } else if (view == botonConstitucion) {
            switch (v1) {
                case 1:
                    imgConstitucion1.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgConstitucion1.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgConstitucion1.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgConstitucion1.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgConstitucion1.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgConstitucion1.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v2) {
                case 1:
                    imgConstitucion2.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgConstitucion2.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgConstitucion2.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgConstitucion2.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgConstitucion2.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgConstitucion2.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v3) {
                case 1:
                    imgConstitucion3.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgConstitucion3.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgConstitucion3.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgConstitucion3.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgConstitucion3.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgConstitucion3.setImageResource(R.drawable.dado6);
                    break;
            }
            botonConstitucion.setClickable(false);
            editTextConstitucion.setText(String.valueOf(v1 + v2 + v3));
        } else if (view == botonInteligencia) {
            switch (v1) {
                case 1:
                    imgInteligencia1.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgInteligencia1.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgInteligencia1.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgInteligencia1.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgInteligencia1.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgInteligencia1.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v2) {
                case 1:
                    imgInteligencia2.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgInteligencia2.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgInteligencia2.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgInteligencia2.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgInteligencia2.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgInteligencia2.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v3) {
                case 1:
                    imgInteligencia3.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgInteligencia3.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgInteligencia3.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgInteligencia3.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgInteligencia3.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgInteligencia3.setImageResource(R.drawable.dado6);
                    break;
            }
            botonInteligencia.setClickable(false);
            editTextInteligencia.setText(String.valueOf(v1 + v2 + v3));
        } else if (view == botonSabiduria) {
            switch (v1) {
                case 1:
                    imgSabiduria1.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgSabiduria1.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgSabiduria1.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgSabiduria1.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgSabiduria1.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgSabiduria1.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v2) {
                case 1:
                    imgSabiduria2.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgSabiduria2.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgSabiduria2.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgSabiduria2.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgSabiduria2.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgSabiduria2.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v3) {
                case 1:
                    imgSabiduria3.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgSabiduria3.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgSabiduria3.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgSabiduria3.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgSabiduria3.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgSabiduria3.setImageResource(R.drawable.dado6);
                    break;
            }
            botonSabiduria.setClickable(false);
            editTextSabiduria.setText(String.valueOf(v1 + v2 + v3));
        } else if (view == botonCarisma) {
            switch (v1) {
                case 1:
                    imgCarisma1.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgCarisma1.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgCarisma1.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgCarisma1.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgCarisma1.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgCarisma1.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v2) {
                case 1:
                    imgCarisma2.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgCarisma2.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgCarisma2.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgCarisma2.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgCarisma2.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgCarisma2.setImageResource(R.drawable.dado6);
                    break;
            }
            switch (v3) {
                case 1:
                    imgCarisma3.setImageResource(R.drawable.dado1);
                    break;
                case 2:
                    imgCarisma3.setImageResource(R.drawable.dado2);
                    break;
                case 3:
                    imgCarisma3.setImageResource(R.drawable.dado3);
                    break;
                case 4:
                    imgCarisma3.setImageResource(R.drawable.dado4);
                    break;
                case 5:
                    imgCarisma3.setImageResource(R.drawable.dado5);
                    break;
                case 6:
                    imgCarisma3.setImageResource(R.drawable.dado6);
                    break;
            }
            botonCarisma.setClickable(false);
            editTextCarisma.setText(String.valueOf(v1 + v2 + v3));
        }
    }
}
