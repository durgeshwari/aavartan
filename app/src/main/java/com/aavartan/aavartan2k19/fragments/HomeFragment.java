package com.aavartan.aavartan2k19.fragments;

import android.graphics.Color;
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

    List<Integer> color;
    List<String> colorName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,null);

        viewPager= view.findViewById(R.id.viewPager);
        indicator= view.findViewById(R.id.indicator);
        color = new ArrayList<>();
        color.add(Color.RED);
        color.add(Color.GREEN);
        color.add(Color.BLUE);

        colorName = new ArrayList<>();
        colorName.add("RED");
        colorName.add("GREEN");
        colorName.add("BLUE");

        viewPager.setAdapter(new SliderAdapter(getContext(), color, colorName));
        indicator.setupWithViewPager(viewPager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 2000, 2000);

        return view;

    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < color.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}

