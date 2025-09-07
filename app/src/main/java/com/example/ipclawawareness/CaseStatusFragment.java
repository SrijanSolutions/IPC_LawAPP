package com.example.ipclawawareness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CaseStatusFragment extends Fragment {

    private RecyclerView caseStatusRecyclerView;
    private CaseStatusAdapter caseStatusAdapter;
    private List<Case> caseList;

    private DatabaseReference casesRef;
    private FirebaseAuth mAuth;

    public CaseStatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_case_status, container, false);

        caseStatusRecyclerView = view.findViewById(R.id.caseStatusRecyclerView);
        caseStatusRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        caseList = new ArrayList<>();
        caseStatusAdapter = new CaseStatusAdapter(caseList);
        caseStatusRecyclerView.setAdapter(caseStatusAdapter);

        mAuth = FirebaseAuth.getInstance();
        String currentUserId = mAuth.getCurrentUser().getUid();

        casesRef = FirebaseDatabase.getInstance().getReference("cases");
        casesRef.orderByChild("userId").equalTo(currentUserId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        caseList.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Case caseItem = snapshot.getValue(Case.class);
                            caseList.add(caseItem);
                        }
                        caseStatusAdapter.notifyDataSetChanged();

                        if (caseList.isEmpty()) {
                            Toast.makeText(getContext(), "No cases found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getContext(), "Failed to load cases: " + databaseError.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

        return view;
    }
}