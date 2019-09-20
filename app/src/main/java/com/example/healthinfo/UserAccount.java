package com.example.healthinfo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

public class UserAccount extends AppCompatActivity {
    FirebaseAuth mAuth;
    private String currentUserUid;
    TextView inputEmail, inputUsername, inuptBloodGroup;
    DatabaseReference myRefUserDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        getSupportActionBar().setTitle("Account Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        inputEmail = findViewById(R.id.label_email);
        inputUsername = findViewById(R.id.label_user);
        inuptBloodGroup = findViewById(R.id.label_blood_group);

        mAuth = FirebaseAuth.getInstance();
        currentUserUid = mAuth.getCurrentUser().getUid();



        myRefUserDetails = FirebaseDatabase.getInstance().getReference().child("users").child(currentUserUid);
        myRefUserDetails.keepSynced(true);
        getUserDetails();
    }

        private void getUserDetails () {
            myRefUserDetails.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot dataSnapshot) {
                    inputUsername.setText(dataSnapshot.child("username").getValue(String.class));
                    inputEmail.setText(dataSnapshot.child("email").getValue(String.class));
                    inuptBloodGroup.setText(dataSnapshot.child("blood_group").getValue(String.class));


                }



                @Override
                public void onCancelled(DatabaseError databaseError) {

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


