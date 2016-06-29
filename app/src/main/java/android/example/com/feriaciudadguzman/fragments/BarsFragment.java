package android.example.com.feriaciudadguzman.fragments;


import android.example.com.feriaciudadguzman.adapters.CustomRecyclerAdapter;
import android.example.com.feriaciudadguzman.models.Place;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.example.com.feriaciudadguzman.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsFragment extends Fragment {

    private List<Place> places;

    public BarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_bars, container, false);

        initializeData();

        //Gets the recycler view by Id and set the initial configuration
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.places_rv);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(llm);
        }

        //Creates a new a instance of CustomRecyclerAdapter, passing the current context and the list of categories
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(this.getContext(), places);
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    /**
     * Initialize the places using Place model
     */
    private void initializeData(){
        places = new ArrayList<>();
        places.add(new Place("Zeed", "Zeed is a dance club that brings you EDM music. If you're looking for EDM in Ciudad Guzman, Zeed is a place to be.", "Av 1ro. de Mayo 148, Ciudad Guzman Centro", R.drawable.bar_zeed));
        places.add(new Place("El muelle", "El muelle Bar and Tropical drinks is a Bar in Ciudad Guzman serving the best cocktails.", "Rio Bar Laguna", R.drawable.bar_muelle));
        places.add(new Place("PM Concepto", "PM concepto is a bar where you can enjoy the best margaritas in town.", "PM Concepto Ciudad guzman", R.drawable.bar_pm));
        places.add(new Place("Deja vu", " Kick back and cheer your team to victory as you enjoy some great cuisine and a nice cold beer.", "Melchor Ocampo 25A Ciudad Guzman", R.drawable.bar_dejavu));

    }

}
