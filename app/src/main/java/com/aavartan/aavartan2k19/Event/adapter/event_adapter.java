package com.aavartan.aavartan2k19.Event.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aavartan.aavartan2k19.Event.model.Model;
import com.aavartan.aavartan2k19.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class event_adapter extends RecyclerView.Adapter<event_adapter.EventHolder> {
    List<Model> Events;
    Context ctx;

    public event_adapter(List<Model> Events, Context ct) {
        this.ctx = ct;
        this.Events = Events;
    }


    @NonNull
    @Override
    public event_adapter.EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.event_row, viewGroup, false);
        EventHolder eh = new EventHolder(v);
        return eh;

    }

    @Override
    public void onBindViewHolder(@NonNull event_adapter.EventHolder eventHolder, int i) {

        final EventHolder holder = eventHolder;
        holder.tvTitle.setText(Events.get(i).getTitle());
        holder.tvDesc.setText(Events.get(i).getDesc());
        Glide.with(ctx).load("" + Events.get(i).getImage()).into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return Events.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDesc;
        ImageView ivImage;
        public EventHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tvtitle);
            tvDesc = (TextView)itemView.findViewById(R.id.tvdesc);
            ivImage = (ImageView)itemView.findViewById(R.id.ivimage);
        }
    }
}
