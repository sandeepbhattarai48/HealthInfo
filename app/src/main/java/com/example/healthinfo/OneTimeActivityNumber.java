package com.example.healthinfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class OneTimeActivityNumber extends AppCompatActivity {

    EditText userOneName, userTwoName, userOnePhone ,userTwoPhone;
    Button buttonNext;
    FirebaseAuth mAuth;
    private DatabaseReference myRef;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_number);


        userOneName = findViewById(R.id.user1_name);
        userTwoName = findViewById(R.id.user2_name);
        userOnePhone = findViewById(R.id.user1_phone);
        userTwoPhone = findViewById(R.id.user2_phone);
        buttonNext = findViewById(R.id.button_next);


        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Creating");
        progressDialog.setMessage("Updating Details");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);




        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(userOneName.getText()))
                {
                    Toast.makeText(OneTimeActivityNumber.this, "Enter Username for User 1.", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                if(TextUtils.isEmpty(userTwoName.getText())) {
                    Toast.makeText(OneTimeActivityNumber.this, "Enter Username for User 2.", Toast.LENGTH_SHORT).show();
                    return;
                }


                    if ((userOnePhone.getText().toString().length()) !=10  ) {
                        Toast.makeText(OneTimeActivityNumber.this, "Enter Valid Phone Number for User 1.", Toast.LENGTH_SHORT)
                                .show();
                        return;
                    }

                if ((userTwoPhone.getText().toString().length()) !=10 ) {
                    Toast.makeText(OneTimeActivityNumber.this, "Enter Valid Phone Number  for User 2.", Toast.LENGTH_SHORT)
                            .show();
                    return;
                }


                PhoneDetails phoneDetails = new PhoneDetails(userOneName.getText().toString(),userTwoName.getText().toString(),
                       userOnePhone.getText().toString(),userTwoPhone.getText().toString());


                String currentUserId = mAuth.getCurrentUser().getUid();
                myRef.child("phone_details").child(currentUserId).setValue(phoneDetails);
                progressDialog.dismiss();
                finish();

                Toast.makeText(OneTimeActivityNumber.this, "Details Updated", Toast
                        .LENGTH_SHORT).show();




            }
        });
    }
}
