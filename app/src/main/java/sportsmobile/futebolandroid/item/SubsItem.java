package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;

/**
 * Created by edsonreis on 22/12/17.
 */

@EViewGroup(R.layout.item_subs)
public class SubsItem extends CardView
{

    @ViewById protected LinearLayout lay_localteam;
    @ViewById protected LinearLayout lay_visitorteam;

    @ViewById protected TextView name_localteam;
    @ViewById protected TextView pos_localteam;
    @ViewById protected TextView number_localteam;


    @ViewById protected TextView name_visitorteam;
    @ViewById protected TextView pos_visitorteam;
    @ViewById protected TextView number_visitorteam;
    protected Context context;


    public SubsItem(Context context)
    {
        super(context);

        this.context = context;
    }

    public void bind(sportsmobile.futebolandroid.model.SubsItem subsItem, String info)
    {
        if (info.equals("local"))
        {
            lay_localteam.setVisibility(VISIBLE);
            lay_visitorteam.setVisibility(GONE);

            name_localteam.setText(subsItem.name);
            pos_localteam.setText(subsItem.pos);
            number_localteam.setText(subsItem.number);

        }

        if(info.equals("visitor"))
        {
            lay_localteam.setVisibility(GONE);
            lay_visitorteam.setVisibility(VISIBLE);

            name_visitorteam.setText(subsItem.name);
            pos_visitorteam.setText(subsItem.pos);
            number_visitorteam.setText(subsItem.number);

        }
    }
}