package com.example.findmydog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText emailedittext;
    private EditText passedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailedittext = (EditText) findViewById(R.id.txtemail);
        passedittext = (EditText) findViewById(R.id.txtpassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void checklogin(View arg0){
        final String email = emailedittext.getText().toString();
        if (!isValidEmail(email)){
            emailedittext.setError("Email tidak valid!");
        }

        final String pass = passedittext.getText().toString();
        if (!isValidPassword(pass)){
            passedittext.setError("Password tidak boleh kosong / harus lebih dari 4 karakter");
        }

        if (isValidEmail(email) && isValidPassword(pass)){

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Anda Berhasil Login", Toast.LENGTH_LONG).show();
                    Intent login = new Intent(MainActivity.this, menu.class);
                    startActivity(login);
                }
            });

        }
    }


    public boolean isValidPassword(String password){
        if (password!=null && password.length()>=4){
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String email){
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
