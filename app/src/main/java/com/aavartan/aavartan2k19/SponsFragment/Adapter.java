package com.aavartan.aavartan2k19.SponsFragment;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aavartan.aavartan2k19.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;// private RetroPhoto r;// private List<RetroPhoto> list;
    private List<Model> mlist;

    public Adapter(Context context, List<Model> mlist) {
        this.context = context;
        this.mlist = mlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //mlist=r.getMovies();

        View v= LayoutInflater.from(context).inflate(R.layout.sponsor_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
      //  Toast.makeText(context, "heya", Toast.LENGTH_SHORT).show();

        viewHolder.t1.setText(String.valueOf(mlist.get(i).getTitle()));
        viewHolder.i1.setImageResource(mlist.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
       // ImageView iv;
        ImageView i1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.tv_sponsorname);
            i1=itemView.findViewById(R.id.iv_sponsor);


        }
    }
}