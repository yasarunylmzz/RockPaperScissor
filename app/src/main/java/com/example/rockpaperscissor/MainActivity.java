package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView scoreTextView,
            wonLostTextView,
            userSelectionTextView,
            compSelectionTextView;

    int userScore = 0;
    int compScore = 0;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        wonLostTextView = findViewById(R.id.wonLostTextView);
        compSelectionTextView = findViewById(R.id.compSelectionTextView);
        userSelectionTextView = findViewById(R.id.userSelectionTextView);

        wonLostTextView.setText("");
        compSelectionTextView.setText("");
        userSelectionTextView.setText("");
    }

    public void rpsButtonSelected(View view) {
        Log.i(TAG, "rpsButtonSelected: " + view.getTag());
        int userSelection = Integer.parseInt(view.getTag().toString());
        match(userSelection);
    }



    private void match(int userSelection) {

        int low = 1;
        int high = 3;



        int compSelection = random.nextInt(high) + low;



        if (userSelection == compSelection) {
            wonLostTextView.setText("BERABERE");
        } else if ( (userSelection - compSelection) % 3 == 1 ) {
            wonLostTextView.setText("KAZANDIN");
            userScore++;
        } else {
            wonLostTextView.setText("KAYBETTİN");
            compScore++;
        }
        setScoreTextView(userScore, compScore);

        switch (compSelection) {
            case 1:
                compSelectionTextView.setText("TAŞ");
                break;
            case 2:
                compSelectionTextView.setText("KAĞIT");
                break;
            case 3:
                compSelectionTextView.setText("MAKAS");
                break;
            default:
                compSelectionTextView.setText("");
        }

        switch (userSelection) {
            case 1:
                userSelectionTextView.setText("TAŞ");
                break;
            case 2:
                userSelectionTextView.setText("KAĞIT");
                break;
            case 3:
                userSelectionTextView.setText("MAKAS");
                break;
            default:
                userSelectionTextView.setText("");
        }
        setScoreTextView(userScore, compScore);
    }

    public void resetGame(View view) {
        userScore = 0;
        compScore = 0;
        wonLostTextView.setText("");
        compSelectionTextView.setText("");
        setScoreTextView(userScore, compScore);
        userSelectionTextView.setText("");
        compSelectionTextView.setText("");

    }

    private void setScoreTextView(int userScore, int compScore) {
        String scoreString = String.valueOf(userScore) + " : " + String.valueOf(compScore);
        scoreTextView.setText(scoreString);
    }

}