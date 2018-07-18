package com.example.armen.offer.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.armen.offer.MessageActivity;
import com.example.armen.offer.R;
import com.example.armen.offer.adapters.MessageAdapter;
import com.example.armen.offer.models.MessageModel;
import com.example.armen.offer.models.UserModel;
import com.example.armen.offer.provider.AllProvider;

import java.util.List;

public class MessageFragment extends Fragment {

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(MessageActivity.MESS_KEY);
            final UserModel user = AllProvider.getUserPosition(userPosition);
            initializeMessagesList(view, user);
        }
        return view;
    }

    private void initializeMessagesList(View view, UserModel user) {
        final RecyclerView messagesList = view.findViewById(R.id.message_list);
        messagesList.setHasFixedSize(true);
        final LinearLayoutManager manager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messagesList.setLayoutManager(manager);
        final List<MessageModel> messages = user.getMessages();
        final MessageAdapter adapter = new MessageAdapter(getContext(), messages, user.getImageUrl());
        messagesList.setAdapter(adapter);
        final EditText edt = view.findViewById(R.id.edt);
        final ImageButton send = view.findViewById(R.id.send_button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.add(new MessageModel(edt.getText().toString(), true));
                messages.add(new MessageModel("bravo!!!", false));
                edt.setText("");
                adapter.notifyDataSetChanged();
                messagesList.scrollToPosition(messages.size() - 1);
            }
        });
    }
}
