package com.example.ipclawawareness;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipclawawareness.Law;
import com.example.ipclawawareness.LawsAdapter;

import java.util.ArrayList;
import java.util.List;

public class LawsFragment extends Fragment {

    private RecyclerView lawsRecyclerView;
    private LawsAdapter lawsAdapter;
    private List<Law> lawList;

    public LawsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laws, container, false);

        lawsRecyclerView = view.findViewById(R.id.lawsRecyclerView);
        lawsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        lawList = new ArrayList<>();

        // Add comprehensive BNS sections (replacing IPC)
        lawList.add(new Law("Section 100", "Right of Private Defence", "The right of private defence of body extends to causing death against acts reasonably causing apprehension of death or grievous hurt."));
        lawList.add(new Law("Section 101", "Right of Private Defence of Property", "Extends to causing death when robbery, house-breaking, theft, or mischief causes reasonable apprehension of death or grievous hurt."));
        lawList.add(new Law("Section 102", "Commencement and Continuance", "Right of private defence commences when reasonable apprehension of danger exists and continues as long as such apprehension exists."));

        lawList.add(new Law("Section 103", "Murder", "Whoever commits murder shall be punished with death or imprisonment for life, and shall also be liable to fine."));
        lawList.add(new Law("Section 104", "Culpable Homicide not Amounting to Murder", "Whoever commits culpable homicide not amounting to murder shall be punished with imprisonment for life or up to 10 years, and fine."));
        lawList.add(new Law("Section 105", "Punishment for Culpable Homicide", "Imprisonment for life or up to 10 years with fine, depending on the circumstances."));

        lawList.add(new Law("Section 106", "Death by Negligence", "Whoever causes death by rash or negligent act not amounting to culpable homicide shall be punished with imprisonment up to 5 years or fine, or both."));
        lawList.add(new Law("Section 107", "Attempt to Murder", "Whoever attempts to commit murder shall be punished with imprisonment up to 10 years and fine."));
        lawList.add(new Law("Section 108", "Attempt to Commit Culpable Homicide", "Imprisonment up to 7 years and fine."));

        lawList.add(new Law("Section 109", "Voluntarily Causing Hurt", "Whoever causes hurt voluntarily shall be punished with imprisonment up to 1 year or fine up to ₹1000, or both."));
        lawList.add(new Law("Section 110", "Grievous Hurt", "Whoever causes grievous hurt shall be punished with imprisonment up to 7 years and fine."));
        lawList.add(new Law("Section 111", "Dangerous Hurt", "Hurt which endangers life or causes severe bodily pain - imprisonment up to 10 years."));

        lawList.add(new Law("Section 112", "Wrongful Restraint", "Whoever wrongfully restrains any person shall be punished with imprisonment up to 1 month or fine up to ₹500, or both."));
        lawList.add(new Law("Section 113", "Wrongful Confinement", "Whoever wrongfully confines any person shall be punished with imprisonment up to 1 year or fine up to ₹1000, or both."));

        lawList.add(new Law("Section 114", "Criminal Force", "Whoever uses criminal force against any person shall be punished with imprisonment up to 3 months or fine up to ₹500, or both."));
        lawList.add(new Law("Section 115", "Assault", "Whoever makes any gesture or preparation to use criminal force shall be punished with imprisonment up to 3 months or fine up to ₹500, or both."));

        lawList.add(new Law("Section 116", "Sexual Offences", "Various provisions related to sexual crimes including rape, sexual assault, and harassment."));
        lawList.add(new Law("Section 117", "Rape", "Whoever commits rape shall be punished with rigorous imprisonment not less than 10 years which may extend to life imprisonment, and fine."));
        lawList.add(new Law("Section 118", "Gang Rape", "Where rape is committed by one or more persons in a group, each shall be punished with rigorous imprisonment for life or death, and fine."));

        lawList.add(new Law("Section 119", "Kidnapping", "Whoever kidnaps any person shall be punished with imprisonment up to 7 years and fine."));
        lawList.add(new Law("Section 120", "Abduction", "Whoever abducts any person shall be punished with imprisonment up to 7 years and fine."));

        lawList.add(new Law("Section 121", "Theft", "Whoever commits theft shall be punished with imprisonment up to 3 years or fine, or both."));
        lawList.add(new Law("Section 122", "Extortion", "Whoever commits extortion shall be punished with imprisonment up to 3 years or fine, or both."));
        lawList.add(new Law("Section 123", "Robbery", "Whoever commits robbery shall be punished with rigorous imprisonment up to 10 years and fine."));
        lawList.add(new Law("Section 124", "Dacoity", "When five or more persons commit robbery, each shall be punished with imprisonment for life or rigorous imprisonment up to 10 years and fine."));

        lawList.add(new Law("Section 125", "Criminal Misappropriation", "Whoever misappropriates property shall be punished with imprisonment up to 2 years or fine, or both."));
        lawList.add(new Law("Section 126", "Criminal Breach of Trust", "Whoever commits criminal breach of trust shall be punished with imprisonment up to 3 years or fine, or both."));

        lawList.add(new Law("Section 127", "Cheating", "Whoever cheats shall be punished with imprisonment up to 1 year or fine, or both."));
        lawList.add(new Law("Section 128", "Cheating with Knowledge", "If cheating causes wrongful loss or damage, imprisonment up to 3 years and fine."));

        lawList.add(new Law("Section 129", "Mischief", "Whoever commits mischief shall be punished with imprisonment up to 3 months or fine, or both."));
        lawList.add(new Law("Section 130", "Criminal Trespass", "Whoever enters into property unlawfully shall be punished with imprisonment up to 3 months or fine up to ₹500, or both."));

        lawList.add(new Law("Section 131", "House-Trespass", "Whoever commits criminal trespass in a building used as human dwelling shall be punished with imprisonment up to 1 year or fine up to ₹1000, or both."));
        lawList.add(new Law("Section 132", "Lurking House-Trespass", "Punishment up to 2 years and fine."));

        lawList.add(new Law("Section 133", "Forgery", "Whoever forges any document shall be punished with imprisonment up to 2 years or fine, or both."));
        lawList.add(new Law("Section 134", "Counterfeiting", "Whoever counterfeits any currency note or bank note shall be punished with imprisonment for life or up to 10 years and fine."));

        lawList.add(new Law("Section 135", "Criminal Intimidation", "Whoever threatens another shall be punished with imprisonment up to 2 years or fine, or both."));
        lawList.add(new Law("Section 136", "Attempt to Commit Suicide", "Whoever attempts to commit suicide shall be punished with simple imprisonment up to 1 year or fine, or both."));

        lawList.add(new Law("Section 137", "Abetment", "Whoever abets any offence shall be punished with the punishment provided for that offence."));
        lawList.add(new Law("Section 138", "Criminal Conspiracy", "When two or more persons agree to commit an illegal act, each shall be punished similarly to abetment."));

        lawList.add(new Law("Section 139", "Offences against State", "Various provisions related to sedition, waging war against government, etc."));
        lawList.add(new Law("Section 140", "Public Order Offences", "Offences relating to unlawful assembly, rioting, and affray."));

        lawsAdapter = new LawsAdapter(lawList);
        lawsRecyclerView.setAdapter(lawsAdapter);

        return view;
    }
}