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

@EViewGroup(R.layout.item_substitution)
public class SubstitutionItem extends CardView
{
    @ViewById protected LinearLayout lay_localteam;
    @ViewById protected LinearLayout lay_visitorteam;

    @ViewById protected TextView off_name_localteam;
    @ViewById protected TextView on_name_localteam;
    @ViewById protected TextView minute_localteam;

    @ViewById protected TextView off_name_visitorteam;
    @ViewById protected TextView on_name_visitorteam;
    @ViewById protected TextView minute_visitorteam;

    protected Context context;


    public SubstitutionItem(Context context)
    {
        super(context);

        this.context = context;
    }

    public void bind(sportsmobile.futebolandroid.model.SubstitutionItem substitutionItem, String info)
    {
        if (info.equals("local"))
        {
            lay_localteam.setVisibility(VISIBLE);
            lay_visitorteam.setVisibility(GONE);

            off_name_localteam.setText(substitutionItem.off_name);
            on_name_localteam.setText(substitutionItem.on_name);
            minute_localteam.setText(substitutionItem.minute);

        }

        if(info.equals("visitor"))
        {
            lay_localteam.setVisibility(GONE);
            lay_visitorteam.setVisibility(VISIBLE);

            off_name_visitorteam.setText(substitutionItem.off_name);
            on_name_visitorteam.setText(substitutionItem.on_name);
            minute_visitorteam.setText(substitutionItem.minute);
        }
    }
}