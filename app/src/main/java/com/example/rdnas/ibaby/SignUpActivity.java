package com.example.rdnas.ibaby;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private TextView dateView2;
    private TextView logInRegister;
    private int year, month, day;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dateView = findViewById(R.id.showDate);
        dateView2 =findViewById(R.id.showDate2);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);
        showDate2(year, month + 1, day);
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Date is going on",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                    showDate2(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @SuppressWarnings("deprecation")
    public void setDate2(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Date is going on",
                Toast.LENGTH_SHORT)
                .show();
    }

    private void showDate2(int year, int i, int day) {
        dateView2.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void onClickRegister(View view) {
        Intent intent =new Intent(this, MainActivity.class);
        register = findViewById(R.id.register);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Register Complete.",
                Toast.LENGTH_SHORT)
                .show();
    }

    public void loginRegister(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        logInRegister = findViewById(R.id.login_Register);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Please LogIn First",
                Toast.LENGTH_SHORT)
                .show();
    }
}

