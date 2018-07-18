package com.example.armen.offer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.armen.offer.R;
import com.example.armen.offer.adapters.EmileAdapter;
import com.example.armen.offer.adapters.UsersAdapter;
import com.example.armen.offer.provider.AllProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class MileFragment extends Fragment {


    public MileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_mile, container, false);
        final RecyclerView usersList = view.findViewById(R.id.mil_list);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final EmileAdapter adapter = new EmileAdapter(getContext(), AllProvider.getListUsers());
        usersList.setAdapter(adapter);

        return view;
    }
}
