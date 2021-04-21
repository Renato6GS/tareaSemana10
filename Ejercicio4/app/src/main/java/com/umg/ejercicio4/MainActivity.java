package com.umg.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText baseRectangulo, baseTriangulo, alturaRectangulo, alturaTriangulo, radio;
    TextView resCirculo, resRectangulo, resTriangulo;
    double r, h, b;
    DecimalFormat formato = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Emparentamos
        baseRectangulo = (EditText) findViewById(R.id.editBaseRectangulo);
        alturaRectangulo = (EditText) findViewById(R.id.editAlturaRectangulo);
        baseTriangulo = (EditText) findViewById(R.id.editBaseTriangulo);
        alturaTriangulo = (EditText) findViewById(R.id.editAlturaTriangulo);
        radio = (EditText) findViewById(R.id.editRadio);

        resCirculo = (TextView) findViewById(R.id.resultadoCirculo);
        resRectangulo = (TextView) findViewById(R.id.resultadoRectangulo);
        resTriangulo = (TextView) findViewById(R.id.resultadoTriangulo);
    }

    /**
     * Percibe el click de cualquier botón que tenga su onclick
     * @param view
     */
    public void onClick(View view) {
        try {
            switch (view.getId()){

                case R.id.btnCirculo:
                    areaCirculo();
                    break;

                case R.id.btnRectangulo:
                    areaRectangulo();
                    break;

                case R.id.btnTriangulo:
                    areaTriangulo();
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    /**
     * Calcula el área de un circulo por su radio.
     */
    public void areaCirculo(){
        try {
            // validamos que haya ingresado un radio
            if (radio.getText().toString().length() == 0) throw new Exception("Por favor ingrese un radio");

            // Obtenemos dato y operamos
            r = Integer.parseInt(radio.getText().toString());
            resCirculo.setText("Resultado: " + formato.format(Math.PI * Math.pow(r,2)));

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**
     * Calcula el área de un rectángulo por su base y altura.
     */
    public void areaRectangulo(){
        try {
            // validamos que haya ingresado un radio
            if (baseRectangulo.getText().toString().length() == 0) throw new Exception("Por favor ingrese una base al rectángulo");
            if (alturaRectangulo.getText().toString().length() == 0) throw new Exception("Por favor ingrese una altura al rectángulo");

            // Obtenemos dato y operamos
            b = Integer.parseInt(baseRectangulo.getText().toString());
            h = Integer.parseInt(alturaRectangulo.getText().toString());

            resRectangulo.setText("Resultado: " + formato.format(b * h));

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**
     * Calcula el área de un triángulo por su base y altura
     */
    public void areaTriangulo(){
        try {
            // validamos que haya ingresado un radio
            if (baseTriangulo.getText().toString().length() == 0) throw new Exception("Por favor ingrese una base al triángulo");
            if (alturaTriangulo.getText().toString().length() == 0) throw new Exception("Por favor ingrese una altura al triángulo");

            // Obtenemos dato y operamos
            b = Double.parseDouble(baseTriangulo.getText().toString());
            h = Double.parseDouble(alturaTriangulo.getText().toString());
            double resultado = ((b*h)/2);

            resTriangulo.setText("Resultado: " + formato.format(resultado));

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}