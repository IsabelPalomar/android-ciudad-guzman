package android.example.com.feriaciudadguzman.adapters;


import android.content.Context;
import android.content.Intent;
import android.example.com.feriaciudadguzman.R;
import android.example.com.feriaciudadguzman.models.Place;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * This adapter uses extends RecyclerView adapter to create a list of elements using CardView.
 * We are passing a list of "places" with an image resource, description and name.
 * When the user clicks one element(CardView) the application initiates a PlayerActivity
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.PlaceViewHolder> {

    List<Place> places;
    Context context;

    public CustomRecyclerAdapter(Context con, List<Place> places) {
        this.places = places;
        this.context = con;
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView placeName;
        TextView placeDesc;
        ImageView placeImg;

        PlaceViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.place_card_view);
            placeName = (TextView) itemView.findViewById(R.id.place_name);
            placeDesc = (TextView) itemView.findViewById(R.id.place_desc);
            placeImg = (ImageView) itemView.findViewById(R.id.place_img);
        }
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_row, parent, false);
        return new PlaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, final int position) {
        holder.placeName.setText(places.get(position).getName());
        holder.placeDesc.setText(places.get(position).getDescription());
        holder.placeImg.setImageResource(places.get(position).getImageId());

        holder.cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Start google maps
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(places.get(position).getAddress()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}