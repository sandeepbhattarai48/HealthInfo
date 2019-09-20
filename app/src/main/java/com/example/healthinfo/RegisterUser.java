package com.example.healthinfo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends AppCompatActivity {

     EditText inputEmail, inputPassword, userName, matchinputPassword;
    FirebaseAuth mAuth;
    Button btnSignUp;
    private RadioGroup radioGroup;
    RadioButton radioButton;
    private Spinner spinner;
    private ProgressDialog progressDialog;
    private DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);



        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        userName = (EditText) findViewById(R.id.reg_username);
        inputPassword = findViewById(R.id.reg_pass);
        inputEmail = findViewById(R.id.reg_email);
        btnSignUp = findViewById(R.id.sign_up_button);
        radioGroup = findViewById(R.id.myRadioGroup);
        matchinputPassword = findViewById(R.id.match_reg_pass);
        spinner = findViewById(R.id.blood_lists);


        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Register");
        progressDialog.setMessage("Creating Account");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String matchpassword = matchinputPassword.getText().toString();
                String bloodGroup = spinner.getSelectedItem().toString();


                radioGroup= findViewById(R.id.myRadioGroup);


                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(RegisterUser.this, "Enter Username", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterUser.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.equals(matchpassword)) {

                    progressDialog.show();
                    registerUser(name, email, password,bloodGroup, radioGroup
                            .getCheckedRadioButtonId() == R.id.male ? "Male" : "Female");

                    //password and confirm passwords equal.go to next step
                } else {

                    Toast.makeText(RegisterUser.this, "Password Not Matching.", Toast.LENGTH_SHORT).show();
                    //passwords not matching.please try again
                }


            }

        });
    }



    private void registerUser(final String name, final String email, final String password,final String bloodGroup, final String gender) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new
                        OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())

                                {
                                    progressDialog.dismiss();
                                    startActivity(new Intent(RegisterUser.this, LoginActivity.class));
                                    Toast.makeText(RegisterUser.this, "Account Sucessfully Created. + ", Toast
                                            .LENGTH_SHORT).show();
                                    Toast.makeText(RegisterUser.this, "Welcome " + name, Toast
                                            .LENGTH_SHORT).show();


                                    String currentUserId = mAuth.getCurrentUser().getUid();
                                    Map userDetails = new HashMap();

                                    userDetails.put("username", name);
                                    userDetails.put("email", email);
                                    userDetails.put("gener", gender);
                                    userDetails.put("blood_group",bloodGroup);


                                    myRef.child("users").child(currentUserId).setValue(userDetails);


                                } else {
                                    progressDialog.dismiss();
                                    // If sign in fails, display a message to the user.
                                    Log.w("FirebaseError", "createUserWithEmail:failure", task
                                            .getException
                                                    ());

                                    Toast.makeText(RegisterUser.this, task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
