package com.example.healthinfo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class HomeActivity extends AppCompatActivity {
    FlipperLayout flipper;
    FirebaseAuth mAuth;
     private String currentUserUid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show sign up activity
            startActivity(new Intent(HomeActivity.this, OneTimeActivityNumber.class));
            Toast.makeText(HomeActivity.this, "Run only once", Toast.LENGTH_LONG)
                    .show();
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();



        flipper = (FlipperLayout) findViewById(R.id.flipper);
        setLayout();

        mAuth = FirebaseAuth.getInstance();
        currentUserUid = mAuth.getCurrentUser().getUid();


        CardView medicine_alert = findViewById(R.id.medicine_alert);
        medicine_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AlarmMainActivity.class));
            }
        });

        CardView emergency = findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, EmergencyActivity.class));
            }
        });
        CardView bmi = findViewById(R.id.bmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, BodyMassIndex.class));
            }
        });
        CardView ambulance = findViewById(R.id.ambulance);
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, Ambulance.class));
            }
        });
        CardView generalknowledge = findViewById(R.id.general_knowledge);
        generalknowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GeneralKnowledge.class));
            }
        });
        CardView userAccount = findViewById(R.id.user_account);
        userAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, UserAccount.class));
            }
        });

        CardView hospitals = findViewById(R.id.hospitals);
       hospitals.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(HomeActivity.this, HospitalLists.class));
            }
        });

        CardView doctors = findViewById(R.id.doctors);
        doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });




    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null)
        {
            LogOutUser();
        }
    }

    private void LogOutUser() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.btn_logout)
        {
            mAuth.signOut();
            LogOutUser();
        }

        return true;
    }

    private void setLayout() {
        int[] url = {
                R.drawable.birhospital,
                R.drawable.cancerhospital,
                R.drawable.civilhospital,
        };

        for (int i = 0; i < 3; i++) {
            FlipperView view = new FlipperView(getBaseContext());
            view.setImageDrawable(url[i])
                    .setDescription("Image" + (i + 1));

            flipper.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    Toast.makeText(HomeActivity.this, "" + (flipper.getCurrentPagePosition() + 1), Toast.LENGTH_SHORT).show();
                }
            });

        }

    }


}
