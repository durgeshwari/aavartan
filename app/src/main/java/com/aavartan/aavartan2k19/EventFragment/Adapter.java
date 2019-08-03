package com.aavartan.aavartan2k19.EventFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.aavartan.aavartan2k19.R;
import com.aavartan.aavartan2k19.Event.FunDetail;
import com.aavartan.aavartan2k19.Event.ManagerialDetail;
import com.aavartan.aavartan2k19.Event.model.Model;
import com.aavartan.aavartan2k19.Event.RoboticsDetail;
import com.aavartan.aavartan2k19.Event.TechnicalDetail;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.event_item, container, false);

        ImageView imageView;
        TextView title, desc;
        int i;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {

            String s = models.get(position).getTitle();


            @Override
            public void onClick(View v) {
                switch(position){
                    case 0:
                        Intent i1 = new Intent(context, TechnicalDetail.class);
                        context.startActivity(i1);
                        break;

                    case 1:
                        Intent i2 = new Intent(context, FunDetail.class);
                        context.startActivity(i2);
                        break;

                    case 2:
                        Intent i3 = new Intent(context, ManagerialDetail.class);
                        context.startActivity(i3);
                        break;

                    case 3:
                        Intent i4 = new Intent(context, RoboticsDetail.class);
                        context.startActivity(i4);
                        break;

                        default:
                            break;

                }

                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
