package com.example.healthinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BodyMassIndex extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result,clear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index);

        getSupportActionBar().setTitle("BMI Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        clear = (TextView) findViewById(R.id.clear);



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text1 = height.getText().toString();
                if (Text1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Already Empty", Toast.LENGTH_SHORT);
                } else {
                    height.setText("");
                }

                String Text2 = weight.getText().toString();
                if (Text2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Already Empty", Toast.LENGTH_SHORT);
                } else {
                    weight.setText("");
                }
                String Text3 = result.getText().toString();
                if (Text3.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Already Empty", Toast.LENGTH_SHORT);
                } else {
                    result.setText("");
                }
            }
        });


    }


    public void calculateBMI(View v) {

        result.onEditorAction(EditorInfo.IME_ACTION_DONE);

        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(TextUtils.isEmpty(heightStr)){
            height.setError("Please enter your weight");
            height.requestFocus();
        }

        if(TextUtils.isEmpty(weightStr)){
            weight.setError("Please enter your height");
            weight.requestFocus();
            return;
        }

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }



    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else if (Float.compare(bmi, 40f) > 0 && Float.compare(bmi, 45f) <= 0) {
            bmiLabel = getString(R.string.obese_class_iii);
        } else if (Float.compare(bmi, 45f) > 0 && Float.compare(bmi, 50f) <= 0) {
            bmiLabel = getString(R.string.obese_class_iv);
        } else if (Float.compare(bmi, 50f) > 0 && Float.compare(bmi, 60f) <= 0) {
            bmiLabel = getString(R.string.obese_class_v);
        } else {
            bmiLabel = getString(R.string.obese_class_vi);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.info:
                startActivity(new Intent(BodyMassIndex.this,InfoBmi.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



}