package com.example.dnl.gaiatrip;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TopPlacesAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.places1, R.drawable.places2, R.drawable.places3};
    private String[] text;
    private String[] name;
    private String[] date;

    public TopPlacesAdapter(Context context, String[] name, String [] date, String[] text ) {
        this.context = context;
        this.name= name;
        this.date = date;
        this.text=text;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpager_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        //   Button button =(Button) view.findViewById(R.id.button2);

        TextView tvName;
        tvName=(TextView)view.findViewById(R.id.tvName);

        tvName.setText(name[position]);

        TextView tvDate;

        tvDate = (TextView)view.findViewById(R.id.tvDate);

        tvDate.setText(date[position]);

        TextView textView;
        textView = (TextView) view.findViewById(R.id.textView);

        textView.setText(text[position]);






        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view  = (View) object;
        vp.removeView(view);
    }

}
