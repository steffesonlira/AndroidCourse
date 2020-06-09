package com.example.butterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;

    @BindView(R.id.textView2)
    TextView textView2;

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //caso estiver utilizando o ButterKnife em uma Fragment
         //passe o objeto View como argumento do Butterknife.bind(view)
        // passe
        setContentView(R.layout.activity_main);

        textView1.setText("Este é um texto 1");
        textView2.setText("Este é um texto 2");
        editText.setText("Este é um edit text");
        button.setText("clique em mim");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
