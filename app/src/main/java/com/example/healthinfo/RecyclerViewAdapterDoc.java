package com.example.healthinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterDoc extends RecyclerView.Adapter<RecyclerViewAdapterDoc.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapterDoc";


    private ArrayList<String> DocImageNames = new ArrayList<>();
    private ArrayList<String> DoctorQualification = new ArrayList<>();
    private ArrayList<String> DocImages = new ArrayList<>();
    private ArrayList<String> DocPhone = new ArrayList<>();

    private Context DocContext;

    public RecyclerViewAdapterDoc(Context context, ArrayList<String> imageNames, ArrayList<String> images ,ArrayList<String>doctorQualification, ArrayList<String>doctorPhone) {
        DocImageNames = imageNames;
        DocImages = images;
        DoctorQualification = doctorQualification;
        DocPhone = doctorPhone;
        DocContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_doclist, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(DocContext)
                .asBitmap()
                .load(DocImages.get(position))
                .into(holder.image);

        holder.DocQualification.setText(DocImageNames.get(position));

        holder.parentLayoutdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + DocImageNames.get(position));

                Toast.makeText(DocContext, DocImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DocContext, DocProfile.class);
                intent.putExtra("image_url", DocImages.get(position));
                intent.putExtra("image_name", DocImageNames.get(position));
                intent.putExtra("image_qualification", DoctorQualification.get(position));
                intent.putExtra("doc_phone", DocPhone.get(position));
                DocContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DocImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView DocQualification;
        RelativeLayout parentLayoutdoc;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagedoc);
            DocQualification = itemView.findViewById(R.id.qualification);
            parentLayoutdoc = itemView.findViewById(R.id.parent_layoutdoc);
        }
    }
}
