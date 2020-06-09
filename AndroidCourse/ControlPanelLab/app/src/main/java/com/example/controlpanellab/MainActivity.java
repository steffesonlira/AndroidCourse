package com.example.controlpanellab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainLayout;

    Button button;
    EditText editText;
    private ColorStateList editTextColorStateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.main_layout);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty()) {

                    editText.clearFocus();
                    editText.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                }

            }
        });

        editText = findViewById(R.id.editText);
        editTextColorStateList = editText.getBackgroundTintList();
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(MainActivity.class.getSimpleName(), String.valueOf(hasFocus));
                if (hasFocus)
                    v.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                     else
                        v.setBackgroundTintList(editTextColorStateList);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_help:
                // Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.menu_refresh:
                //Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
