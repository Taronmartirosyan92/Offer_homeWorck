package com.example.armen.offer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.armen.offer.R;
import com.example.armen.offer.adapters.UsersAdapter;
import com.example.armen.offer.provider.AllProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_user, container, false);

        final RecyclerView usersList = view.findViewById(R.id.users_list);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final UsersAdapter adapter =
                new UsersAdapter(getContext(), AllProvider.getListUsers());
        usersList.setAdapter(adapter);

        return view;
    }
}
