package com.example.rdnas.ibaby.Conceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rdnas.ibaby.Conceive.AdviceActivity.AdviceActivity;
import com.example.rdnas.ibaby.Conceive.AdviceActivity.CoursesActivity;
import com.example.rdnas.ibaby.Conceive.AdviceActivity.ResourcesActivity;
import com.example.rdnas.ibaby.ProductActivity;
import com.example.rdnas.ibaby.R;

public class FamilyPlaningActivity extends AppCompatActivity {
    private Button familyPlanProduct;
    private Button clinicsButton;
    private Button adviceButton;
    private Button coursesButton;
    private Button resourcesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_planing);
    }

    public void onClickFamilyPlanProduct(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        familyPlanProduct = findViewById(R.id.familyPlanProductBtn);
        startActivity(intent);
    }
    public void onClickClinics(View view){
        Intent intent = new Intent(this, ClinicsActivity.class);
        clinicsButton = findViewById(R.id.clinicsButton);
        startActivity(intent);
    }

    public void onClickAdvice(View view) {
        Intent intent = new Intent(this, AdviceActivity.class);
        adviceButton = findViewById(R.id.advice_button);
        startActivity(intent);

    }

    public void onClickCourses(View view) {
        Intent intent = new Intent(this, CoursesActivity.class);
        coursesButton = findViewById(R.id.coursesBtn);
        startActivity(intent);
    }

    public void onClickResources(View view) {
        Intent intent = new Intent(this, ResourcesActivity.class);
        resourcesButton = findViewById(R.id.resourcesBtn);
        startActivity(intent);
    }
}
