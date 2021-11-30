package sportsmobile.futebolandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;


import sportsmobile.futebolandroid.item.MatchItem;
import sportsmobile.futebolandroid.item.MatchItem_;
import sportsmobile.futebolandroid.model.Match;

/**
 * Created by edsonreis on 29/11/17.
 */
@EBean
public class MatchAdapter extends BaseAdapter
{
    protected List<Match> matches = new ArrayList<>();
    protected Context context;

    public void MatchAdapter(List<Match> matches, Context context)
    {
        this.matches = matches;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        MatchItem matchItem;

        if (view == null)
        {
            matchItem = MatchItem_.build(context);
        }
        else
        {
            matchItem = (MatchItem) view;
        }

        matchItem.bind(getItem(position));

        return matchItem;
    }

    @Override
    public int getCount() {
        return matches.size();
    }

    @Override
    public Match getItem(int position) {
        return matches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
