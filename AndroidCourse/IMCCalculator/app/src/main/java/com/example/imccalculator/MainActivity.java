package com.example.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private MaskEditText editTextAltura;
    private MaskEditText editTextPeso;
    TextView textView_resultado;
    TextView textView_imc_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura = findViewById(R.id.editText_altura);
        editTextPeso = findViewById(R.id.editText_peso);
        textView_resultado = findViewById(R.id.textView_result);
        textView_imc_index = findViewById(R.id.textView_imc_index);
    }

    public void calcular(View view) {

        float alturaPessoa = 0;
        float pesoPessoa = 0;
        float result;

        String editTextAlturaContent;
        String editTextPesoContent;

        editTextAlturaContent = editTextAltura.getText().toString();
        editTextPesoContent = editTextPeso.getText().toString();

        if (editTextAlturaContent.isEmpty()) {
            Toast.makeText(this, "Altura vazia", Toast.LENGTH_LONG).show();
        } else if (editTextPesoContent.isEmpty()) {
            Toast.makeText(this, "Peso vazio", Toast.LENGTH_LONG).show();
        } else {
            alturaPessoa = Float.parseFloat(editTextAlturaContent);
            pesoPessoa = Float.parseFloat(editTextPesoContent);

            result = (float) (pesoPessoa / Math.pow(alturaPessoa, 2.f));
            DecimalFormat df = new DecimalFormat(".00");

            if (result < 25) {
                textView_imc_index.setTextColor(Color.BLUE);
                textView_imc_index.setText("Normal");
            } else if (result < 30) {
                textView_imc_index.setText("Acima");
                textView_imc_index.setTextColor(Color.MAGENTA);
            } else {
                textView_imc_index.setText("Cuidado");
                textView_imc_index.setTextColor(Color.RED);
            }
            textView_resultado.setText((df.format(result)));

            hideKeyBoard(view);
        }
        editTextAltura.setText("");
        editTextPeso.setText("");
    }

    private void hideKeyBoard(View view) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }


}



