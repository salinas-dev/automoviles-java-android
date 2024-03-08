package com.salinas.compraautomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.salinas.compraautomovil.model.automovilModel;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Spinner cmbMarca;
    Spinner cmbOrigen;
    TextInputEditText txtCosto;
    Button btnCalcular;
    Button btnNuevo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        String opcionMarca[] = {"--SELECCIONE MARCA--", "TESLA", "BMW", "MERCEDES BENZ", "FERRARI", "ASTON MARTI", "AUDI", "ALFA ROMEO", "BUGATTI", "JAGUAR", "LAMBORGHINI", "MASERATI", "PORSCHE", "ROLLS-ROYCE"};
        String opcionOrigen[] = {"--SELECCIONE ORIGEN--", "ALEMANIA", "JAPON", "ITALIA", "EUA"};
        cmbMarca = findViewById(R.id.spMarca);
        cmbOrigen = findViewById(R.id.spOrigen);
        txtCosto = findViewById(R.id.txCosto);
        btnCalcular = findViewById(R.id.buttonCalcular);
        btnNuevo = findViewById(R.id.buttonNuevo);
        btnSalir = findViewById(R.id.buttonSalir);

        ArrayAdapter<String> adapMarca = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, opcionMarca);
        ArrayAdapter<String> adapOrigen = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, opcionOrigen);

        cmbMarca.setAdapter(adapMarca);
        cmbOrigen.setAdapter(adapOrigen);

        //Listener para calcular el costo del automovil
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{

                    int noMarca;
                    int noOrigen;
                    int costo;

                    noMarca = cmbMarca.getSelectedItemPosition();
                    noOrigen = cmbOrigen.getSelectedItemPosition();
                    costo = Integer.parseInt(txtCosto.getText().toString());


                    if (noMarca == 0) {
                        Toast.makeText(getApplicationContext(),
                                "-----SELECCIONA UNA MARCA----",
                                Toast.LENGTH_LONG).show();
                    } else if (noOrigen == 0) {
                        Toast.makeText(getApplicationContext(),
                                "-Seleccione un Origen-",
                                Toast.LENGTH_LONG).show();
                    } else if (txtCosto.length() == 0) {
                        txtCosto.setError("Debe ingresar la cantidad");
                        txtCosto.requestFocus();
                    } else {
                        costo = Integer.parseInt(txtCosto.getText().toString());
                    }

                    automovilModel costoAuto = new automovilModel();

                    costoAuto.setMarca(noMarca);
                    costoAuto.setOrigen(noOrigen);
                    costoAuto.setCosto(costo);

                    Toast.makeText(getApplicationContext(), costoAuto.calcularCostoAutomovil(), Toast.LENGTH_LONG).show();


                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"No puede dejar espacios es blanco",Toast.LENGTH_LONG).show();
                }

                //Listener para salir de la app
                btnSalir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });


                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cmbMarca.setAdapter(null);
                        cmbOrigen.setAdapter(null);
                        txtCosto.setText("");
                    }
                });

                cmbMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String marca=cmbMarca.getSelectedItem().toString();
                        Toast.makeText(getApplicationContext(), "Seleccionaste"+marca,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


            }
        });
    }
}