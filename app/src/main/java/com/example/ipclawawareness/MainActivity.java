package com.example.ipclawawareness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.ipclawawareness.CaseFragment;
import com.example.ipclawawareness.CaseStatusFragment;
import com.example.ipclawawareness.ChatFragment;
import com.example.ipclawawareness.CourtsFragment;
import com.example.ipclawawareness.LawsFragment;
import com.example.ipclawawareness.LawyersFragment;
import com.example.ipclawawareness.R;
import com.example.ipclawawareness.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new LawsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int itemId = item.getItemId();

                    if (itemId == R.id.nav_laws) {
                        selectedFragment = new LawsFragment();
                    } else if (itemId == R.id.nav_search) {
                        selectedFragment = new SearchFragment();
                    } else if (itemId == R.id.nav_lawyers) {
                        selectedFragment = new LawyersFragment();
                    } else if (itemId == R.id.nav_case) {
                        selectedFragment = new CaseFragment();
                    } else if (itemId == R.id.nav_more) {
                        showMoreOptionsMenu();
                        return true; // Don't change fragment
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }

                    return true;
                }
            };

    private void showMoreOptionsMenu() {
        PopupMenu popup = new PopupMenu(this, findViewById(R.id.nav_more));
        popup.getMenuInflater().inflate(R.menu.more_options_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.nav_courts) {
                    selectedFragment = new CourtsFragment();
                } else if (itemId == R.id.nav_chat) {
                    selectedFragment = new ChatFragment();
                } else if (itemId == R.id.nav_status) {
                    selectedFragment = new CaseStatusFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    // Update the selected item in bottom navigation
                    bottomNavigationView.setSelectedItemId(R.id.nav_more);
                }

                return true;
            }
        });

        popup.show();
    }
}





