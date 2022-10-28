package com.example.application_mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application_mobile.DbHelper.DbHelper;
import com.example.application_mobile.R;
import com.example.application_mobile.fragment.fuelStation.FuelStation;

public class Login extends AppCompatActivity {

    private EditText username,password;
    private Button login;
    DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        dbHelper = new DbHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = username.getText().toString();
                String pass = password.getText().toString();


                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
//                    Toast.makeText(SignUp.this,"All Fields Required !!!",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkPassword = dbHelper.checkUsernamePassword(email,pass);

                    System.out.println(checkPassword);
                    if(checkPassword == true){
                       Toast.makeText(Login.this,"Login Success!!!",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(Login.this,"Login Failed!!!",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

    }
}