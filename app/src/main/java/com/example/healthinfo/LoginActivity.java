package com.example.healthinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

     EditText inputEmail, inputPassword;
    CheckBox remember_me;
    TextView forgetPassword;
     Button btnLogin, btnRegister;
    private FirebaseAuth mAuth;
     ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.pass);
        remember_me = findViewById(R.id.remember_me);
        btnLogin = findViewById(R.id.login_btn);
        btnRegister = findViewById(R.id.register_btn);
        forgetPassword = findViewById(R.id.forgot_password);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Signing In");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPassword.class));

            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                String username = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(username))
                {
                    Toast.makeText(LoginActivity.this, "Enter Username", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show();


                signInFirebase(username,password);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterUser.class));

            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
            finish();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }

    }


    public  void signInFirebase (final String username, String password){
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            Toast.makeText(LoginActivity.this, "Welcome " + username, Toast
                                    .LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this,task.getException().getMessage(), Toast
                                    .LENGTH_SHORT)
                                    .show();

                        }
                    }
                });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);

    }


}