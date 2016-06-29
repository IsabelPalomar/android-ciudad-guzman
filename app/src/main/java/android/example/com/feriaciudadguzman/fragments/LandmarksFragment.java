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

public class LandmarksFragment extends Fragment {

    private List<Place> places;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_landmarks, container, false);

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
        places.add(new Place("Nevado de Colima", "Nevado de Colima is the 7th highest peak in Mexico, located in the state of Jalisco, near the border with the state of Colima.", "Nevado de Colima", R.drawable.landmark_nevado));
        places.add(new Place("The Zapotlan Lagoon", "Beautiful and colorful lagoon with a wide variety of flora and fauna.", "Laguna zapotlan", R.drawable.landmark_laguna));
        places.add(new Place("The Cathedral", "The Cathedral of San Jose is on the town square and dates back to 1866.", "Catedral de Ciudad Guzman", R.drawable.landmark_cathedral));
        places.add(new Place("Las Peñas", "Natural protected area surrounded by antique-style spaces, textured walkways and beautiful rock formation", "Las Peñas Ecological Park", R.drawable.landmark_penas));

    }

}