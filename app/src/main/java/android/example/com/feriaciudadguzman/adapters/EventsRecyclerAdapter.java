package android.example.com.feriaciudadguzman.adapters;


import android.content.Context;
import android.content.Intent;
import android.example.com.feriaciudadguzman.R;
import android.example.com.feriaciudadguzman.models.Event;
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
 * We are passing a list of "events" with an image resource, description and name.
 * When the user clicks one element(CardView) the application initiates a PlayerActivity
 */
public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.EventViewHolder> {

    List<Event> events;
    Context context;

    public EventsRecyclerAdapter(Context con, List<Event> events) {
        this.events = events;
        this.context = con;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventName;
        ImageView eventImg;

        EventViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.event_card_view);
            eventName = (TextView) itemView.findViewById(R.id.event_name);
            eventImg = (ImageView) itemView.findViewById(R.id.event_img);
        }
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, final int position) {
        holder.eventName.setText(events.get(position).getName());
        holder.eventImg.setImageResource(events.get(position).getImageId());

        holder.cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Open event link
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(events.get(position).getUrl()));
                context.startActivity(browserIntent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}