package com.example.armen.offer.welcome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.armen.offer.R;

import java.util.List;

public class WelcomeViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<WelcomeModel> list;

    WelcomeViewPagerAdapter(Context context, List<WelcomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.welcome_item, container, false);
        final ImageView backgroundImgView = view.findViewById(R.id.background_id);
        final TextView welcomeText = view.findViewById(R.id.text_model);
        final WelcomeModel welcomeModel = list.get(position);
        backgroundImgView.setImageResource(welcomeModel.getImageBackId());
        welcomeText.setText(welcomeModel.getTitle());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
