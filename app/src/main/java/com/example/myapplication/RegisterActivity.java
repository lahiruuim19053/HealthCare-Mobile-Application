package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edemail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername= findViewById(R.id.editTextRegUsername);
        edemail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonReg);
        tv = findViewById(R.id.textViewExistingUser);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,loginActivity2.class));
            };

        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edemail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                if(username.length()==0 || password.length()==0 || confirm.length()==0 || edemail.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Fill all details...!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0){
                       if(isValid(password)){
                           Toast.makeText(getApplicationContext(),"Record inserted",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(RegisterActivity.this,loginActivity2.class));
                       }
                       else{
                           Toast.makeText(getApplicationContext(),"Password must contain at least 8 characters, having letters,digit and special symbol",Toast.LENGTH_SHORT).show();
                       }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password and confirm password are not same",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String passwordhere){
        int f1 = 0, f2 = 0, f3 = 0;
        if(passwordhere.length()<8){
            return false;
        }
        else{
            for(int p = 0;p<passwordhere.length();p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r = 0;r<passwordhere.length();r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s = 0;s<passwordhere.length();s++){
                char c = passwordhere.charAt(s);
                if(c>=33&&c<=64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;

        }
    }
}