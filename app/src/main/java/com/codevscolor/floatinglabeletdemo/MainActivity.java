package com.codevscolor.floatinglabeletdemo;

import android.graphics.PorterDuff;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button loginButton;

    private String emailText;
    private String pwdText;

    private TextInputLayout emailLayout;
    private TextInputLayout pwdLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        loginButton = (Button) findViewById(R.id.button);

        emailLayout = (TextInputLayout) findViewById(R.id.layout_email);
        pwdLayout = (TextInputLayout) findViewById(R.id.layout_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void login() {
        emailText = etEmail.getText().toString().trim();
        pwdText = etPassword.getText().toString().trim();

        if (emailText.isEmpty()) {
            emailLayout.setError(getString(R.string.hint_empty));
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            emailLayout.setError(getString(R.string.error_email));
        } else {
            emailLayout.setErrorEnabled(false);
        }
        if (pwdText.isEmpty()) {
            pwdLayout.setError(getString(R.string.hint_empty));
        } else {
            pwdLayout.setErrorEnabled(false);
        }

        if (!emailLayout.isErrorEnabled() && !pwdLayout.isErrorEnabled()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyle);
            builder.setMessage("Successfull !!");
            builder.setPositiveButton("OK", null);
            builder.show();
        }

    }
}
