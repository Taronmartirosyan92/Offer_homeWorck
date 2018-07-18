package com.example.armen.offer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.armen.offer.MessageActivity;
import com.example.armen.offer.R;
import com.example.armen.offer.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    public static final String USER_POSITION = "user position";
    public static final String CHECK_KEY = "check key";
    private Context context;
    private List<UserModel> userList;

    public UsersAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UserViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        UserModel userModel = userList.get(position);
        holder.userName.setText(userModel.getName());
        holder.userStatus.setText(userModel.getStatus());
        Picasso.get()
                .load(userModel.getImageUrl())
                .placeholder(R.drawable.ic_broken_image_24dp)
                .into(holder.userImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra(USER_POSITION, position);
                intent.putExtra(CHECK_KEY, "user");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userStatus;
        CircleImageView userImage;

        UserViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userStatus = itemView.findViewById(R.id.userStatus);
            userImage = itemView.findViewById(R.id.userImage);
        }
    }
}
