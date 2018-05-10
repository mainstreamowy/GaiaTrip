package com.example.dnl.gaiatrip;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import io.realm.Realm;
import io.realm.RealmResults;

public class ListFragment extends Fragment {
        //implements View.OnClickListener,


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_list, container, false);

        final ListView listview = (ListView) view.findViewById(R.id.list_category);

//        Realm realm=Realm.getDefaultInstance();
//        final RealmResults<Place> results = realm.where(Place.class).findAll();
//        results.load();

        Place place1 = new Place(0,"iClube Náutico de Crestuma",
                "The 30-year-old Clube Náutico de Crestuma presents itself with a new direction, formed by athletes of the club, having as one of the objectives the formation of new champions and to make the club in a place where everybody is welcome, and where different generations can fraternize and exchange experiences. Over the last 30 years, the Crestuma Nautical Club has greatly contributed to the evolution of national canoeing, being seen as a motor of development of this sport, forming high level athletes and at the same time contributing to the personal training of these same athletes.",
                "entertainment",
                41.069172, -8.503402);
        Place place2 =new Place(0,"Afurada",
                "Afurada, has become fast the main fishing center of Vila Nova de Gaia, with the massive capture of sardines and lamprey. In this zone it is possible to identify the typical personality of the people residing in Vila Nova de Gaia, due to being a place where there is a population density, with all the neighbourhood’s, that grew with the customs of the region\n" +
                        "There is also a shop there where it is possible to rent bicycles and take advantage of the existing bike path that begins in Afurada and goes to Espinho, almost always along the seafront.",
                "entertainment",
                41.144492, -8.643944);
        Place place3 = new Place(0,"Parque da Lavandeira",
                "This park offers visitors various leisure options, such as pedestrian paths, theme gardens, children's playgrounds and picnic areas. The proposal, in future terms, will be the construction of a city park that includes sports, catering and leisure facilities. It will be done in two phases, the first will be carried out by the Biological Park, where the green area will be rehabilitated, for the construction of maintenance routes, circuits and leisure areas; and the second phase, called the \"Sports Area\", where the area already constructed will be used and improved.",
                "entertainment",
                41.097323, -8.556075);
        Place place4 = new Place(0,"Armazém do peixe",
                "Seafood, Mediterranean, European",
                "food",
                41.142710, -8.647187);
        Place place5= new Place(0,"Mar à Vista",
                "Seafood, Mediterranean, European",
                "food",
                41.122424, -8.666534);
        Place place6 = new Place(0,"Rabelos",
                "Mediterranean, Portuguese, Internacional",
                "food",
                41.137638, -8.614246);
        final String[] values = {place1.getName(),place2.getName(),place3.getName(),place4.getName(),place4.getName(),place5.getName(),place6.getName()};
        final String[] names = {place1.getName(),place2.getName(),place3.getName(),place4.getName(),place4.getName(),place5.getName(),place6.getName()};
        final String[] description = {place1.getDescription(),place2.getDescription(),place3.getDescription(),place4.getDescription(),place4.getDescription(),place5.getDescription(),place6.getDescription()};
        final Double[] latt = {place1.getLatitude(),place2.getLatitude(),place3.getLatitude(),place4.getLatitude(),place4.getLatitude(),place5.getLongtitude(),place6.getLatitude()};
        final Double[] longt = {place1.getLongtitude(),place2.getLongtitude(),place3.getLongtitude(),place4.getLongtitude(),place4.getLongtitude(),place5.getLongtitude(),place6.getLongtitude()};
        final String[] categories = {place1.getCategory(),place2.getCategory(),place3.getCategory(),place4.getCategory(),place4.getCategory(),place5.getCategory(),place6.getCategory()};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final ListAdapter adapter = new ListAdapter(this.getContext(),
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
//                final String item = (String) parent.getItemAtPosition(position);
//                view.animate().setDuration(2000).alpha(0)
//                        .withEndAction(new Runnable() {
//                            @Override
//                            public void run() {
//                                list.remove(item);
//                                adapter.notifyDataSetChanged();
//                                view.setAlpha(1);
//                            }
//                        });
                Bundle arguments = new Bundle();

                arguments.putString("name",names[position]);
                arguments.putString("description",description[position]);
                arguments.putString("category",categories[position]);
                arguments.putDouble("LAT",latt[position] );
                arguments.putDouble("LONG",longt[position]);

                SingleItemFragment myFragment = new SingleItemFragment();
                myFragment.setArguments(arguments);

                ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, myFragment)
                        .addToBackStack(null)
                        .commit();
            }

        });
        return view;
    }


}


