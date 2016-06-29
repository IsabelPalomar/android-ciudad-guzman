package android.example.com.feriaciudadguzman.fragments;

import android.example.com.feriaciudadguzman.adapters.PlacesRecyclerAdapter;
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


public class RestaurantsFragment extends Fragment {

    private List<Place> places;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_restaurants, container, false);

        initializeData();

        //Gets the recycler view by Id and set the initial configuration
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.places_rv);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(llm);
        }

        //Creates a new a instance of PlacesRecyclerAdapter, passing the current context and the list of categories
        PlacesRecyclerAdapter adapter = new PlacesRecyclerAdapter(this.getContext(), places);
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
        places.add(new Place("LoLa", "Casual dining. The food is prepared with fresh ingredients presented simply with a focus on flavor and quality.", "Lola Cocina-Copas-Cafe", R.drawable.restaurant_lola));
        places.add(new Place("Tostadas Pepes", "Most famous and best tostadas around. Anybody that lives or visits Cd. Guzman knows that Pepe's is the best.", "Tostadas Pepes", R.drawable.restaurant_pepes));
        places.add(new Place("Deguzman", "DeGuzman is a dining experience where you can enjoy regional and casual cuisine.", "DeGuzman restaurant", R.drawable.restaurant_deguzman));
        places.add(new Place("Los Portales", "Los Portales has wonderful Mexican food, atmosphere and great customer service.", "Los Portales Restaurant ciudad guzman", R.drawable.restaurant_portales));

    }


}
