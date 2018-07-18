package com.example.armen.offer.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.armen.offer.MessageActivity;
import com.example.armen.offer.R;
import com.example.armen.offer.fragments.DependenciesFragment;
import com.example.armen.offer.models.MessageModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MessageModel> listMs;
    private String userImageUrl;

    public MessageAdapter(Context context, List<MessageModel> listMs, String userImageUrl) {
        this.context = context;
        this.listMs = listMs;
        this.userImageUrl = userImageUrl;
    }

    @Override
    public int getItemViewType(int position) {
        final MessageModel modelMs = listMs.get(position);
        if (modelMs.isMine()) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (0 == viewType) {
            assert inflater != null;
            view = inflater.inflate(R.layout.send_message_item, parent, false);
            return new SendViewHolder(view);
        }
        assert inflater != null;
        view = inflater.inflate(R.layout.receive_message_item, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MessageModel model = listMs.get(position);
        if (model.isMine()) {
            ((SendViewHolder) holder).bind(model);
        } else {
            ((ReceiveViewHolder) holder).bind(model);

        }
    }

    @Override
    public int getItemCount() {
        return listMs.size();
    }

    private class SendViewHolder extends RecyclerView.ViewHolder {
        TextView myMessage;

        SendViewHolder(View itemView) {
            super(itemView);
            myMessage = itemView.findViewById(R.id.my_message);
        }

        void bind(MessageModel message) {
            myMessage.setText(message.getText());
        }
    }

    private class ReceiveViewHolder extends RecyclerView.ViewHolder {
        TextView receiveName;
        TextView receiveMessage;
        CircleImageView userImage;

        ReceiveViewHolder(View itemView) {
            super(itemView);
            receiveName = itemView.findViewById(R.id.receive_name);
            receiveMessage = itemView.findViewById(R.id.receive_message);
            userImage = itemView.findViewById(R.id.receive_img);
            final int position = ((MessageActivity) context)
                    .getIntent().getIntExtra(UsersAdapter.USER_POSITION, 0);
            userImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DependenciesFragment dp = new DependenciesFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("dep", position);
                    dp.setArguments(bundle);
                    ((MessageActivity) context).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fr_container, dp)
                            .commit();
                }
            });
        }

        void bind(MessageModel message) {
            receiveMessage.setText(message.getText());
            Picasso.get()
                    .load(userImageUrl)
                    .placeholder(R.drawable.ic_broken_image_24dp)
                    .into(userImage);
            receiveName.setText(message.getName());
        }
    }
}
