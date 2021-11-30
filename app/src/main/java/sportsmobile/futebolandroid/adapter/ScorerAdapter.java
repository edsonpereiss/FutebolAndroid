package sportsmobile.futebolandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

import sportsmobile.futebolandroid.item.ScorerItem_;
import sportsmobile.futebolandroid.item.ScorerItem;
import sportsmobile.futebolandroid.model.Scorer;

/**
 * Created by edsonreis on 03/03/18.
 */

@EBean
public class ScorerAdapter extends BaseAdapter
{
    protected List<Scorer> scorers = new ArrayList<>();
    protected Context context;

    public void ScorerAdapter(List<Scorer> scorers, Context context)
    {
        this.scorers = scorers;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ScorerItem scorerItem;

        if (view == null)
        {
            scorerItem = ScorerItem_.build(context);
        }
        else
        {
            scorerItem = (ScorerItem) view;
        }

        scorerItem.bind(getItem(position), position);

        return scorerItem;
    }

    @Override
    public int getCount() {
        return scorers.size();
    }

    @Override
    public Scorer getItem(int position) {
        return scorers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
