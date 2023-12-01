package com.mycode.generadorpersonajedd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText playerNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        playerNameEditText = findViewById(R.id.playerNameEditText);

        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empezar();
            }
        });
    }

    public void empezar() {
        String playerName = playerNameEditText.getText().toString();
        if (!playerName.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("playerName", playerName);
            mainActivityLauncher.launch(intent);
        } else {
            Toast.makeText(this, "Por favor, introduce un nombre de jugador", Toast.LENGTH_SHORT).show();
        }
    }

    ActivityResultLauncher <Intent> mainActivityLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                playerNameEditText.setText("");
            }
        }
    );
}
