package com.example.armen.offer;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.armen.offer.adapters.PagerAdapter;
import com.example.armen.offer.fragments.CallFragment;
import com.example.armen.offer.fragments.MileFragment;
import com.example.armen.offer.fragments.UserFragment;

import java.util.Objects;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tab);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UserFragment(), "User");
        adapter.addFragment(new CallFragment(), "Call");
        adapter.addFragment(new MileFragment(), "E-miles");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_contacts_24dp);
            Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_contact_phone_24dp);
            Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.ic_contact_mail_24dp);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(UserActivity.this, R.color.offer_color));
        }
    }
}
