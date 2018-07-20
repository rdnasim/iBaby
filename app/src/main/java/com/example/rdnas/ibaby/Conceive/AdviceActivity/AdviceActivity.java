package com.example.rdnas.ibaby.Conceive.AdviceActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.rdnas.ibaby.R;

public class AdviceActivity extends AppCompatActivity {

    private Button contraceButton;
    private Button sexTransButton;
    private Button pregnancyButton;
    private Button abortionButton;
    private Button keepingSafeButton;
    private Button priodsButton;
    private Button sexEduButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClickContrace(View view) {
        Intent intent = new Intent(this, ContraceActivity.class);
        contraceButton = findViewById(R.id.contraceButton);
        startActivity(intent);
    }

    public void onClickSexTrans(View view) {
        Intent intent = new Intent(this, SexTransActivity.class);
        sexTransButton = findViewById(R.id.sexTransButton);
        startActivity(intent);
    }

    public void onClickPregnancy(View view) {
        Intent intent = new Intent(this, PregnancyActivity.class);
        pregnancyButton = findViewById(R.id.pregnancyBtn);
        startActivity(intent);
    }

    public void onClickAbortion(View view) {
        Intent intent = new Intent(this, AbortionActivity.class);
        abortionButton = findViewById(R.id.abortionBtn);
        startActivity(intent);
    }

    public void onClickKeepingSafe(View view) {
        Intent intent = new Intent(this, KeepingSafeActivity.class);
        keepingSafeButton = findViewById(R.id.keepingSafeBtn);
        startActivity(intent);

    }

    public void onClickPriods(View view) {
        Intent intent = new Intent(this, PeriodsActivity.class);
        priodsButton = findViewById(R.id.priodsBtn);
        startActivity(intent);
    }

    public void onClickSexEdu(View view) {
        Intent intent = new Intent(this, SexualityEduActivity.class);
        sexEduButton = findViewById(R.id.sexEduBtn);
        startActivity(intent);
    }
}
