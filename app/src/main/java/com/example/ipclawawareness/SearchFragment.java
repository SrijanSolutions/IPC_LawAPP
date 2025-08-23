package com.example.ipclawawareness;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private EditText searchEditText;
    private Button searchButton;
    private RecyclerView searchResultsRecyclerView;
    private LawsAdapter lawsAdapter;
    private List<Law> allLaws;
    private List<Law> filteredLaws;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchEditText = view.findViewById(R.id.searchEditText);
        searchButton = view.findViewById(R.id.searchButton);
        searchResultsRecyclerView = view.findViewById(R.id.searchResultsRecyclerView);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize with all laws (you can fetch from Firebase if you have a large dataset)
        allLaws = new ArrayList<>();
        allLaws.add(new Law("Section 100", "Right of Private Defence", "The right of private defence of body extends to causing death against acts reasonably causing apprehension of death or grievous hurt."));
        allLaws.add(new Law("Section 101", "Right of Private Defence of Property", "Extends to causing death when robbery, house-breaking, theft, or mischief causes reasonable apprehension of death or grievous hurt."));
        allLaws.add(new Law("Section 103", "Murder", "Whoever commits murder shall be punished with death or imprisonment for life, and shall also be liable to fine."));
        allLaws.add(new Law("Section 104", "Culpable Homicide not Amounting to Murder", "Whoever commits culpable homicide not amounting to murder shall be punished with imprisonment for life or up to 10 years, and fine."));
        allLaws.add(new Law("Section 106", "Death by Negligence", "Whoever causes death by rash or negligent act not amounting to culpable homicide shall be punished with imprisonment up to 5 years or fine, or both."));
        allLaws.add(new Law("Section 109", "Voluntarily Causing Hurt", "Whoever causes hurt voluntarily shall be punished with imprisonment up to 1 year or fine up to ₹1000, or both."));
        allLaws.add(new Law("Section 110", "Grievous Hurt", "Whoever causes grievous hurt shall be punished with imprisonment up to 7 years and fine."));
        allLaws.add(new Law("Section 112", "Wrongful Restraint", "Whoever wrongfully restrains any person shall be punished with imprisonment up to 1 month or fine up to ₹500, or both."));
        allLaws.add(new Law("Section 113", "Wrongful Confinement", "Whoever wrongfully confines any person shall be punished with imprisonment up to 1 year or fine up to ₹1000, or both."));
        allLaws.add(new Law("Section 117", "Rape", "Whoever commits rape shall be punished with rigorous imprisonment not less than 10 years which may extend to life imprisonment, and fine."));
        allLaws.add(new Law("Section 118", "Gang Rape", "Where rape is committed by one or more persons in a group, each shall be punished with rigorous imprisonment for life or death, and fine."));
        allLaws.add(new Law("Section 119", "Kidnapping", "Whoever kidnaps any person shall be punished with imprisonment up to 7 years and fine."));
        allLaws.add(new Law("Section 121", "Theft", "Whoever commits theft shall be punished with imprisonment up to 3 years or fine, or both."));
        allLaws.add(new Law("Section 123", "Robbery", "Whoever commits robbery shall be punished with rigorous imprisonment up to 10 years and fine."));
        allLaws.add(new Law("Section 124", "Dacoity", "When five or more persons commit robbery, each shall be punished with imprisonment for life or rigorous imprisonment up to 10 years and fine."));
        allLaws.add(new Law("Section 126", "Criminal Breach of Trust", "Whoever commits criminal breach of trust shall be punished with imprisonment up to 3 years or fine, or both."));
        allLaws.add(new Law("Section 127", "Cheating", "Whoever cheats shall be punished with imprisonment up to 1 year or fine, or both."));
        allLaws.add(new Law("Section 133", "Forgery", "Whoever forges any document shall be punished with imprisonment up to 2 years or fine, or both."));
        allLaws.add(new Law("Section 134", "Counterfeiting", "Whoever counterfeits any currency note or bank note shall be punished with imprisonment for life or up to 10 years and fine."));
        allLaws.add(new Law("Section 135", "Criminal Intimidation", "Whoever threatens another shall be punished with imprisonment up to 2 years or fine, or both."));       filteredLaws = new ArrayList<>(allLaws);
        lawsAdapter = new LawsAdapter(filteredLaws);
        searchResultsRecyclerView.setAdapter(lawsAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                performSearch();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }

    private void performSearch() {
        String query = searchEditText.getText().toString().toLowerCase().trim();
        filteredLaws.clear();

        if (query.isEmpty()) {
            filteredLaws.addAll(allLaws);
        } else {
            for (Law law : allLaws) {
                if (law.getSection().toLowerCase().contains(query) ||
                        law.getTitle().toLowerCase().contains(query) ||
                        law.getDescription().toLowerCase().contains(query)) {
                    filteredLaws.add(law);
                }
            }
        }

        lawsAdapter.notifyDataSetChanged();
    }
}