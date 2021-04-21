package com.umg.miprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText campo1, campo2;
    TextView resultado;
    int num1, num2;
    DecimalFormat formato = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Emparentamos:
        campo1 = (EditText) findViewById(R.id.editVal1);
        campo2 = (EditText) findViewById(R.id.editVal2);
        resultado = (TextView) findViewById(R.id.textResultado);
    }

    // Al tener todos el mismo nombre, ahorramos hacer 4 botones y hacemos un switch jeje
    public void onClick(View view) {
        try {
            // Validamos que ambos campos tengan datos:
            if (campo1.getText().toString().length() == 0 || campo2.getText().toString().length() == 0)
                throw new Exception("Por favor llene ambos campos antes de operar.");

            // Obtenemos datos
            num1 = Integer.parseInt(campo1.getText().toString());
            num2 = Integer.parseInt(campo2.getText().toString());

            // Averiguamos quien presionó el botón por su id
            switch (view.getId()) {
                case R.id.btnSuma:
                    sumar();
                    break;
                case R.id.btnResta:
                    restar();
                    break;
                case R.id.btnMulti:
                    multi();
                    break;
                case R.id.btnDivision:
                    dividir();
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void sumar() {
        try {
            int suma = num1 + num2;
            resultado.setText("Resultado: " + suma);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void restar() {
        try {
            int resta = num1 - num2;
            resultado.setText("Resultado: " + resta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void multi() {
        try {
            int prod = num1 * num2;
            resultado.setText("Resultado: " + prod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dividir() {
        try {
            if (num2 == 0) throw new ArithmeticException("No puede dividir por 0");

            double div = num1 / num2;
            resultado.setText("Resultado: " + formato.format(div));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}