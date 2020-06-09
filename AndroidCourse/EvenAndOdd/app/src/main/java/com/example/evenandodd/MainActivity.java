package com.example.evenandodd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numberPicked, playerScore, computerScore;
    boolean isNumberChoosed;
    boolean isOddOrEvenChoosed, isOdd;

    TextView textViewScorePlayer;
    TextView textViewScoreComputer;
    TextView textComputerChooseNumber;
    TextView textHunch;
    TextView textNumberGuess;
    TextView textChooseWinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScorePlayer = findViewById(R.id.textView_score_player);
        textViewScoreComputer = findViewById(R.id.textView_score_computer);
        textComputerChooseNumber = findViewById(R.id.textView_choose_computer);
        textHunch = findViewById(R.id.textView_hunch);
        textNumberGuess = findViewById(R.id.textView_number_guess);
        textChooseWinner = findViewById(R.id.textView_winner);

        restart();

    }

    private void restart() {
        isOddOrEvenChoosed = false;
        isNumberChoosed = false;
        playerScore = 0;
        computerScore = 0;
        textViewScoreComputer.setText(String.valueOf(playerScore));
        textViewScorePlayer.setText(String.valueOf(computerScore));
        textHunch.setText("");
        textComputerChooseNumber.setText("");
        textChooseWinner.setText("");
        textNumberGuess.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickNumberPick(View view) {
        switch (view.getId()) {
            case R.id.button_number_1:
                numberPicked = 1;
                break;
            case R.id.button_number_2:
                numberPicked = 2;
                break;
            case R.id.button_number_3:
                numberPicked = 3;
                break;
            case R.id.button_number_4:
                numberPicked = 4;
                break;
            case R.id.button_number_5:
                numberPicked = 5;
                break;

        }
        textNumberGuess.setText(numberPicked + "");
        isNumberChoosed = true;
        validateGame();
    }

    private void validateGame() {
        boolean winner = false;
        if (isNumberChoosed && isOddOrEvenChoosed) {
            if ((numberPicked + generateComputerNumber()) % 2 == 1) {
                if (isOdd) {
                    winner = true;
                    playerScore++;

                } else {
                    winner = false;
                    computerScore++;
                }
            }else{
                if(isOdd){
                    winner = false;
                    computerScore++;
                }else{
                    winner = true;
                    playerScore++;
                }
            }
        }else{
            Toast.makeText(this, "Por favor, escolha par ou ímpar e um número", Toast.LENGTH_SHORT).show();
            return;
        }
        textChooseWinner.setText(winner ? R.string.winner_label : R.string.looser_label);
        textChooseWinner.setTextColor(winner ? Color.BLUE : Color.RED);
        textViewScorePlayer.setText(String.valueOf(playerScore));
        textViewScoreComputer.setText(String.valueOf(computerScore));
        isOddOrEvenChoosed = false;
        isNumberChoosed = false;
    }

    private int generateComputerNumber() {
        int number = new Random().nextInt(5) + 1;
        textViewScoreComputer.setText(String.valueOf(number));
        return number;
    }

    public void onCLickOddOrEven(View view) {
        if(view.getId() == R.id.button_odd){
            isOdd = true;
        }else{
            isOdd = false;
        }
        textHunch.setText(isOdd ? "Ímpar" : "Par");
        isOddOrEvenChoosed = true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_refresh){
            restart();
        }
        return super.onOptionsItemSelected(item);
    }
}
