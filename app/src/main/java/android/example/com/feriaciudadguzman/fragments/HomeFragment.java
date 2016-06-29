package android.example.com.feriaciudadguzman.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.example.com.feriaciudadguzman.adapters.EventsRecyclerAdapter;
import android.example.com.feriaciudadguzman.adapters.PlacesRecyclerAdapter;
import android.example.com.feriaciudadguzman.models.Event;
import android.example.com.feriaciudadguzman.models.Place;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.example.com.feriaciudadguzman.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<Event> events;
    GridLayoutManager glm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initializeData();

        //Gets the recycler view by Id and set the initial configuration
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.events_rv);

        //Set the GridLayoutManager configuration depending of the orientation
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            glm = new GridLayoutManager(this.getContext(), 2);
        }
        else{
            glm = new GridLayoutManager(this.getContext(), 3);
        }

        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(glm);
        }

        //Creates a new a instance of EventsRecyclerAdapter, passing the current context and the list of categories
        EventsRecyclerAdapter adapter = new EventsRecyclerAdapter(this.getContext(), events);
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }


        return view;
    }


    /**
     * Initialize the events using Event model
     */
    private void initializeData() {
        events = new ArrayList<>();
        events.add(new Event("El callejón", "", "https://es.foursquare.com/v/el-callejon/506327aae4b0dbd6f12548d5", R.drawable.bar_muelle));
        events.add(new Event("Carros Alegoricos", "", "http://periodicoelsur.com/noticias_guzman.aspx?idnoticia=76069", R.drawable.event_carros));
        events.add(new Event("Feria", "", "http://www.dondehayferia.com/feria-zapotlan-el-grande-2015", R.drawable.event_feria));
        events.add(new Event("Enrosos", "", "http://www.periodicoelsur.com/noticias_guzman.aspx?idnoticia=63354", R.drawable.event_enroso));

    }

}
