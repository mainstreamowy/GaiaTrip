package com.example.dnl.gaiatrip;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopPlacesFragment extends Fragment {

    ViewPager viewPager;
    ConstraintLayout constraintView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news, null);


        String [] name = {"Clube Náutico de Crestuma","Afurada","Parque da Lavandeira"};
        String [] date = {"","",""};
        String [] text = {"The 30-year-old Clube Náutico de Crestuma presents itself with a new direction, formed by athletes of the club, having as one of the objectives the formation of new champions and to make the club in a place where everybody is welcome, and where different generations can fraternize and exchange experiences. Over the last 30 years, the Crestuma Nautical Club has greatly contributed to the evolution of national canoeing, being seen as a motor of development of this" +
                " sport, forming high level athletes and at the same time contributing to the personal training of these same athletes. ",
                        "Afurada, has become fast the main fishing center of Vila Nova de Gaia, with the massive capture of sardines and lamprey. In this zone it is possible to identify the typical personality of the people residing in Vila Nova de Gaia, due to being a place where there is a population density, with all the neighbourhood’s, that grew with the customs of the region\n" +
                                "There is also a shop there where it is possible to rent bicycles and take advantage of the existing bike path that begins in Afurada and goes to Espinho, almost always along the seafront.\n" +
                        "\n",
                "This park offers visitors various leisure options, such as pedestrian paths, theme gardens, children's playgrounds and picnic areas. The proposal, in future terms, will be the construction of a city park that includes sports, catering and leisure facilities. It will be done in two phases, the first will be carried out by the Biological Park, where the green area will be rehabilitated, for the construction of maintenance routes, circuits and leisure areas; and the second phase, called the \"Sports Area\", where the area already constructed will be used and improved."};
        viewPager =view.findViewById(R.id.viewPager);

       TopPlacesAdapter topPlacesAdapter = new TopPlacesAdapter(this.getContext(),name, date,text);

        viewPager.setAdapter(topPlacesAdapter);

        return view;
    }
    }

