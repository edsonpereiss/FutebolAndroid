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

import sportsmobile.futebolandroid.item.SubsItem_;
import sportsmobile.futebolandroid.model.SubsItem;

/**
 * Created by edsonreis on 22/12/17.
 */

@EBean
public class SubsAdapter extends BaseAdapter
{
    protected List<SubsItem> subs = new ArrayList<>();
    @RootContext protected Context context;
    @SystemService protected LayoutInflater inflater;
    String info;

    public void SubsAdapter(List<sportsmobile.futebolandroid.model.SubsItem> subs, String info, Context context)
    {
        this.info = info;
        this.subs = subs;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        sportsmobile.futebolandroid.item.SubsItem subsItem;

        if (view == null)
        {
            subsItem = SubsItem_.build(context);
        }
        else
        {
            subsItem = (sportsmobile.futebolandroid.item.SubsItem) view;
        }

        subsItem.bind(getItem(position), info);

        return subsItem;
    }

    @Override
    public int getCount() {
        return subs.size();
    }

    @Override
    public sportsmobile.futebolandroid.model.SubsItem getItem(int position) {
        return subs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
