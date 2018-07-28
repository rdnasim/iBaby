package com.example.rdnas.ibaby.Conceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.rdnas.ibaby.ProductActivity;
import com.example.rdnas.ibaby.R;

public class ConceiveActivity extends AppCompatActivity {

    private Button familyPlan;
    private Button productAcces;
    private Button healthyFood;
    private Button mediDocHos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceive);
    }

    public void onClickMediDocHos(View view) {
        Intent intent = new Intent(this, MedicineDocHosActivity.class);
        mediDocHos = findViewById(R.id.medicineBtn);
        startActivity(intent);
    }

    public void onClickProductAcces(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        productAcces = findViewById(R.id.productBtn);
        startActivity(intent);
    }

    public void onClickHealthyFood(View view) {
        Intent intent = new Intent(this, HealthyFoodActivity.class);
        healthyFood = findViewById(R.id.healtyFoodBtn);
        startActivity(intent);
    }

    public void onClickFamilyPlan(View view) {
        Intent intent = new Intent(this, FamilyPlaningActivity.class);
        familyPlan = findViewById(R.id.familyPlanBtn);
        startActivity(intent);
    }

}
