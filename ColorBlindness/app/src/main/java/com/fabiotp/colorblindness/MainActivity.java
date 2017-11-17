package com.fabiotp.colorblindness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reset(View view) {

        /**
         * Reset all the views
         */
        RadioButton q1Answer1 = findViewById(R.id.q1_answer1_radio);
        q1Answer1.setChecked(false);

        RadioButton q1Answer2 = findViewById(R.id.q1_answer2_radio);
        q1Answer2.setChecked(false);

        RadioButton q1Answer3 = findViewById(R.id.q1_answer3_radio);
        q1Answer3.setChecked(false);

        EditText q2AnswerInput = findViewById(R.id.q2_answer_input);
        q2AnswerInput.setText(null);

        CheckBox q3Answer1Check = findViewById(R.id.q3_answer1_check);
        q3Answer1Check.setChecked(false);

        CheckBox q3Answer2Check = findViewById(R.id.q3_answer2_check);
        q3Answer2Check.setChecked(false);

        CheckBox q3Answer3Check = findViewById(R.id.q3_answer3_check);
        q3Answer3Check.setChecked(false);

        CheckBox q3Answer4Check = findViewById(R.id.q3_answer4_check);
        q3Answer4Check.setChecked(false);

        CheckBox q4Answer1Check = findViewById(R.id.q4_answer1_check);
        q4Answer1Check.setChecked(false);

        CheckBox q4Answer2Check = findViewById(R.id.q4_answer2_check);
        q4Answer2Check.setChecked(false);

        CheckBox q4Answer3Check = findViewById(R.id.q4_answer3_check);
        q4Answer3Check.setChecked(false);

        CheckBox q4Answer4Check = findViewById(R.id.q4_answer4_check);
        q4Answer4Check.setChecked(false);

        EditText q5AnswerInput = findViewById(R.id.q5_answer_input);
        q5AnswerInput.setText(null);

        RadioButton q6Answer1 = findViewById(R.id.q6_answer1_radio);
        q6Answer1.setChecked(false);

        RadioButton q6Answer2 = findViewById(R.id.q6_answer2_radio);
        q6Answer2.setChecked(false);

        RadioButton q6Answer3 = findViewById(R.id.q6_answer3_radio);
        q6Answer3.setChecked(false);

        RadioButton q7Answer1 = findViewById(R.id.q7_answer1_radio);
        q7Answer1.setChecked(false);

        RadioButton q7Answer2 = findViewById(R.id.q7_answer2_radio);
        q7Answer2.setChecked(false);

        RadioButton q7Answer3 = findViewById(R.id.q7_answer3_radio);
        q7Answer3.setChecked(false);

        EditText q8AnswerInput = findViewById(R.id.q8_answer_input);
        q8AnswerInput.setText(null);

        EditText q9AnswerInput = findViewById(R.id.q9_answer_input);
        q9AnswerInput.setText(null);

        EditText q10AnswerInput = findViewById(R.id.q10_answer_input);
        q10AnswerInput.setText(null);

        Toast.makeText(MainActivity.this, getString(R.string.color_blind_reset),
                Toast.LENGTH_SHORT).show();
    }

    public void checkScore(View view) {

        /**
         * Find all the views
         */


        RadioButton q1Answer3 = findViewById(R.id.q1_answer3_radio);
        boolean isQ1A3Checked = q1Answer3.isChecked();

        EditText q2AnswerInput = findViewById(R.id.q2_answer_input);
        String getQ2Input = q2AnswerInput.getText().toString();

        CheckBox q3Answer2Check = findViewById(R.id.q3_answer2_check);
        boolean isQ3A2Checked = q3Answer2Check.isChecked();

        CheckBox q3Answer3Check = findViewById(R.id.q3_answer3_check);
        boolean isQ3A3Checked = q3Answer3Check.isChecked();

        /**
         * Find wrong checkboxes
         */
        CheckBox q3Answer1Check = findViewById(R.id.q3_answer1_check);
        boolean isQ3A1Checked = q3Answer1Check.isChecked();

        CheckBox q3Answer4Check = findViewById(R.id.q3_answer4_check);
        boolean isQ3A4Checked = q3Answer4Check.isChecked();
        /** */

        CheckBox q4Answer1Check = findViewById(R.id.q4_answer1_check);
        boolean isQ4A1Checked = q4Answer1Check.isChecked();

        CheckBox q4Answer4Check = findViewById(R.id.q4_answer4_check);
        boolean isQ4A4Checked = q4Answer4Check.isChecked();

        /**
         * Find wrong checkboxes
         */
        CheckBox q4Answer2Check = findViewById(R.id.q4_answer2_check);
        boolean isQ4A2Checked = q4Answer2Check.isChecked();

        CheckBox q4Answer3Check = findViewById(R.id.q4_answer3_check);
        boolean isQ4A3Checked = q4Answer3Check.isChecked();
        /** */

        EditText q5AnswerInput = findViewById(R.id.q5_answer_input);
        String getQ5Input = q5AnswerInput.getText().toString();

        RadioButton q6Answer2 = findViewById(R.id.q6_answer2_radio);
        boolean isQ6A2Checked = q6Answer2.isChecked();

        RadioButton q7Answer3 = findViewById(R.id.q7_answer3_radio);
        boolean isQ7A3Checked = q7Answer3.isChecked();

        EditText q8AnswerInput = findViewById(R.id.q8_answer_input);
        String getQ8Input = q8AnswerInput.getText().toString();

        EditText q9AnswerInput = findViewById(R.id.q9_answer_input);
        String getQ9Input = q9AnswerInput.getText().toString();

        EditText q10AnswerInput = findViewById(R.id.q10_answer_input);
        String getQ10Input = q10AnswerInput.getText().toString();

        /**
         * Show toast with total score and message related to score
         */
        if (calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                isQ5valid(getQ5Input), isQ6A2Checked,
                isQ7A3Checked, isQ8valid(getQ8Input),
                isQ9valid(getQ9Input), isQ10valid(getQ10Input)) < 5) {

            Toast.makeText(MainActivity.this, getString(R.string.your_score) +
                            calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                                    isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                                    isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                                    isQ5valid(getQ5Input), isQ6A2Checked,
                                    isQ7A3Checked, isQ8valid(getQ8Input),
                                    isQ9valid(getQ9Input), isQ10valid(getQ10Input))
                            + getString(R.string.bad_score),
                    Toast.LENGTH_LONG).show();
        }
        if (calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                isQ5valid(getQ5Input), isQ6A2Checked,
                isQ7A3Checked, isQ8valid(getQ8Input),
                isQ9valid(getQ9Input), isQ10valid(getQ10Input)) >= 5 &&
                calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                isQ5valid(getQ5Input), isQ6A2Checked,
                isQ7A3Checked, isQ8valid(getQ8Input),
                isQ9valid(getQ9Input), isQ10valid(getQ10Input)) <=9) {

            Toast.makeText(MainActivity.this, getString(R.string.your_score) +
                            calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                                    isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                                    isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                                    isQ5valid(getQ5Input), isQ6A2Checked,
                                    isQ7A3Checked, isQ8valid(getQ8Input),
                                    isQ9valid(getQ9Input), isQ10valid(getQ10Input))
                            + getString(R.string.good_score),
                    Toast.LENGTH_LONG).show();
        }
        if (calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                isQ5valid(getQ5Input), isQ6A2Checked,
                isQ7A3Checked, isQ8valid(getQ8Input),
                isQ9valid(getQ9Input), isQ10valid(getQ10Input)) == 10) {

            Toast.makeText(MainActivity.this, getString(R.string.your_score) +
                            calculateScore(isQ1A3Checked, isQ2valid(getQ2Input),
                                    isQ3Right(isQ3A2Checked, isQ3A3Checked, isQ3A1Checked, isQ3A4Checked),
                                    isQ4Right(isQ4A1Checked, isQ4A4Checked, isQ4A2Checked, isQ4A3Checked),
                                    isQ5valid(getQ5Input), isQ6A2Checked,
                                    isQ7A3Checked, isQ8valid(getQ8Input),
                                    isQ9valid(getQ9Input), isQ10valid(getQ10Input))
                            + getString(R.string.perfect_score),
                    Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Editext input validation
     */
    private boolean isQ2valid(String q2answer) {
        if (q2answer.contentEquals("6")) {
            return true;
        }
        return false;
    }

    private boolean isQ5valid(String q5answer) {
        if (q5answer.contentEquals("12")) {
            return true;
        }
        return false;
    }

    private boolean isQ8valid(String q8answer) {
        if (q8answer.contentEquals("2")) {
            return true;
        }
        return false;
    }

    private boolean isQ9valid(String q9answer) {
        if (q9answer.contentEquals("42")) {
            return true;
        }
        return false;
    }
    private boolean isQ10valid(String q10answer) {
        if (q10answer.contentEquals("3")) {
            return true;
        }
        return false;
    }
    /**
     * Check if 2 checkboxes are right
     * If one is wrong, it's still a wrong answer
     */
    private boolean isQ3Right(boolean isQ3A2Checked, boolean isQ3A3Checked, boolean isQ3A1Checked, boolean isQ3A4Checked) {
        return isQ3A2Checked && isQ3A3Checked && !isQ3A1Checked && !isQ3A4Checked;
    }

    private boolean isQ4Right(boolean isQ4A1Checked, boolean isQ4A4Checked, boolean isQ4A2Checked, boolean isQ4A3Checked) {
        return isQ4A1Checked && isQ4A4Checked && !isQ4A2Checked && !isQ4A3Checked;
    }

    /**
     * Calculate Total score
     */
    private int calculateScore(boolean isQuestion1Right, boolean isQuestion2Right,
                               boolean isQuestion3Right, boolean isQuestion4Right,
                               boolean isQuestion5Right, boolean isQuestion6Right,
                               boolean isQuestion7Right, boolean isQuestion8Right,
                               boolean isQuestion9Right, boolean isQuestion10Right) {
        int score = 0;

        if (isQuestion1Right) {
            score = score + 1;
        }
        if (isQuestion2Right) {
            score = score + 1;
        }
        if (isQuestion3Right) {
            score = score + 1;
        }
        if (isQuestion4Right) {
            score = score + 1;
        }
        if (isQuestion5Right) {
            score = score + 1;
        }
        if (isQuestion6Right) {
            score = score + 1;
        }
        if (isQuestion7Right) {
            score = score + 1;
        }
        if (isQuestion8Right) {
            score = score + 1;
        }
        if (isQuestion9Right) {
            score = score + 1;
        }
        if (isQuestion10Right) {
            score = score + 1;
        }
        return score;
    }
}
