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

import sportsmobile.futebolandroid.item.LineupItem_;

/**
 * Created by edsonreis on 21/12/17.
 */

@EBean
public class LineupAdapter extends BaseAdapter
{
    protected List<sportsmobile.futebolandroid.model.LineupItem> lineup = new ArrayList<>();
    @RootContext protected Context context;
    @SystemService protected LayoutInflater inflater;
    String info;

    public void LineupAdapter(List<sportsmobile.futebolandroid.model.LineupItem> lineup, String info, Context context)
    {
        this.info = info;
        this.lineup = lineup;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        sportsmobile.futebolandroid.item.LineupItem lineupItem;

        if (view == null)
        {
            lineupItem = LineupItem_.build(context);
        }
        else
        {
            lineupItem = (sportsmobile.futebolandroid.item.LineupItem) view;
        }

        lineupItem.bind(getItem(position), info);

        return lineupItem;
    }

    @Override
    public int getCount() {
        return lineup.size();
    }

    @Override
    public sportsmobile.futebolandroid.model.LineupItem getItem(int position) {
        return lineup.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
