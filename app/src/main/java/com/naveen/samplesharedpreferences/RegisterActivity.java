package com.naveen.samplesharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    private EditText username,pass,cpass,email,ph;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();


        username = (EditText)findViewById(R.id.edit_RUsername);
        pass = (EditText)findViewById(R.id.edit_RPassword);
        cpass = (EditText)findViewById(R.id.edit_RCPassword);
        email = (EditText)findViewById(R.id.edit_REmail);
        ph = (EditText)findViewById(R.id.edit_RPhone);

        submit = (Button)findViewById(R.id.button_Submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name,mail,pwd,cpwd,phone;

                name = username.getText().toString().trim();
                mail = email.getText().toString().trim();
                pwd = pass.getText().toString().trim();
                cpwd = cpass.getText().toString().trim();
                phone = ph.getText().toString().trim();

                if (pwd.equals(cpwd)){

                    //Actions

                    SharedPreferences sharedPreferences = getSharedPreferences("Naveen",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Username",name);
                    editor.putString("Email",mail);
                    editor.putString("Password",pwd);
                    editor.putString("Phone",phone);
                    
                    // TO save the data in sharedpref you have to commit
                    editor.commit();
                    
                    //To Clear the data from sharedPref you can use.
                    //editor.clear();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    
                }else {
                    cpass.setError("Password Mismatch");
                }



            }
        });









    }
}
