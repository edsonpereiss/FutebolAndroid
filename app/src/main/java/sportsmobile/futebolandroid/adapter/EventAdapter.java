package sportsmobile.futebolandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.SystemService;

import java.util.ArrayList;
import java.util.List;

import sportsmobile.futebolandroid.item.EventItem;
import sportsmobile.futebolandroid.item.EventItem_;
import sportsmobile.futebolandroid.model.Event;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 08/12/17.
 */

@EBean
public class EventAdapter extends BaseAdapter
{
    protected List<Event> events = new ArrayList<>();
    @RootContext protected Context context;
    @SystemService protected LayoutInflater inflater;

    public void EventAdapter(List<Event> events, Context context)
    {
        this.events = events;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        EventItem eventItem;

        if (view == null)
        {
            eventItem = EventItem_.build(context);
        }
        else
        {
            eventItem = (EventItem) view;
        }

        eventItem.bind(getItem(position));

        return eventItem;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Event getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}

