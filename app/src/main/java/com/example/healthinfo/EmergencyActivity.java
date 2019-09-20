package com.example.healthinfo;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.SearchView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

public class EmergencyActivity extends AppCompatActivity {
     TextView user1, user2 , phone1, phone2;
    DatabaseReference myRefUserDetails;
    FirebaseAuth mAuth;
    private String currentUserUid;
    ImageView callPhone1,callPhone2, edit1, edit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);


        getSupportActionBar().setTitle("Emergency");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user1 = findViewById(R.id.user_one_name);
        user2 = findViewById(R.id.user_two_name);
        phone1 = findViewById(R.id.user_one_phone);
        phone2 = findViewById(R.id.user_two_phone);

        callPhone1 = findViewById(R.id.img_phone);
        callPhone2 = findViewById(R.id.img_phone2);

        edit1 = findViewById(R.id.img_edit);
        edit2 = findViewById(R.id.img_edit2);


        mAuth = FirebaseAuth.getInstance();
        currentUserUid = mAuth.getCurrentUser().getUid();

            myRefUserDetails = FirebaseDatabase.getInstance().getReference().child("phone_details").child(currentUserUid);



        getUserDetails();
    }



    private void getUserDetails () {


        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmergencyActivity.this, OneTimeActivityNumber.class));

            }
        });

        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmergencyActivity.this, OneTimeActivityNumber.class));

            }
        });
        myRefUserDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                user1.setText(dataSnapshot.child("name1").getValue(String.class));
                user2.setText(dataSnapshot.child("name2").getValue(String.class));
                phone1.setText(dataSnapshot.child("phone1").getValue(String.class));
                phone2.setText(dataSnapshot.child("phone2").getValue(String.class));

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        callPhone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phone1.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +
                        phone));
                startActivity(intent);
            }
        });

        callPhone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phone2.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +
                        phone));
                startActivity(intent);
            }
        });

        Button btnCallPolice = findViewById(R.id.btn_callAmbulance);
        Button btnCallHealthInfo = findViewById(R.id.btn_callhealthinfo);

        btnCallPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "100";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +
                        phone));
                startActivity(intent);
            }
        });

        btnCallHealthInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "102";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +
                        phone));
                startActivity(intent);
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
