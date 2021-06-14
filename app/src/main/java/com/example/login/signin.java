package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class signin extends AppCompatActivity {
    EditText username,pass;
    Button signin;
    String re =  "^(?=.{8,32}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*";
    int count =0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        signin = findViewById(R.id.signin);
        
        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("username");
        String pwd = bundle.getString("password");
        
        
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String password = pass.getText().toString();
             if(user.equals(uname) && password.equals(pwd)){

                 Toast.makeText(signin.this, "Successful Login", Toast.LENGTH_SHORT).show();
             }
             else {
                 count++;
                 if (count > 2) {
                     Toast.makeText(signin.this, "Failed Login Attempts”", Toast.LENGTH_SHORT).show();
                     signin.setEnabled(false);
                 } else {
                     Toast.makeText(signin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                 }
             }
            }
        });
        



    }
}