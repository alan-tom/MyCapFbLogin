package com.example.mycapintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Welcome extends AppCompatActivity {

    private TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Bundle extra = getIntent().getExtras();
        String a = extra.getString("Username");

        welcome = (TextView) findViewById(R.id.welcomeId);
        welcome.setText("Welcome " + a);

    }
}
