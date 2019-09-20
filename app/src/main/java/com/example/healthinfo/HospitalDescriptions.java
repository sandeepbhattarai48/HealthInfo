package com.example.healthinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class HospitalDescriptions extends AppCompatActivity {

    private static final String TAG = "HospitalDescriptions";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_descriptions);


        getSupportActionBar().setTitle("Hospital Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getIncomingIntent();

    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String about = getIntent().getStringExtra("about");
            String location = getIntent().getStringExtra("location");
            String phoneNo = getIntent().getStringExtra("phone_no");
            String email = getIntent().getStringExtra("email");

            setImage(imageUrl, imageName, about, location,phoneNo,email);
        }
    }


    private void setImage(String imageUrl, String imageName, String about, String location, String phoneNo, String email){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        TextView mabout = findViewById(R.id.about);
        mabout.setText(about);

        TextView mlocation = findViewById(R.id.location);
        mlocation.setText(location);

        TextView mphoneno = findViewById(R.id.phoneno);
        mphoneno.setText(phoneNo);

        TextView memail = findViewById(R.id.email);
        memail.setText(email);



        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
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
