package com.example.ipclawawareness;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CaseFragment extends Fragment {

    private EditText complainantNameEditText, complainantPhoneEditText, complainantAddressEditText;
    private EditText accusedNameEditText, caseTitleEditText, ipcSectionEditText, caseDescriptionEditText;
    private Button submitCaseButton;
    private DatabaseReference mDatabase;

    public CaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_case, container, false);

        // Test Firebase connection
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference testRef = database.getReference("testConnection");
            testRef.setValue("Testing connection at " + new Date().toString())
                    .addOnSuccessListener(aVoid -> Log.d("Firebase", "Connection successful"))
                    .addOnFailureListener(e -> Log.e("Firebase", "Connection failed: " + e.getMessage()));
        } catch (Exception e) {
            Log.e("Firebase", "Initialization error: " + e.getMessage());
        }

        // ... rest of your code
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Initialize views
        complainantNameEditText = view.findViewById(R.id.complainantNameEditText);
        complainantPhoneEditText = view.findViewById(R.id.complainantPhoneEditText);
        complainantAddressEditText = view.findViewById(R.id.complainantAddressEditText);
        accusedNameEditText = view.findViewById(R.id.accusedNameEditText);
        caseTitleEditText = view.findViewById(R.id.caseTitleEditText);
        ipcSectionEditText = view.findViewById(R.id.ipcSectionEditText);
        caseDescriptionEditText = view.findViewById(R.id.caseDescriptionEditText);
        submitCaseButton = view.findViewById(R.id.submitCaseButton);

        submitCaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCase();
            }
        });

        return view;
    }

    private void registerCase() {
        String complainantName = complainantNameEditText.getText().toString().trim();
        String complainantPhone = complainantPhoneEditText.getText().toString().trim();
        String complainantAddress = complainantAddressEditText.getText().toString().trim();
        String accusedName = accusedNameEditText.getText().toString().trim();
        String caseTitle = caseTitleEditText.getText().toString().trim();
        String ipcSection = ipcSectionEditText.getText().toString().trim();
        String caseDescription = caseDescriptionEditText.getText().toString().trim();

        // Basic validation
        if (complainantName.isEmpty()) {
            complainantNameEditText.setError("Name is required");
            complainantNameEditText.requestFocus();
            return;
        }

        if (complainantPhone.isEmpty() || complainantPhone.length() < 10) {
            complainantPhoneEditText.setError("Valid phone number is required");
            complainantPhoneEditText.requestFocus();
            return;
        }

        if (complainantAddress.isEmpty()) {
            complainantAddressEditText.setError("Address is required");
            complainantAddressEditText.requestFocus();
            return;
        }

        if (caseTitle.isEmpty()) {
            caseTitleEditText.setError("Case title is required");
            caseTitleEditText.requestFocus();
            return;
        }

        if (caseDescription.isEmpty()) {
            caseDescriptionEditText.setError("Case description is required");
            caseDescriptionEditText.requestFocus();
            return;
        }

        // Get current user ID
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(getContext(), "User not logged in", Toast.LENGTH_SHORT).show();
            return;
        }

        String userId = currentUser.getUid();
        DatabaseReference casesRef = FirebaseDatabase.getInstance().getReference("cases");
        String caseId = casesRef.push().getKey();

        String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        // Create case object
        Map<String, Object> caseMap = new HashMap<>();
        caseMap.put("complainantName", complainantName);
        caseMap.put("complainantPhone", complainantPhone);
        caseMap.put("complainantAddress", complainantAddress);
        caseMap.put("accusedName", accusedName);
        caseMap.put("caseTitle", caseTitle);
        caseMap.put("ipcSection", ipcSection);
        caseMap.put("caseDescription", caseDescription);
        caseMap.put("userId", userId);
        caseMap.put("date", date);
        caseMap.put("status", "Filed"); // Changed from "Pending" to "Filed"

        // Save to Firebase
        if (caseId != null) {
            casesRef.child(caseId).setValue(caseMap)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Case registered successfully", Toast.LENGTH_SHORT).show();
                            clearForm();
                        } else {
                            // Show the actual error message
                            String errorMessage = "Failed: " + (task.getException() != null ?
                                    task.getException().getMessage() : "Unknown error");
                            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
                            Log.e("CaseRegistration", "Error: ", task.getException());
                        }
                    });
        }
    }

    private void clearForm() {
        complainantNameEditText.setText("");
        complainantPhoneEditText.setText("");
        complainantAddressEditText.setText("");
        accusedNameEditText.setText("");
        caseTitleEditText.setText("");
        ipcSectionEditText.setText("");
        caseDescriptionEditText.setText("");
    }
}
