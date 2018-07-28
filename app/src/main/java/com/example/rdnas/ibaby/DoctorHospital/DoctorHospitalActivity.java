package com.example.rdnas.ibaby.DoctorHospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdnas.ibaby.R;

public class DoctorHospitalActivity extends AppCompatActivity {

    Button eDoctorBtn, eHospitalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_hospital);
    }

    public void onClickeDoctor(View view) {
        Intent intent = new Intent(this, EDoctorActivity.class);
        eDoctorBtn = findViewById(R.id.eDoctorBtn);
        startActivity(intent);
    }

    public void onClickeHospital(View view) {
        Intent intent = new Intent(this, EHospitalActivity.class);
        eHospitalBtn = findViewById(R.id.eHospitalBtn);
        startActivity(intent);
    }
}
