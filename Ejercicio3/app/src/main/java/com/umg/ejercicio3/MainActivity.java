package com.umg.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText campoA, campoB, campoC;
    TextView x1, x2;
    int a, b, c;
    DecimalFormat formato = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Emparentamos:
        campoA = (EditText) findViewById(R.id.campoA);
        campoB = (EditText) findViewById(R.id.campoB);
        campoC = (EditText) findViewById(R.id.campoC);
        x1 = (TextView) findViewById(R.id.x1);
        x2 = (TextView) findViewById(R.id.x2);
    }

    /**
     * Método para percibir el tap dentro de un botón
     *
     * @param view
     */
    public void onClick(View view) {
        try {
            // Validamos que hayan ingresado datos dentro de los inputs:
            if (campoA.getText().toString().length() == 0 || campoB.getText().toString().length() == 0 || campoC.getText().toString().length() == 0)
                throw new Exception("Por favor llene los campos antes de operar.");

            // Obtenemos datos
            a = Integer.parseInt(campoA.getText().toString());
            b = Integer.parseInt(campoB.getText().toString());
            c = Integer.parseInt(campoC.getText().toString());

            // Validamos quien es el botón
            switch (view.getId()) {
                case R.id.btnCalcular:
                    calcularRaices();
                    break;
            }

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**
     * Realiza una ecuación de segundo grado
     */
    public void calcularRaices() {
        try {
            // Realizamos las operaciones
            String res1, res2;
            res1 = formato.format((-(b) + Math.sqrt((Math.pow(b, 2) - (4*a*c)))) / (2*a));
            res2 = formato.format((-(b) - Math.sqrt((Math.pow(b, 2) - (4*a*c)))) / (2*a));

            // Validamos que las raíces se hayan podido llevar a cabo
            if (res1.indexOf("NaN") != -1 || res2.indexOf("NaN") != -1) throw new Exception("No es posible encontrar la raíz");

            // Seteamos las raíces:
            x1.setText("X1: " + res1);
            x2.setText("X2: " + res2);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}