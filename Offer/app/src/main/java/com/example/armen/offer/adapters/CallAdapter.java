package com.example.armen.offer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.armen.offer.MessageActivity;
import com.example.armen.offer.R;
import com.example.armen.offer.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.CallViewHolder> {
    private Context context;
    private List<UserModel> callList;
    public static final String CALL_POSITION = "call position";
    public static final String CHECK_KEY = "check key";

    public CallAdapter(Context context, List<UserModel> callList) {
        this.context = context;
        this.callList = callList;
    }

    @NonNull
    @Override
    public CallAdapter.CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.call_item, parent, false);

        return new CallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallAdapter.CallViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final UserModel userModel = callList.get(position);
        holder.userName.setText(userModel.getName());
        holder.userNumber.setText(userModel.getPhone());
        Picasso.get()
                .load(userModel.getImageUrl())
                .placeholder(R.drawable.ic_broken_image_24dp)
                .into(holder.userImage);
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + userModel.getPhone()));
                context.startActivity(callIntent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra(CALL_POSITION, position);
                intent.putExtra(CHECK_KEY, "call");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return callList.size();
    }

    class CallViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userNumber;
        CircleImageView userImage;
        ImageButton phone;

        CallViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.call_name_id);
            userNumber = itemView.findViewById(R.id.call_number_id);
            userImage = itemView.findViewById(R.id.call_image_id);
            phone = itemView.findViewById(R.id.phone_id);
        }
    }
}
