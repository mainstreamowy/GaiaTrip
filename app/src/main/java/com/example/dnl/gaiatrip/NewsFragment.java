package com.example.dnl.gaiatrip;



import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NewsFragment extends Fragment {

    ViewPager viewPager;
    ConstraintLayout constraintView;
    private Button showOnMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news, null);

        View mainView = getActivity().findViewById(R.id.fragment_name);
        TextView txt;
        txt= mainView.findViewById(R.id.fragment_name);
        txt.setText(R.string.news);

        String [] name = {"FROM AFAR IT WAS AN ISLAND","CORRIDA PORTUCALE 2018","Meo Marés Vivas ‘18"};
        String [] date = {"May 3rd - 22H00 (2018)","July 15th (2018)","July 20, 21, 22 (2018)"};
        String [] text = {"The 30-year-old Clube Náutico de Crestuma presents itself with a new direction, formed by athletes of the club, having as one of the objectives the formation of new champions and to make the club in a place where everybody is welcome, and where different generations can fraternize and exchange experiences. Over the last 30 years, the Crestuma Nautical Club has greatly contributed to the evolution of national canoeing, being seen as a motor of development of this sport, forming high level athletes and at the same time contributing to the personal training of these same athletes.",
                "Run, jump and launch. Three activities that are the essence of athletics. Our reason for being 40 years ago.\n" +
                        "\n" +
                        "For four decades we have helped hundreds of kids run, launch (pitch) and jump more and better. It was through sports that we promote other values: our young people were supported in social integration, in related aspects with health and encouraged to live to live the associativism. Several of them are now our current leaders. \n" +
                        "\n" +
                        "That was and is our cause.\n",
                "MEO mares vivas: the largest music festival in the north of the country is back to Vila Nova de Gaia with 3 stages dedicated to top performers. It will feature the black Mamba, Rita Ora, LP among other internacional artists and highlighting the new national talents. An organization with intense concerts, ecstatic artists, and fans!"};
        Double[] lat={ -8.626266,41.127468, -8.626266};
        Double[] lng={41.127468,41.127468,-8.626266};
        viewPager =view.findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getContext(),name, date,text,lat,lng);

        viewPager.setAdapter(viewPagerAdapter);


        return view;
    }

}
