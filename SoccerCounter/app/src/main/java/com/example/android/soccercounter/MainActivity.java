package com.example.android.soccercounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.soccercounter.R;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;
    int yellowTeamA = 0;
    int yellowTeamB = 0;
    int redTeamA = 0;
    int redTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamA(foulsTeamA);
        displayFoulForTeamB(foulsTeamB);
        displayYellowForTeamA(yellowTeamA);
        displayYellowForTeamB(yellowTeamB);
        displayRedForTeamA(redTeamA);
        displayRedForTeamB(redTeamB);
    }

    public void resetScore(View view) {
        int scoreTeamA = 0;
        int scoreTeamB = 0;
        int foulsTeamA = 0;
        int foulsTeamB = 0;
        int yellowTeamA = 0;
        int yellowTeamB = 0;
        int redTeamA = 0;
        int redTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamA(foulsTeamA);
        displayFoulForTeamB(foulsTeamB);
        displayYellowForTeamA(yellowTeamA);
        displayYellowForTeamB(yellowTeamB);
        displayRedForTeamA(redTeamA);
        displayRedForTeamB(redTeamB);
    }

    //region TeamA
    public void addGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addFoulForTeamA(View v) {
        foulsTeamA = foulsTeamA + 1;
        displayFoulForTeamA(foulsTeamA);
    }

    public void addYellowForTeamA(View v) {
        yellowTeamA = yellowTeamA + 1;
        displayYellowForTeamA(yellowTeamA);
    }

    public void addRedForTeamA(View v) {
        redTeamA = redTeamA + 1;
        displayRedForTeamA(redTeamA);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulForTeamA(int foul) {
        TextView foulView = findViewById(R.id.team_a_foul);
        foulView.setText(String.valueOf(foul));
    }

    public void displayYellowForTeamA(int yellow) {
        TextView yellowView = findViewById(R.id.team_a_yellow);
        yellowView.setText(String.valueOf(yellow));
    }

    public void displayRedForTeamA(int red) {
        TextView redView = findViewById(R.id.team_a_red);
        redView.setText(String.valueOf(red));
    }

    //endregion
    //region TeamB
    public void addGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void addFoulForTeamB(View v) {
        foulsTeamB = foulsTeamB + 1;
        displayFoulForTeamB(foulsTeamB);
    }

    public void addYellowForTeamB(View v) {
        yellowTeamB = yellowTeamB + 1;
        displayYellowForTeamB(yellowTeamB);
    }

    public void addRedForTeamB(View v) {
        redTeamB = redTeamB + 1;
        displayRedForTeamB(redTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulForTeamB(int foul) {
        TextView foulView = findViewById(R.id.team_b_foul);
        foulView.setText(String.valueOf(foul));
    }

    public void displayYellowForTeamB(int yellow) {
        TextView yellowView = findViewById(R.id.team_b_yellow);
        yellowView.setText(String.valueOf(yellow));
    }

    public void displayRedForTeamB(int red) {
        TextView redView = findViewById(R.id.team_b_red);
        redView.setText(String.valueOf(red));
    }
    //endregion
}
