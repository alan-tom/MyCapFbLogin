package com.example.mycapintro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout fnameL, lnameL, usernameL, emailL, passL, repassL, numL;
    private EditText fname, lname, username, email, pass, repass, num;
    private Button signUp;
    private TextView dateError;
    private DatePicker datePicker;
    private LocalDate n = LocalDate.now();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fnameL = (TextInputLayout) findViewById(R.id.SignUpFirstNameLayout);
        lnameL = (TextInputLayout) findViewById(R.id.SignUpLastNameLayout);
        usernameL = (TextInputLayout) findViewById(R.id.SignUpUsernameLayout);
        emailL = (TextInputLayout) findViewById(R.id.SignUpEmailLayout);
        passL = (TextInputLayout) findViewById(R.id.SignUpPasswordLayout);
        repassL = (TextInputLayout) findViewById(R.id.SignUpRePasswordLayout);
        fname = (EditText) findViewById(R.id.SignUpFirstNameId);
        lname = (EditText) findViewById(R.id.SignUpLastNameId);
        username = (EditText) findViewById(R.id.SignUpUsernameId);
        email = (EditText) findViewById(R.id.SignUpEmailId);
        pass = (EditText) findViewById(R.id.SignUpPasswordId);
        repass = (EditText) findViewById(R.id.SignUpRePasswordId);
        signUp = (Button) findViewById(R.id.signUpButId);
        dateError = (TextView) findViewById(R.id.dateError);
        datePicker = (DatePicker) findViewById(R.id.SignUpDatePicker);
        datePicker.setMaxDate(new Date().getTime());

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean b = checkfilled();
            }
        });
    }
    public boolean checkfilled(){
        Boolean flag = Boolean.FALSE;
        if(fname.getText().toString().equals("")){
            flag = Boolean.TRUE;
            fnameL.setError("Must be filled");
        }else if (fname.getText().toString().contains(" ")){
            flag = Boolean.TRUE;
            fnameL.setError("Spaces not allowed");
        }
        if(username.getText().toString().length() < 4 || username.getText().toString().length() > 20){
            flag = Boolean.TRUE;
            usernameL.setError("4-20 characters required");
        }else if (username.getText().toString().contains(" ")){
            flag = Boolean.TRUE;
            usernameL.setError("spaces not allowed");
        }
        if (email.getText().toString().equals("")) {
            flag = Boolean.TRUE;
            emailL.setError("Must be filled");
        }else if (email.getText().toString().split("@").length != 2){
            flag = Boolean.TRUE;
            emailL.setError("please correct format");
        }else if (email.getText().toString().contains(" ")){
            flag = Boolean.TRUE;
            emailL.setError("spaces not allowed");
        }
        if(pass.getText().toString().length() < 4 || pass.getText().toString().length() > 20){
            flag = Boolean.TRUE;
            passL.setError("4-20 characters required");
        }else if (pass.getText().toString().contains(" ")){
            flag = Boolean.TRUE;
            passL.setError("spaces not allowed");
        }else if (repass.getText().toString().equals(pass.getText().toString())){
            flag = Boolean.TRUE;
            repassL.setError("should match new password");
        }
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        LocalDate l = LocalDate.of(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        Period diff = Period.between(l,n);
        Toast.makeText(this,"Difference " + diff.getYears() + " " + diff.getMonths() + " " + diff.getDays(),Toast.LENGTH_SHORT).show();
        return flag;
    }
}
