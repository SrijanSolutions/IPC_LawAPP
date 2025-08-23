package com.example.ipclawawareness;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class LawyersFragment extends Fragment {

    private RecyclerView lawyersRecyclerView;
    private LawyersAdapter lawyersAdapter;
    private List<Lawyer> lawyerList;

    public LawyersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lawyers, container, false);

        lawyersRecyclerView = view.findViewById(R.id.lawyersRecyclerView);
        lawyersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        lawyerList = new ArrayList<>();
        // Add sample lawyers (you can fetch from Firebase in a real app)
        lawyerList.add(new Lawyer("Adv. Ramesh Kumar", "Criminal Law", "10 years", "9876543210", "ramesh@lawyer.com"));
        lawyerList.add(new Lawyer("Adv. Priya Sharma", "Family Law", "8 years", "8765432109", "priya@lawyer.com"));
        lawyerList.add(new Lawyer("Adv. Amit Patel", "Corporate Law", "15 years", "7654321098", "amit@lawyer.com"));
        lawyerList.add(new Lawyer("Adv. Sneha Gupta", "Property Law", "7 years", "6543210987", "sneha@lawyer.com"));

        lawyersAdapter = new LawyersAdapter(lawyerList);
        lawyersRecyclerView.setAdapter(lawyersAdapter);

        return view;
    }
}