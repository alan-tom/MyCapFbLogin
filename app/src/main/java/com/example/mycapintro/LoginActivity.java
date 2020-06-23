package com.example.mycapintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout userWrap,passwrap;
    private EditText username, password;
    private Button login;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userWrap = (TextInputLayout) findViewById(R.id.inputUserId);
        passwrap = (TextInputLayout) findViewById(R.id.passwrapId);
        username = (EditText) findViewById(R.id.usernameTextId);
        password = (EditText) findViewById(R.id.passTextId);
        login = (Button) findViewById(R.id.loginId);
        signup = (TextView) findViewById(R.id.signUpId);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userWrap.setErrorEnabled(false);
                passwrap.setErrorEnabled(false);
                int flag = 0;
                String uText = username.getText().toString();
                String pText = password.getText().toString();
                String error1, error2;
                if(uText.length() < 4 || uText.length() > 20){
                    error1 = "Username should be 4-20 characters";
                    flag = 1;
                    userWrap.setError(error1);
                }
                if(pText.length() < 4 || uText.length() > 20){
                    error2 = "Password should be 4-20 characters";
                    flag = 1;
                    userWrap.setError(error2);
                }

                if(flag == 0){
                    Toast.makeText(LoginActivity.this,"Successful Login", LENGTH_SHORT).show();
                    Bundle extra = new Bundle();
                    extra.putString("Username",uText);
                    Intent intent = new Intent(LoginActivity.this, Welcome.class);
                    intent.putExtras(extra);
                    startActivity(intent);
                    LoginActivity.this.finish();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

}
