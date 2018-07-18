package com.example.armen.offer.adapters;

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

import com.example.armen.offer.R;
import com.example.armen.offer.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmileAdapter extends RecyclerView.Adapter<EmileAdapter.EmileViewHolder> {
    private Context context;
    private List<UserModel> emileList;

    public EmileAdapter(Context context, List<UserModel> emileList) {
        this.context = context;
        this.emileList = emileList;
    }

    @NonNull
    @Override
    public EmileAdapter.EmileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.emile_item, parent, false);

        return new EmileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EmileAdapter.EmileViewHolder holder, int position) {
        final UserModel userModel = emileList.get(position);
        holder.userName.setText(userModel.getName());
        holder.userEmile.setText(userModel.getEmail());
        Picasso.get()
                .load(userModel.getImageUrl())
                .placeholder(R.drawable.ic_broken_image_24dp)
                .into(holder.userImage);
        holder.emileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emilIntent = new Intent(Intent.ACTION_SENDTO);
                emilIntent.setType("application/octet-stream");
                emilIntent.setData(Uri.parse("mailto:" + userModel.getEmail()));
                context.startActivity(Intent.createChooser(emilIntent, "Send mail"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return emileList.size();
    }

    class EmileViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userEmile;
        CircleImageView userImage;
        ImageButton emileButton;

        EmileViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.emile_name);
            userEmile = itemView.findViewById(R.id.emile_id);
            userImage = itemView.findViewById(R.id.emile_image);
            emileButton = itemView.findViewById(R.id.emile_button);
        }
    }
}
