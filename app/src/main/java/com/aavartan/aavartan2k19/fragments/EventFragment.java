package com.aavartan.aavartan2k19.fragments;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aavartan.aavartan2k19.EventFragment.Adapter;
import com.aavartan.aavartan2k19.Event.model.Model;
import com.aavartan.aavartan2k19.R;
import com.aavartan.aavartan2k19.ScheduleActivity;

import java.util.ArrayList;
import java.util.List;


public class EventFragment extends Fragment {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    Button sch_btn;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
        View rview=  inflater.inflate(R.layout.fragment_event,container,false);

        sch_btn=rview.findViewById(R.id.btnSchedule);
        sch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ScheduleActivity.class));
            }
        });



        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "Technical Events", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.sticker, "Fun Events", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new Model(R.drawable.poster, "Managerial Events", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new Model(R.drawable.namecard, "Robotics", "Business cards are cards bearing business information about a company or individual."));

        adapter = new Adapter(models, this.getActivity());

        viewPager = rview.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };
        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return rview;
    }
}





