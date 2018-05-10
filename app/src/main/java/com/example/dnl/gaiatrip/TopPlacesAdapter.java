package com.example.dnl.gaiatrip;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TopPlacesAdapter  extends PagerAdapter implements View.OnClickListener{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
    private String[] text;
    private String[] name;
    private String[] date;
    private Double[] lat;
    private Double[] lng;
    private int currentPage;
    public TopPlacesAdapter(Context context, String[] name, String [] date, String[] text,Double[] lat,Double[]lng ) {
        this.context = context;
        this.name= name;
        this.date = date;
        this.text=text;
        this.lat=lat;
        this.lng=lng;
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
        currentPage=vp.getCurrentItem();
        Button showOnMap=view.findViewById(R.id.b_ShowOnMap);
        showOnMap.setOnClickListener(this);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view  = (View) object;
        vp.removeView(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_ShowOnMap:
                Bundle arguments = new Bundle();
                arguments.putDouble("LAT",lat[getCurrentPage()] );
                arguments.putDouble("LONG",lng[getCurrentPage()]);

                MapFragment myFragment = new MapFragment();
                myFragment.setArguments(arguments);

                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, myFragment)
                        .addToBackStack(null)
                        .commit();
        }
    }

    public final int getCurrentPage() {
        return currentPage;
    }
}


