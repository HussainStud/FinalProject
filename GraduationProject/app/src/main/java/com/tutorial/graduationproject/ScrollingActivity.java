package com.tutorial.graduationproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorial.graduationproject.Models.ProfileModel;
import com.tutorial.graduationproject.databinding.ActivityScrollingBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;



        CircleImageView profileImageView = findViewById(R.id.scrollable_profile_imageView);
        ImageView complementartImageView = findViewById(R.id.scrollable_complementrary_imageView);
        TextView scrollTextView = findViewById(R.id.scrollable_textView);
        TextView scrollNameTextView = findViewById(R.id.scrollable_name_textView);

        Bundle bundle = getIntent().getExtras();
        ProfileModel currentProfile = (ProfileModel) bundle.getSerializable("PROFILE");
        toolBarLayout.setTitle(currentProfile.getProfileTitle());
        scrollTextView.setText(currentProfile.getProfileLongDescription());
        scrollNameTextView.setText(currentProfile.getProfileName());
        complementartImageView.setImageResource(currentProfile.getComplementaryImage());
        profileImageView.setImageResource(currentProfile.getProfileImage());


        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int contactPhoneNumber = currentProfile.getContactPhoneNumber();
                boolean hasWhatsappInstalled = true;

                if(hasWhatsappInstalled) {
                    Uri uri = Uri.parse("smsto:" + contactPhoneNumber);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "You don't have Whatsapp installed!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean hasAppInstalled(String appUrl) {
        PackageManager packageManager = getPackageManager();
        boolean appInstalled;
        try {
            packageManager.getPackageInfo(appUrl, PackageManager.GET_ACTIVITIES);
            appInstalled = true;
        } catch (PackageManager.NameNotFoundException e) {

            appInstalled = false;
        }

        return appInstalled;
    }

}