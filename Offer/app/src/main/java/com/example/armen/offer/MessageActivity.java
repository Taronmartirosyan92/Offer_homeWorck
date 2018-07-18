package com.example.armen.offer;


import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.armen.offer.adapters.CallAdapter;
import com.example.armen.offer.adapters.UsersAdapter;
import com.example.armen.offer.fragments.DependenciesFragment;
import com.example.armen.offer.fragments.MessageFragment;
import com.example.armen.offer.models.UserModel;
import com.example.armen.offer.provider.AllProvider;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageActivity extends AppCompatActivity {
    public static final String MESS_KEY = "mess";
    public static final String DEP_KEY = "dep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initialization();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(
                    ContextCompat.getColor(MessageActivity.this, R.color.offer_color));
        }
    }

    private void initialization() {
        if (getIntent().getExtras().get(UsersAdapter.CHECK_KEY).equals("user")) {
            final int position = getIntent().getIntExtra(UsersAdapter.USER_POSITION, 0);
            final UserModel userModel = AllProvider.getUserPosition(position);
            TextView userName = findViewById(R.id.title_name);
            CircleImageView imageUrl = findViewById(R.id.message_image_title);
            userName.setText(userModel.getName());
            Picasso.get()
                    .load(userModel.getImageUrl())
                    .placeholder(R.drawable.ic_broken_image_24dp)
                    .into(imageUrl);
            MessageFragment messageFragment = new MessageFragment();
            final Bundle bundle = new Bundle();
            bundle.putInt(MESS_KEY, position);
            messageFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fr_container, messageFragment)
                    .commit();
        } else if (getIntent().getExtras().get(CallAdapter.CHECK_KEY).equals("call")) {
            final int position = getIntent().getIntExtra(CallAdapter.CALL_POSITION, 0);
            final UserModel userModel = AllProvider.getUserPosition(position);
            TextView userName = findViewById(R.id.title_name);
            CircleImageView imageUrl = findViewById(R.id.message_image_title);
            userName.setText(userModel.getName());
            Picasso.get()
                    .load(userModel.getImageUrl())
                    .placeholder(R.drawable.ic_broken_image_24dp)
                    .into(imageUrl);
            DependenciesFragment dp = new DependenciesFragment();
            final Bundle bundle = new Bundle();
            bundle.putInt(DEP_KEY, position);
            dp.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fr_container, dp)
                    .commit();
        }
    }
}


