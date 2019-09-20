package com.example.healthinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Doctor Fields");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/general_surgery.png");
        mNames.add("General Surgery");

        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/Urology.png");
        mNames.add("Urology");

        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/General_Medicine.png");
        mNames.add("General Medicine");

        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/Orthopedic.png");
        mNames.add("Orthopedic");


        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Radiology");

        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Paediatrics");


        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Pathology ");

        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/Psychiatry.png");
        mNames.add("Psychiatry");

        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Cardiology");

        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Paediatrics");


        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Naturopathy & yoga ");

        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Gastroenterology");

        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Ear Nose Throat");


        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/Orthopedic.png");
        mNames.add("Rheumatology");

        mImageUrls.add("https://www.hamrodoctor.com/img/icons/no_service.png");
        mNames.add("Accupuncture");

        mImageUrls.add("https://www.hamrodoctor.com/uploads/icons/services/familyMedicine.png");
        mNames.add("Family Medicine(General Practice)");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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






















