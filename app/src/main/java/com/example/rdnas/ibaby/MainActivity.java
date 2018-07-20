package com.example.rdnas.ibaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button signUp;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickSignUp(View view) {
        Intent intent =new Intent(this, SignUpActivity.class);
        signUp = findViewById(R.id.sign_up_Btn);
        startActivity(intent);
    }

    public void onClickLogIn(View view) {
        Intent intent = new Intent(this, CatagoryActivity.class);
        logIn = findViewById(R.id.logIn);
        startActivity(intent);
    }
}
