package com.tutorial.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.tutorial.graduationproject.Adapters.ProfilesArrayAdapter;
import com.tutorial.graduationproject.Models.ProfileModel;


import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<ProfileModel> profileList = new ArrayList<>();
//    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //setting up toolbar
//        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        Toolbar toolbar = binding.toolbar;
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
//        toolBarLayout.setTitle(getString(R.string.app_name_i_think));


        ListView profilesListView = findViewById(R.id.profiles_list_view);
        SearchView searchView = findViewById(R.id.home_searchView);
        String[] nameList = {"Electric Engineering", "Computer Engineering", "Medicine", "Pharmacy", "High-School Student"};

        ProfileModel profile1_Ahmed_Shakir = new ProfileModel(getString(R.string.electric_eng), getString(R.string.ahmed_shakir), "The best student at his Year", getString(R.string.electric_engineering_string),
                R.drawable.profile_1, R.drawable.electric_engineer, 66080661);
        profileList.add(profile1_Ahmed_Shakir);

        ProfileModel profile2_Abdulah_Ramadan = new ProfileModel("Computer Engineering", "Abdulah Ramadan", "He achieved more than his tutors", getString(R.string.computer_engineering_string),
                R.drawable.profile_2, R.drawable.graduation_throwing_hats, 66080661);
        profileList.add(profile2_Abdulah_Ramadan);

        ProfileModel profile3_drAli_Dawood = new ProfileModel("Medicine", "Dr.Ali Dawood", "He is but a small boy", getString(R.string.medical_string),
                R.drawable.profile_3, R.drawable.medical_hospital, 66080661);
        profileList.add(profile3_drAli_Dawood);

        ProfileModel profile4_drAmmar_Adel = new ProfileModel("Pharmacist", "Dr.Ammar Adel", "He is but a small boy", getString(R.string.medical_string),
                R.drawable.profile_4, R.drawable.pharamasics, 66080661);
        profileList.add(profile4_drAmmar_Adel);

        ProfileModel profile5_Hussain_Ghloum = new ProfileModel("High School Student", "Hussain Ghloum", "He is but a small boy", getString(R.string.high_school_string),
                R.drawable.profile_5, R.drawable.graduation_hat, 66080661);
        profileList.add(profile5_Hussain_Ghloum);

        ProfilesArrayAdapter profileListAdapter = new ProfilesArrayAdapter(this, 0, profileList);

        profilesListView.setAdapter(profileListAdapter);


        profilesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this, ScrollingActivity.class);
                intent.putExtra("PROFILE", profileList.get(i));


                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                profileListAdapter.getFilter().filter(s);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                profileListAdapter.getFilter().filter(s);
                return false;
            }
        });

    }
}