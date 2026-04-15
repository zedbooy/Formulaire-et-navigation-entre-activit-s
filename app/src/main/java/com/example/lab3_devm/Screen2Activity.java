package com.example.lab3_devm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);

        Intent intent = getIntent();

        String nom = intent.getStringExtra("nom");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville = intent.getStringExtra("ville");

        String resume = "Nom : " + safe(nom)
                + "\nEmail : " + safe(email)
                + "\nPhone : " + safe(phone)
                + "\nAdresse : " + safe(adresse)
                + "\nVille : " + safe(ville);

        recap.setText(resume);

        btnRetour.setOnClickListener(v -> finish());
    }

    private String safe(String value) {
        return (value == null || value.trim().isEmpty()) ? "—" : value.trim();
    }
}