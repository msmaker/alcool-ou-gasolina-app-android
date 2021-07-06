package com.msmaker.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {
        //recuperar valores digitados
        String precoAlccol = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlccol, precoGasolina);

        if (camposValidados) {
            //convertendo string para numeros
            Double valorAlcool = Double.parseDouble(precoAlccol);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            /* Fazer cálculo de menor preço
             * Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
             *  senão é melhor utilizar álcool
             */

            if ((valorAlcool / valorGasolina) >= 0.7) {
                textResultado.setText("Abasteça com gasolina");
            } else {
                textResultado.setText("Abasteça com alcool");
            }

        } else {
            textResultado.setText("Preencha os campos primeiro");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}
