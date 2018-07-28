package com.example.rdnas.ibaby.UrgentHelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdnas.ibaby.R;

public class UrgentHelpActivity extends AppCompatActivity {

    Button ambulanceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_help);
    }

    public void onClickeAmbulance(View view) {
        Intent intent = new Intent(this, AmbulanceActivity.class);
        ambulanceBtn = findViewById(R.id.ambulanceBtn);
        startActivity(intent);

    }
}
