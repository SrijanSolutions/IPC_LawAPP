package com.example.ipclawawareness;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CourtsAdapter extends RecyclerView.Adapter<CourtsAdapter.CourtViewHolder> {

    private List<Court> courtList;

    public CourtsAdapter(List<Court> courtList) {
        this.courtList = courtList;
    }

    @NonNull
    @Override
    public CourtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_court, parent, false);
        return new CourtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourtViewHolder holder, int position) {
        Court court = courtList.get(position);
        holder.nameTextView.setText(court.getName());
        holder.addressTextView.setText(court.getAddress());
        holder.timingsTextView.setText(court.getTimings());
        holder.phoneTextView.setText(court.getPhone());

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + court.getPhone()));
                v.getContext().startActivity(intent);
            }
        });

        holder.mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open address in maps
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + court.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                v.getContext().startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courtList.size();
    }

    static class CourtViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, addressTextView, timingsTextView, phoneTextView;
        Button callButton, mapButton;

        public CourtViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            timingsTextView = itemView.findViewById(R.id.timingsTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            callButton = itemView.findViewById(R.id.callButton);
            mapButton = itemView.findViewById(R.id.mapButton);
        }
    }
}
