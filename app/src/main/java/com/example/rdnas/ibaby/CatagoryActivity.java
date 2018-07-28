package com.example.rdnas.ibaby;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.rdnas.ibaby.Conceive.ConceiveActivity;
import com.example.rdnas.ibaby.DoctorHospital.DoctorHospitalActivity;
import com.example.rdnas.ibaby.Parent_Baby_Care.ParentBabyCareActivity;
import com.example.rdnas.ibaby.Pregnant.PregnantActivity;
import com.example.rdnas.ibaby.UrgentHelp.UrgentHelpActivity;

public class CatagoryActivity extends AppCompatActivity {
    private ImageButton conceiveBtn;
    private ImageButton pregnantBtn;
    private ImageButton parentBabyCareBtn;
    private ImageButton productAccBtn;
    private ImageButton midWifeService;
    private ImageButton docHospitalBtn;
    private ImageButton eMedicineBtn;
    private ImageButton urgentHelpBtn;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);


        mDrawerLayout = findViewById(R.id.drawerlayou);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickConceive(View view) {
        Intent intent = new Intent(this, ConceiveActivity.class);
        conceiveBtn = findViewById(R.id.conceiveBtn);
        startActivity(intent);
    }

    public void onClickPregnant(View view) {
        Intent intent = new Intent(this, PregnantActivity.class);
        pregnantBtn = findViewById(R.id.pregnantBtn);
        startActivity(intent);
    }

    public void onClickParentBabyCare(View view) {
        Intent intent = new Intent(this, ParentBabyCareActivity.class);
        parentBabyCareBtn = findViewById(R.id.iMParentBtn);
        startActivity(intent);
    }

    public void onClickProductAcces(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        productAccBtn = findViewById(R.id.babyProductAccBtn);
        startActivity(intent);
    }

    public void onClickMidWife(View view) {
        Intent intent = new Intent(this, MidWifeService.class);
        midWifeService = findViewById(R.id.midwifeServiceBtn);
        startActivity(intent);
    }

    public void onCLickDocHospital(View view) {
        Intent intent = new Intent(this, DoctorHospitalActivity.class);
        docHospitalBtn = findViewById(R.id.doctorHospitalBtn);
        startActivity(intent);
    }

    public void onClickeMedicine(View view) {
        Intent intent = new Intent(this, EMedicineActivity.class);
        eMedicineBtn = findViewById(R.id.eMedicineBtn);
        startActivity(intent);
    }

    public void onClickUrgentHelp(View view) {
        Intent intent = new Intent(this, UrgentHelpActivity.class);
        urgentHelpBtn = findViewById(R.id.urgentHelpBtn);
        startActivity(intent);
    }
}
