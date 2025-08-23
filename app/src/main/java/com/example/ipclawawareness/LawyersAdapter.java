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

public class LawyersAdapter extends RecyclerView.Adapter<LawyersAdapter.LawyerViewHolder> {

    private List<Lawyer> lawyerList;

    public LawyersAdapter(List<Lawyer> lawyerList) {
        this.lawyerList = lawyerList;
    }

    @NonNull
    @Override
    public LawyerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lawyer, parent, false);
        return new LawyerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LawyerViewHolder holder, int position) {
        Lawyer lawyer = lawyerList.get(position);
        holder.nameTextView.setText(lawyer.getName());
        holder.specializationTextView.setText(lawyer.getSpecialization());
        holder.experienceTextView.setText(lawyer.getExperience());
        holder.phoneTextView.setText(lawyer.getPhone());
        holder.emailTextView.setText(lawyer.getEmail());

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + lawyer.getPhone()));
                v.getContext().startActivity(intent);
            }
        });

        holder.emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + lawyer.getEmail()));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lawyerList.size();
    }

    static class LawyerViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, specializationTextView, experienceTextView, phoneTextView, emailTextView;
        Button callButton, emailButton;

        public LawyerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            specializationTextView = itemView.findViewById(R.id.specializationTextView);
            experienceTextView = itemView.findViewById(R.id.experienceTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            callButton = itemView.findViewById(R.id.callButton);
            emailButton = itemView.findViewById(R.id.emailButton);
        }
    }
}
