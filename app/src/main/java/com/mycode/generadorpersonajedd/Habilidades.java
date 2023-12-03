package com.mycode.generadorpersonajedd;


import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Habilidades extends AppCompatActivity {
    private ArrayList<CheckBox> checkBoxes;
    private ArrayList<String> skills;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habilidades);
        checkBoxes = new ArrayList<>();
        skills = new ArrayList<>();

        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxAtletimo));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxAcrobacias));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxJuego));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxSigilo));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxAracano));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxHistoria));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxInvs));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxNaturaleza));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxReligion));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxMedicina));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxPercepcion));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxPerspicacia));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxSuper));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxTrato));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxEngaño));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxIntimidacion));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxInterpretacion));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBoxPersuasion));

        for (CheckBox checkBox : checkBoxes) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        skills.add(compoundButton.getText().toString());
                    }
                    else {
                        skills.remove(compoundButton.getText().toString());
                    }
                    if (skills.size() == 3) {
                        String skillsSelecionadas= "";
                        for (String skill : skills) {
                            skillsSelecionadas += "\"" + skill + "\", ";
                        }
                        skillsSelecionadas = skillsSelecionadas.substring(0, skillsSelecionadas.length() - 2);
                        skillsSelecionadas += " y " + skills.get(skills.size() - 1);
                        Intent intent = new Intent();
                        intent.putExtra("Skills-selecionadas", skillsSelecionadas);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            });
        }
    }

}
