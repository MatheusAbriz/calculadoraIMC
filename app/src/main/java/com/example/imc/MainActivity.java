package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nome, peso, altura;
    Button calcular, limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        peso = findViewById(R.id.editPeso);
        altura = findViewById(R.id.editAltura);

        calcular = findViewById(R.id.btnCalcular);
        limpar = findViewById(R.id.btnLimpar);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = nome.getText().toString();
                double p = Double.parseDouble(peso.getText().toString());
                double a = Double.parseDouble(altura.getText().toString());

                double imc = p / (a * a);

                Intent tela2 = new Intent(MainActivity.this, MainActivity2.class);

                tela2.putExtra("nome", n);
                tela2.putExtra("peso", p);
                tela2.putExtra("altura", a);
                tela2.putExtra("imc", imc);

                startActivity(tela2);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                peso.setText("");
                altura.setText("");
            }
        });
    }
}