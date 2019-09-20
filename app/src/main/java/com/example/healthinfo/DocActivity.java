package com.example.healthinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by User on 1/2/2018.
 */

public class DocActivity extends AppCompatActivity {

    private static final String TAG = "DocActivity";

    //vars
    private  ArrayList<String>DocQualification = new ArrayList<>();
    private ArrayList<String> DocNames = new ArrayList<>();
    private ArrayList<String> DocImageUrls = new ArrayList<>();
    private ArrayList<String> DocPhone = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        getSupportActionBar().setTitle("Doctor Lists");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started.");

        initImageBitmapsdoc();
    }

    private void initImageBitmapsdoc(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/58789e0c0d955.jpg&w=350&h=350&static=true");
        DocNames.add("Dr. Sudip Parajuli");
        DocQualification.add("Dermatologist, Venereologist, Leprologist & Dermatosurgeon");
        DocPhone.add("9814941702");

        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/583550f1572a6.jpg&w=350&h=350&static=true");
        DocNames.add("Dr. Ashok Ratna Bajracharya");
        DocQualification.add("MBBS,MS.Orth");
        DocPhone.add("9814941702");


        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/5b54582e4bd5e.jpg&w=350&h=350&static=true");
        DocNames.add("Dr.Sushil Dhungel");
        DocQualification.add("MBBS,Ms");
        DocPhone.add("9814941702");


        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/5c5424ae05c5d.jpeg&w=350&h=350&static=true");
        DocNames.add("Dr.Anil Shrestha");
        DocQualification.add("Prof,MD,MBBS");
        DocPhone.add("9814941702");


        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/5bdc122bab716.png&w=350&h=350&static=true");
        DocNames.add("Dr. Arjun Dev Bhatta");
        DocQualification.add("MD,PH.D,DSC,FICS");
        DocPhone.add("9814941702");

        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/5b90d889546d4.jpg&w=350&h=350&static=true");
        DocNames.add("Dr. Bharat Bahadur Bhandari");
        DocQualification.add("Prof,MD,MBBS");
        DocPhone.add("9814941702");

        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/58200d2b93c15.jpg&w=350&h=350&static=true");
        DocNames.add("Prof. Dr. Bhola Raj Joshi");
        DocQualification.add("MS, FCPS, FNAMS, FAIS");
        DocPhone.add("9814941702");


        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/5822fa8a425e7.jpg&w=350&h=350&static=true");
        DocNames.add("Dr. Pukar Maskey");
        DocQualification.add("MBBS, MS, MCH ( Urology)");
        DocPhone.add("9814941702");

        DocImageUrls.add("https://www.hamrodoctor.com/image.php?src=/uploads/doctors/5938fc723ebd0.jpg&w=200&h=200");
        DocNames.add("Dr. Deepak Babu Rauniyar");
        DocQualification.add("MD");
        DocPhone.add("9814941702");

//        DocImageUrls.add("");
//        DocNames.add("");
//        DocQualification.add("");
//
//        DocImageUrls.add("");
//        DocNames.add("");
//        DocQualification.add("");
//
//
//        DocImageUrls.add("");
//        DocNames.add("");
//        DocQualification.add("");





        initRecyclerViewdoc();
    }

    private void initRecyclerViewdoc(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerViewdoc = findViewById(R.id.recycler_viewdoc);
        RecyclerViewAdapterDoc adapterdoc = new RecyclerViewAdapterDoc(this, DocNames,DocImageUrls,DocQualification,DocPhone);
        recyclerViewdoc.setAdapter(adapterdoc);
        recyclerViewdoc.setLayoutManager(new LinearLayoutManager(this));
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





