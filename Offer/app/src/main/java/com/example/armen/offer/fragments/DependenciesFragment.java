package com.example.armen.offer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.armen.offer.MessageActivity;
import com.example.armen.offer.R;
import com.example.armen.offer.models.UserModel;
import com.example.armen.offer.provider.AllProvider;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DependenciesFragment extends Fragment {

    public DependenciesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dependencies, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(MessageActivity.DEP_KEY);
            final UserModel user = AllProvider.getUserPosition(userPosition);
            TextView depName = view.findViewById(R.id.dep_NameId);
            TextView depAge = view.findViewById(R.id.dep_age);
            TextView maritalStatus = view.findViewById(R.id.dep_marital);
            TextView dep = view.findViewById(R.id.dep_text_id);
            CircleImageView imageView = view.findViewById(R.id.depImageId);
            depName.setText(user.getName());
            dep.setText(user.getDescription());
            depAge.setText(String.valueOf(user.getAge()));
            maritalStatus.setText(user.getMaritalStatus());
            Picasso.get()
                    .load(user.getImageUrl())
                    .placeholder(R.drawable.ic_broken_image_24dp)
                    .into(imageView);
        }

        return view;
    }
}
