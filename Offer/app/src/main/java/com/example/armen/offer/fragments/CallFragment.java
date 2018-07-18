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
import com.example.armen.offer.adapters.CallAdapter;
import com.example.armen.offer.provider.AllProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {

    public CallFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_call, container, false);

        final RecyclerView callList = view.findViewById(R.id.call_list);
        callList.setHasFixedSize(true);
        callList.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final CallAdapter adapter =
                new CallAdapter(getContext(), AllProvider.getListUsers());
        callList.setAdapter(adapter);

        return view;
    }
}
