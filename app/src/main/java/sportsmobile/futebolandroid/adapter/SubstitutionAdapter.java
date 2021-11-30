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

import sportsmobile.futebolandroid.item.SubstitutionItem_;
import sportsmobile.futebolandroid.model.SubstitutionItem;

/**
 * Created by edsonreis on 22/12/17.
 */

@EBean
public class SubstitutionAdapter extends BaseAdapter
{
    protected List<SubstitutionItem> substitution = new ArrayList<>();
    @RootContext
    protected Context context;
    @SystemService
    protected LayoutInflater inflater;
    String info;

    public void SubstitutionAdapter(List<sportsmobile.futebolandroid.model.SubstitutionItem> substitution, String info, Context context)
    {
        this.info = info;
        this.substitution = substitution;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        sportsmobile.futebolandroid.item.SubstitutionItem substitutionItem;

        if (view == null)
        {
            substitutionItem = SubstitutionItem_.build(context);
        }
        else
        {
            substitutionItem = (sportsmobile.futebolandroid.item.SubstitutionItem) view;
        }

        substitutionItem.bind(getItem(position), info);

        return substitutionItem;
    }

    @Override
    public int getCount() {
        return substitution.size();
    }

    @Override
    public sportsmobile.futebolandroid.model.SubstitutionItem getItem(int position) {
        return substitution.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
