package com.example.dnl.gaiatrip;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class SingleItemFragment extends Fragment implements View.OnClickListener {
    double lat;
    double lng;

    private Integer  images = R.drawable.slider1;
    private String text;
    private String name;
    private String date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.single_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        //   Button button =(Button) view.findViewById(R.id.button2);

        TextView tvName;
        tvName=(TextView)view.findViewById(R.id.tvName);

        tvName.setText(name);

        TextView tvDate;

        tvDate = (TextView)view.findViewById(R.id.tvDate);

        tvDate.setText(date);

        TextView textView;
        textView = (TextView) view.findViewById(R.id.textView);

        textView.setText(text);






        imageView.setImageResource(images);

        Button showOnMap=view.findViewById(R.id.b_ShowOnMap);
        showOnMap.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_ShowOnMap:
                Bundle arguments = new Bundle();
                arguments.putDouble("LAT",2.0 );
                arguments.putDouble("LONG",3.0);

                MapFragment myFragment = new MapFragment();
                myFragment.setArguments(arguments);


                ((FragmentActivity) this.getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, myFragment)
                        .addToBackStack(null)
                        .commit();
        }
    }
}
