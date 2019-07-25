package com.aavartan.aavartan2k19.fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aavartan.aavartan2k19.BottomNavActivity;
import com.aavartan.aavartan2k19.R;
import com.aavartan.aavartan2k19.fragments.Adapters.SliderAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.aavartan.aavartan2k19.BottomNavActivity.*;


public class HomeFragment extends Fragment {

    ViewPager viewPager;
    TabLayout indicator;
    View view;
    Timer timer;

    List<Integer> color;
    List<String> colorName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,null);
        viewPager= view.findViewById(R.id.viewPager);
        indicator= view.findViewById(R.id.indicator);
        color = new ArrayList<>();
        color.add(R.drawable.a1);
        color.add(R.drawable.a2);
        color.add(R.drawable.a3);
        color.add(R.drawable.a4);
        color.add(R.drawable.a5);color.add(R.drawable.a9);
        color.add(R.drawable.a6);
        color.add(R.drawable.a7);
        color.add(R.drawable.a8);
        color.add(R.drawable.a10);
        color.add(R.drawable.a11);


        colorName = new ArrayList<>();
        colorName.add("");
        colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");colorName.add("");


        viewPager.setAdapter(new SliderAdapter(getContext(), color, colorName));
        indicator.setupWithViewPager(viewPager, true);

        timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 2000, 2000);

        return view;

    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(getActivity() == null)
                        return;
                    if (viewPager.getCurrentItem() < color.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}

