package android.example.com.feriaciudadguzman.fragments;

import android.content.Context;
import android.example.com.feriaciudadguzman.adapters.CustomRecyclerAdapter;
import android.example.com.feriaciudadguzman.models.Place;
import android.net.Uri;
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
        places.add(new Place("LoLa cocina/copas/café", "Casual dining. The food is prepared with fresh ingredients presented simply with a focus on flavor and quality", "Lola Cocina-Copas-Cafe", R.drawable.landmark_nevado));
        places.add(new Place("Tostadas Pepes", "Beautiful and colorful lagoon with a wide variety of flora and fauna.", "Laguna zapotlan", R.drawable.landmark_laguna));
        places.add(new Place("Deguzman", "The Cathedral of San Jose is on the town square and dates back to 1866.", "Catedral de Ciudad Guzman", R.drawable.landmark_cathedral));
        places.add(new Place("Los Portales Restaurant", "Natural protected area surrounded by antique-style spaces, textured walkways and beautiful rock formation", "Las Peñas Ecological Park", R.drawable.landmark_penas));

    }


}
