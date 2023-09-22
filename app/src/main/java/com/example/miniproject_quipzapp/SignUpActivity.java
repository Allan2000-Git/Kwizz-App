package com.example.miniproject_quipzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText user,pass,cpass;
    Button register,signin;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        cpass=findViewById(R.id.cpass);
        register=findViewById(R.id.register);
        signin=findViewById(R.id.signin);

        myDB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                String confirmpass = cpass.getText().toString();

                if(username.equals(""))
                {
                   // user.requestFocus();
                    user.setError("Field cannot be empty");
                }
                if(confirmpass.equals(""))
                {
                    //cpass.requestFocus();
                    cpass.setError("Field cannot be empty");
                }
                if(password.equals(""))
                {
                    //pass.requestFocus();
                    pass.setError("Field cannot be empty");
                }
                if(password.length()<=7)
                {
                    Toast.makeText(SignUpActivity.this, "Password too weak !!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (password.equals(confirmpass))
                    {
                        Boolean usercheckResult = myDB.checkUsername(username);
                        if (usercheckResult == false)
                        {
                            Boolean regResult = myDB.insertData(username, password);
                            if (regResult == true)
                            {
                                Toast.makeText(SignUpActivity.this, "Registration successfull !!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(SignUpActivity.this, "Registration failed !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this, "User already exists !! \n Please Sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "Password does not match !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}