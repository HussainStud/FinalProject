package com.tutorial.graduationproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tutorial.graduationproject.Models.ProfileModel;
import com.tutorial.graduationproject.R;

import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfilesArrayAdapter extends ArrayAdapter<ProfileModel> implements Filterable {

    List<ProfileModel> profileList;
    public ProfilesArrayAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        profileList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View currentView, @NonNull ViewGroup parent) {

        currentView = LayoutInflater.from(getContext()).inflate(R.layout.student_list_item, parent, false);

        TextView profileTitleTextView = currentView.findViewById(R.id.list_item_title);
        TextView profileNameTextView = currentView.findViewById(R.id.list_item_name);
        TextView profileSmallDescriptionTextView = currentView.findViewById(R.id.list_item_description);
        CircleImageView profileImageImageView = currentView.findViewById(R.id.profile_image);

        ProfileModel currentProfile = profileList.get(position);

        profileTitleTextView.setText(currentProfile.getProfileTitle());
        profileNameTextView.setText(currentProfile.getProfileName());
        profileSmallDescriptionTextView.setText(currentProfile.getProfileSmallDescription());
        profileImageImageView.setImageResource(currentProfile.getProfileImage());

        return currentView;
    }


}
