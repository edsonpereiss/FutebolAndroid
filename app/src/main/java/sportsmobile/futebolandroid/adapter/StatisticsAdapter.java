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

import sportsmobile.futebolandroid.item.ClassificationItem;
import sportsmobile.futebolandroid.item.ClassificationItem_;
import sportsmobile.futebolandroid.item.StatisticItem;
import sportsmobile.futebolandroid.item.StatisticItem_;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 09/12/17.
 */

@EBean
public class StatisticsAdapter extends BaseAdapter
{

    protected List<Standing> classifications = new ArrayList<>();
    @RootContext protected Context context;
    @SystemService protected LayoutInflater inflater;

    public void StatisticsAdapter(List<Standing> classifications, Context context)
    {
        this.classifications = classifications;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        StatisticItem statisticItem;

        if (view == null)
        {
            statisticItem = StatisticItem_.build(context);
        }
        else
        {
            statisticItem = (StatisticItem) view;
        }

        statisticItem.bind(getItem(position));

        return statisticItem;
    }


    @Override
    public int getCount() {
        return classifications.size();
    }

    @Override
    public Standing getItem(int position) {
        return classifications.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
