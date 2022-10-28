package com.example.application_mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application_mobile.DbHelper.DbHelper;
import com.example.application_mobile.R;

public class SignUp extends AppCompatActivity {


    private EditText username,address,mobile,email,password;
    private Button register,already_register;
    DbHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sign_up);

        username =findViewById(R.id.name);
        address = findViewById(R.id.address);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        already_register = findViewById(R.id.already_register);
        dbHelper = new DbHelper(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username_ = username.getText().toString();
                String address_ = address.getText().toString();
                String mobile_ = mobile.getText().toString();
                String email_ = email.getText().toString();
                String password_ = password.getText().toString();
                String role = "ADMIN";

                if(TextUtils.isEmpty(username_) || TextUtils.isEmpty(address_) || TextUtils.isEmpty(mobile_) || TextUtils.isEmpty(email_) || TextUtils.isEmpty(password_) ){
                    Toast.makeText(SignUp.this,"All Fields Required !!!",Toast.LENGTH_SHORT).show();
                }

                System.out.println("==============HERE===================");
                Boolean insert = dbHelper.InsertData(username_,address_, mobile_,email_,password_,role);

                System.out.println(insert);

                if(insert == true){
                    Toast.makeText(SignUp.this,"Sign Up Success !!!",Toast.LENGTH_SHORT).show();

                    Intent intent =new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);

                }else{

                    Toast.makeText(SignUp.this,"Registration Failed !!!",Toast.LENGTH_SHORT).show();


                }

            }
        });

        already_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });


    }
}