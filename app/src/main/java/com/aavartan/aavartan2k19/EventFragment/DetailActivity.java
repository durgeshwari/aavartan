package com.aavartan.aavartan2k19.EventFragment;

import android.os.Bundle;

import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aavartan.aavartan2k19.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        TextView textView = findViewById(R.id.textView);
        String s = getIntent().getStringExtra("param");



        }
    }

