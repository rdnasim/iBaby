package com.example.rdnas.ibaby.Pregnant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdnas.ibaby.R;

public class PregnantActivity extends AppCompatActivity {

    private Button pregnancyCalBtn;
    private Button pregnancyWeightCalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnant);
    }

    public void onCLickPregnancyCalcu(View view) {
        Intent intent = new Intent(this, PregnancyCalculatorActivity.class);
        pregnancyCalBtn = findViewById(R.id.pregnancyCalculatortBtn);
        startActivity(intent);
    }

    public void onClickPregnancyWeightCal(View view) {
        Intent intent = new Intent(this, PregnanacyWeightCalActivity.class);
        pregnancyWeightCalBtn = findViewById(R.id.pregnancyWeightCalBtn);
        startActivity(intent);
    }
}
