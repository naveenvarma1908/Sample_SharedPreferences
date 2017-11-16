package com.naveen.samplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText username, password;
    private Button login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();


        username = (EditText)findViewById(R.id.edit_LUsername);
        password = (EditText)findViewById(R.id.edit_LPassword);

        login = (Button)findViewById(R.id.button_login);


        sharedPreferences = getSharedPreferences("Naveen",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LoginState","0");
        editor.commit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String spname = sharedPreferences.getString("Username","");
                String sppass = sharedPreferences.getString("Password","");

                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (name.equals(spname) && pass.equals(sppass)){


                    Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Username Or Password", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }

    public void gotoRg(View view) {

        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);

    }
}
