package com.example.lab3_devm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText email;
    private EditText phone;
    private EditText adresse;
    private EditText ville;
    private Button btnEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        adresse = findViewById(R.id.adresse);
        ville = findViewById(R.id.ville);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        btnEnvoyer.setOnClickListener(v -> {
            String sNom = nom.getText().toString().trim();
            String sEmail = email.getText().toString().trim();
            String sPhone = phone.getText().toString().trim();
            String sAdresse = adresse.getText().toString().trim();
            String sVille = ville.getText().toString().trim();

            if (sNom.isEmpty() || sEmail.isEmpty()) {
                Toast.makeText(MainActivity.this, "Nom et Email sont obligatoires.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
            intent.putExtra("nom", sNom);
            intent.putExtra("email", sEmail);
            intent.putExtra("phone", sPhone);
            intent.putExtra("adresse", sAdresse);
            intent.putExtra("ville", sVille);

            startActivity(intent);
        });
    }
}