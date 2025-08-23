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

public class CourtsFragment extends Fragment {

    private RecyclerView courtsRecyclerView;
    private CourtsAdapter courtsAdapter;
    private List<Court> courtList;

    public CourtsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courts, container, false);

        courtsRecyclerView = view.findViewById(R.id.courtsRecyclerView);
        courtsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        courtList = new ArrayList<>();
        // Add sample courts (you can fetch from Firebase in a real app)
        courtList.add(new Court("Delhi High Court", "Sher Shah Road, New Delhi", "10:00 AM - 5:00 PM", "011-23235555"));
        courtList.add(new Court("Bombay High Court", "Fort, Mumbai", "10:30 AM - 5:30 PM", "022-22621111"));
        courtList.add(new Court("Kolkata High Court", "Esplanade, Kolkata", "10:00 AM - 5:00 PM", "033-22486300"));
        courtList.add(new Court("Chennai High Court", "Parry's Corner, Chennai", "10:00 AM - 5:00 PM", "044-25340500"));

        courtsAdapter = new CourtsAdapter(courtList);
        courtsRecyclerView.setAdapter(courtsAdapter);

        return view;
    }
}