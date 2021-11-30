package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;

/**
 * Created by edsonreis on 21/12/17.
 */

@EViewGroup(R.layout.item_lineup)
public class LineupItem extends CardView
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


    public LineupItem(Context context)
    {
        super(context);

        this.context = context;
    }

    public void bind(sportsmobile.futebolandroid.model.LineupItem lineupItem, String info)
    {

        if (info.equals("local"))
        {
            lay_localteam.setVisibility(VISIBLE);
            lay_visitorteam.setVisibility(GONE);

            name_localteam.setText(lineupItem.name);
            number_localteam.setText(lineupItem.number);

            if(lineupItem.pos.equals("G"))
            {
                pos_localteam.setText(R.string.position_g);
            }

            if(lineupItem.pos.equals("CD-L"))
            {
                pos_localteam.setText(R.string.position_cdl);
            }

            if(lineupItem.pos.equals("CD-R"))
            {
                pos_localteam.setText(R.string.position_cdr);
            }

            if(lineupItem.pos.equals("DM"))
            {
                pos_localteam.setText(R.string.position_dm);
            }

            if(lineupItem.pos.equals("LB"))
            {
                pos_localteam.setText(R.string.position_lb);
            }

            if(lineupItem.pos.equals("RB"))
            {
                pos_localteam.setText(R.string.position_rb);
            }

            if(lineupItem.pos.equals("CM-L"))
            {
                pos_localteam.setText(R.string.position_cml);
            }

            if(lineupItem.pos.equals("CM-R"))
            {
                pos_localteam.setText(R.string.position_cmr);
            }

            if(lineupItem.pos.equals("LM"))
            {
                pos_localteam.setText(R.string.position_lm);
            }

            if(lineupItem.pos.equals("RM"))
            {
                pos_localteam.setText(R.string.position_rm);
            }

            if(lineupItem.pos.equals("F"))
            {
                pos_localteam.setText(R.string.position_f);
            }
        }

        if(info.equals("visitor"))
        {
            lay_localteam.setVisibility(GONE);
            lay_visitorteam.setVisibility(VISIBLE);

            name_visitorteam.setText(lineupItem.name);
            number_visitorteam.setText(lineupItem.number);

            if(lineupItem.pos.equals("G"))
            {
                pos_visitorteam.setText(R.string.position_g);
            }

            if(lineupItem.pos.equals("CD-L"))
            {
                pos_visitorteam.setText(R.string.position_cdl);
            }

            if(lineupItem.pos.equals("CD-R"))
            {
                pos_visitorteam.setText(R.string.position_cdr);
            }

            if(lineupItem.pos.equals("DM"))
            {
                pos_visitorteam.setText(R.string.position_dm);
            }

            if(lineupItem.pos.equals("LB"))
            {
                pos_visitorteam.setText(R.string.position_lb);
            }

            if(lineupItem.pos.equals("RB"))
            {
                pos_visitorteam.setText(R.string.position_rb);
            }

            if(lineupItem.pos.equals("CM-L"))
            {
                pos_visitorteam.setText(R.string.position_cml);
            }

            if(lineupItem.pos.equals("CM-R"))
            {
                pos_visitorteam.setText(R.string.position_cmr);
            }

            if(lineupItem.pos.equals("LM"))
            {
                pos_visitorteam.setText(R.string.position_lm);
            }

            if(lineupItem.pos.equals("RM"))
            {
                pos_visitorteam.setText(R.string.position_rm);
            }

            if(lineupItem.pos.equals("F"))
            {
                pos_visitorteam.setText(R.string.position_f);
            }
        }
    }
}