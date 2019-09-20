package com.example.healthinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AmbulanceRecyclerViewAdapter extends RecyclerView.Adapter<AmbulanceRecyclerViewAdapter.MyViewHolder> implements  Filterable {
    Context context;
    private List<Details> ambulancelists;
    private List<Details> listFull;
    ImageView imageView;



    public AmbulanceRecyclerViewAdapter(List<Details> ambulancelists) {
        this.ambulancelists = ambulancelists;
        this.listFull = ambulancelists;

    }



    @NonNull
    @Override
    public AmbulanceRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.details, parent, false);



        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AmbulanceRecyclerViewAdapter.MyViewHolder myViewHolder, int position) {
        Details details = ambulancelists.get(position);
        myViewHolder.textView_title.setText(details.getTitle());
        myViewHolder.textView_location.setText(details.getLocation());
        myViewHolder.textView_contact.setText(details.getContact());

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_title;
        private TextView textView_location;
        private TextView textView_contact;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView_title = itemView.findViewById(R.id.title);
            textView_location = itemView.findViewById(R.id.location);
            textView_contact = itemView.findViewById(R.id.contact);


        }


    }




    @Override
    public int getItemCount() {
        return listFull.size();
    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Details> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Details item : listFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    if (item.getLocation().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }

                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ambulancelists.clear();
            ambulancelists.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };




}






