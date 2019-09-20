package com.example.healthinfo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.*;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Ambulance extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Details> detailsList = new ArrayList<>();
    AmbulanceRecyclerViewAdapter recyclerViewAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView = findViewById(R.id.search);
        setContentView(R.layout.activity_recycler_view_ambulance);


        recyclerView = findViewById(R.id.recycler_view);

        getSupportActionBar().setTitle("Ambulance Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewAdapter = new AmbulanceRecyclerViewAdapter(detailsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);




        prepareAmbulanceData();
    }


    private void prepareAmbulanceData() {
        Details details = new Details("24x7 Ambulance Service", "Basundhara, Kathmandu", "9840186344");
        detailsList.add(details);

        details = new Details("Akhil Nepal Chiya Majdur Sangh", "Jhapa", "9814952000");
        detailsList.add(details);

        details = new Details("Alka Hospital Ambulance", "Jawalakhel,kathmandu ", "01-5555555");
        detailsList.add(details);

        details = new Details("Ambulance Lalitpur Municipality", "Pulchowk, Lalitpur", "01-5527003");
        detailsList.add(details);

        details = new Details("Ambulance Service NACoDS", "Lamachaur, Pokhara, Kaski", "061441100\n9856031337");
        detailsList.add(details);

        details = new Details("Ambulance Service Ramghat", "Ramghat-11, Pokhara, Kaski", "061521091");
        detailsList.add(details);

        details = new Details("Ambulance Service Siddhartha Club", "Siddhartha Chowk, Pokhara, Kaski", "061530200\n061521433");
        detailsList.add(details);

        details = new Details("Amda Hospital Ambulance Service", "Damak, Jhapa", "023-580989");
        detailsList.add(details);

        details = new Details("Arba Ambulance", "Kaski", "9856037658");
        detailsList.add(details);

        details = new Details("B AND C MEDICAL COLLAGE TEACHING HOSPITAL AND RESEARCH CENTER", "Jhapa", "9843714977");
        detailsList.add(details);

        details = new Details("B. P. KOIRALA MEMOROIAL CANCER HOSPITAL", "Chitwan", "56- 524501");
        detailsList.add(details);

        details = new Details("B. P. SMRITI HOSPITAL", "Basundhara, Kathmandu", "9841447710");
        detailsList.add(details);

        details = new Details("B.P. Koirala Institute Of Health Science", "Chitwan", "9845052350");
        detailsList.add(details);

        details = new Details("Bharosa Hospital", "Mid Baneswor, Kathmandu", "01-4450493");
        detailsList.add(details);

        details = new Details("Bir Hospital", "Kanti Path, Kathmandu ", "9841182727");
        detailsList.add(details);

        details = new Details("Bishal Bazar Ambulance Sewa", "Bishalbazar, Kathmandu", "01-4244121");
        detailsList.add(details);

        details = new Details("Blue Cross Hospital", "Tripureshwor", "01-4262027\n01-4262027");
        detailsList.add(details);

        details = new Details("Chemaber Of Commerce", "Kathamandu", "01-4230213");
        detailsList.add(details);

        details = new Details("Chhetrapati Nisulka Chikitsalaya", "Chhetrapati, Kathmandu", "01-4257911");
        detailsList.add(details);

        details = new Details("Chimeki Maitri Samaj", "Jorpati, Kathmandu", "9841441275");
        detailsList.add(details);

        details = new Details("Chitwan Hospital Pvt.Ltd.", "Chitwan", "9845591926");
        detailsList.add(details);

        details = new Details("Civil Service Hospital", "New Baneshwor", "01-4107000");
        detailsList.add(details);

        details = new Details("Civil Welfare Organization", "Gongabu, Kathmandu", "01-4365128");
        detailsList.add(details);

        details = new Details("CIWEC Hospital", "Lazimpat, Kathmandu", "01-4435232");
        detailsList.add(details);

        details = new Details("Dhanchanra Smirti Ambulance Sewa", "Surunga, Jhapa", "023-551155\n984264610");
        detailsList.add(details);

        details = new Details("Dhankuta Hospital Ambulance", "Dhankuta", "9842060752");
        detailsList.add(details);

        details = new Details("Dhankuta Red Cross", "Dhankuta", "026-520102");
        detailsList.add(details);

        details = new Details("Dhankuta, Jitpur Amulance", "Jitpur, Dhankuta", "9862009552");
        detailsList.add(details);

        details = new Details("Dhulabadi Jesij Ambulance Service", "Dhulabadi, Jhapa", "023-560322");
        detailsList.add(details);

        details = new Details("District Public Health Office", "Teku, Kathmandu", "01-4278612");
        detailsList.add(details);

        details = new Details("District Redcross,Bidur", "Nuwakot", "98434333030\n 010-560070");
        detailsList.add(details);

        details = new Details("Dr. Iwamura Memorial Hospital & Research Center", "Nagarkot", "01-6612695\n01-6612705");
        detailsList.add(details);

        details = new Details("Eastern Nepal Cooperative Ambulance Service", "Kerkha, Jhapa", "9852670073");
        detailsList.add(details);

        details = new Details("Golden Hospital Pvt.Ltd.", "Morang", "9816391881");
        detailsList.add(details);

        details = new Details("Hanuman Mandir Ambulance Service", "Budhabare, Jhapa", "023-555004");
        detailsList.add(details);

        details = new Details("Jhapa Redcross Society Ambulance Service", "Bhadrapur, Jhapa", "023-520102");
        detailsList.add(details);

        details = new Details("Kanchenjunga Hospital Ambulance Service", "Birtamod, Jhapa", "023-541357");
        detailsList.add(details);

        details = new Details("Kedar Bhadur Simriti Sewa", "Dhading", "9841898941\n9841639732");
        detailsList.add(details);

        details = new Details("Kohalpur Bahu-Udyeshiya Sahakari Ambulance", "Kohalpur, Banke", "081541700");
        detailsList.add(details);

        details = new Details("Lalitpur Redcross Ambulance Service", "Lalitpur", "01-4260859");
        detailsList.add(details);

        details = new Details("Laxmi Ambulance", "Jhapa", "9803639155");
        detailsList.add(details);

        details = new Details("Laxminarayan Mandir Ambulance Service", "Maidhar, Jhapa", "023-550367");
        detailsList.add(details);

        details = new Details("LIFE GUARD HOSPITAL PVT. LTD", "Bargachhi, Biratnagar-6, Morang", "9742042333\n021-463177");
        detailsList.add(details);

        details = new Details("Life Line Hospital Ambulance", "Damak-10, Jhapa, Nepal", "023-580636\n023-580997");
        detailsList.add(details);

        details = new Details("Lions Club", "Morang", "021-537001");
        detailsList.add(details);

        details = new Details("Lions Club Of Birtamode", "Jhapa", "9864446377");
        detailsList.add(details);

        details = new Details("Maan Bahadhur Smriti Pratisthan", "Nuwakot", "9841681486");
        detailsList.add(details);

        details = new Details("Madwadi Sewa Samaj", "Kathamandu", "01-4255740\n9841000939\n9841488509");
        detailsList.add(details);

        details = new Details("Manmohan Community Hospital", "Pharping, Dakshinkali, Kathmandu", "01-4710033");
        detailsList.add(details);

        details = new Details("Mechi Anchal Hospital,Ambulance Service", "Bhadrapur, Jhapa", "023-520172");
        detailsList.add(details);

        details = new Details("Medicare National Hospital Ambulance", "Chabahil, Kathmandu", "01-4467067");
        detailsList.add(details);

        details = new Details("Model Hospital", "kaski", "9846311804");
        detailsList.add(details);

        details = new Details("MORANG HOSPITAL PVT. LTD.", "Patharishanischare-1, Morang", "021-555343\n9842043748");
        detailsList.add(details);

        details = new Details("Namuna Samaj Jhiljhile Ambulance Service", "Jhiljhile, Jhapa", "023-470218");
        detailsList.add(details);

        details = new Details("National Insitute Of Neurological Sciences", "Bansbari", "01-4373850");
        detailsList.add(details);

        details = new Details("Nepal Red Cross Society(Ghauladuwa)", "Jhapa", "9815980500");
        detailsList.add(details);

        details = new Details("Nuwakot Hospital", "Nuwakot Trishuli", "010-560640\n010-561131");
        detailsList.add(details);

        details = new Details("Om Hospital", "Chabahil, Kathmandu", "01-4482484");
        detailsList.add(details);

        details = new Details("Sewa Hospital", "Kaski", "061-528163");
        detailsList.add(details);

        details = new Details("Shree Narayan Chandra Smriti Sewa Samaj", "Pashuhat Damak, Jhapa", "9814991133");
        detailsList.add(details);

        details = new Details("Stupa Community Hospital", "Bouddha", "01-4488372");
        detailsList.add(details);

        details = new Details("Sumeru Ambulance", "Lalitpur", "9841437660");
        detailsList.add(details);

        details = new Details("Thimi Ambulance", "Thimi, Bhaktapur", "01-6631000");
        detailsList.add(details);

        details = new Details("Unique College Of Medical Science & Hospital", "Raypur – 9, Saptari", "9804728301");
        detailsList.add(details);

        details = new Details("Vayodha Hospital", "Balkhu Chowk", "01-4281666\n01-2111333");
        detailsList.add(details);

        details = new Details("Vinayak Hospital", "Gongabu Chowk, Kathmandu", "01-4383152");
        detailsList.add(details);


        recyclerViewAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setQueryHint("Search View");
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

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





