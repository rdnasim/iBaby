package com.example.rdnas.ibaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.rdnas.ibaby.Conceive.ConceiveActivity;
import com.example.rdnas.ibaby.Parent_Baby_Care.ParentBabyCareActivity;
import com.example.rdnas.ibaby.Pregnant.PregnantActivity;

public class CatagoryActivity extends AppCompatActivity {
    private ImageButton conceiveBtn;
    private ImageButton pregnantBtn;
    private ImageButton parentBabyCareBtn;
    private ImageButton productAccBtn;
    private ImageButton midWifeService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);
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
}
