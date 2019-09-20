package com.example.healthinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DocProfile extends AppCompatActivity {

    private static final String TAG = "DocPofile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_profile);

        getSupportActionBar().setTitle("Doctor Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntentdoc();
    }

    private void getIncomingIntentdoc(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") &&
                getIntent().hasExtra("image_qualification") && getIntent().hasExtra("doc_phone")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageQualification = getIntent().getStringExtra("image_qualification");
            String docPhone = getIntent().getStringExtra("doc_phone");


            setImage(imageUrl, imageName,imageQualification, docPhone);



        }
    }


    private void setImage(String imageUrl, String imageName, String imageQualification, String docPhone){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.name);
        name.setText(imageName);

        TextView qualification = findViewById(R.id.doc_qualification);
        qualification.setText(imageQualification);

        TextView phone = findViewById(R.id.doc_phone);
        phone.setText(docPhone);

        ImageView image = findViewById(R.id.profile);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if( id == android.R.id.home) {
        finish();
        return true;
    }

    if (id == R.id.search) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}
}
