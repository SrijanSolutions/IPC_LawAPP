package com.example.ipclawawareness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CaseStatusAdapter extends RecyclerView.Adapter<CaseStatusAdapter.ViewHolder> {

    private List<Case> caseList;

    public CaseStatusAdapter(List<Case> caseList) {
        this.caseList = caseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_case_status, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Case caseItem = caseList.get(position);

        holder.caseTitleTextView.setText(caseItem.getCaseTitle());
        holder.caseDateTextView.setText("Date: " + caseItem.getDate());
        holder.caseStatusTextView.setText(caseItem.getStatus());

        // Set progress based on status
        int progress = 0;
        switch (caseItem.getStatus()) {
            case "Filed":
                progress = 25;
                break;
            case "Under Review":
                progress = 50;
                break;
            case "In Progress":
                progress = 75;
                break;
            case "Resolved":
                progress = 100;
                break;
        }
        holder.caseProgressBar.setProgress(progress);
    }

    @Override
    public int getItemCount() {
        return caseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView caseTitleTextView, caseDateTextView, caseStatusTextView;
        ProgressBar caseProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caseTitleTextView = itemView.findViewById(R.id.caseTitleTextView);
            caseDateTextView = itemView.findViewById(R.id.caseDateTextView);
            caseStatusTextView = itemView.findViewById(R.id.caseStatusTextView);
            caseProgressBar = itemView.findViewById(R.id.caseProgressBar);
        }
    }
}