package com.example.ipclawawareness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LawsAdapter extends RecyclerView.Adapter<LawsAdapter.LawViewHolder> {

    private List<Law> lawList;

    public LawsAdapter(List<Law> lawList) {
        this.lawList = lawList;
    }

    @NonNull
    @Override
    public LawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_law, parent, false);
        return new LawViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LawViewHolder holder, int position) {
        Law law = lawList.get(position);
        holder.sectionTextView.setText(law.getSection());
        holder.titleTextView.setText(law.getTitle());
        holder.descriptionTextView.setText(law.getDescription());
    }

    @Override
    public int getItemCount() {
        return lawList.size();
    }

    static class LawViewHolder extends RecyclerView.ViewHolder {
        TextView sectionTextView, titleTextView, descriptionTextView;

        public LawViewHolder(@NonNull View itemView) {
            super(itemView);
            sectionTextView = itemView.findViewById(R.id.sectionTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
