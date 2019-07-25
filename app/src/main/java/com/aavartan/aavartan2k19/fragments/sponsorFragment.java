package com.aavartan.aavartan2k19.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aavartan.aavartan2k19.SponsFragment.Adapter;
import com.aavartan.aavartan2k19.SponsFragment.Model;
import com.aavartan.aavartan2k19.R;

import java.util.ArrayList;
import java.util.List;


public class sponsorFragment extends Fragment {
    List<Model>models;
  Adapter adapter;
  RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rview=  inflater.inflate(R.layout.fragment_sponsor,container,false);



    models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "Technical Events"));
        models.add(new Model(R.drawable.sticker, "Fun Events"));
        models.add(new Model(R.drawable.poster, "Managerial Events"));
        models.add(new Model(R.drawable.namecard, "Robotics"));



        adapter = new Adapter(getActivity(),models);
        rv = rview.findViewById(R.id.rv_sponsor);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rv.setLayoutManager(mGridLayoutManager);
        rv.setAdapter(adapter);
        return rview;}
}
