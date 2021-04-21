package com.umg.problema1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText nota;
    TextView resultado;
    double valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Emparentamos:
        nota = (EditText) findViewById(R.id.editNota);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    /**
     * Permite percibir el tap de cualquier botón que contenga este método
     * @param view
     */
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.btnCalcular:
                    calcularNota();
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    /**
     * Calcula la nota del usuario.
     */
    public void calcularNota() {
        try {
            // Validamos que haya ingreado una nota
            if (nota.getText().toString().length() == 0) throw new Exception("Por favor ingrese su nota.");

            // Validamos que esté dentro del rango de 0 a 20
            valor = Double.parseDouble(nota.getText().toString());
            if (valor < 0 || valor > 20) throw new Exception("Por favor ingrese una nota en un rango entre 0 a 20");

            String respuesta = estimarNota(valor);
            resultado.setText("Su nota es: " + respuesta);

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**
     * Le da una calificación a la nota ingresada
     * @param valor
     * @return
     */
    public String estimarNota(Double valor) {
        if(valor >= 0 && valor <= 10.5) return "Malo.";
        if(valor > 10.5 && valor <= 14) return "Regular.";
        if(valor > 14 && valor <= 18) return "Bueno.";
        if(valor > 18 && valor <= 20) return "Excelente.";
        return "Valor inválido.";
    }
}