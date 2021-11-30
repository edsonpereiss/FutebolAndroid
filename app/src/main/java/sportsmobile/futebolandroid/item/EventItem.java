package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.model.Comment;
import sportsmobile.futebolandroid.model.Event;

/**
 * Created by edsonreis on 08/12/17.
 */

@EViewGroup(R.layout.item_event)
public class EventItem extends CardView
{

    @ViewById protected LinearLayout lay_localteam;
    @ViewById protected LinearLayout lay_visitorteam;
    @ViewById protected TextView local_player;
    @ViewById protected TextView local_assist;
    @ViewById protected ImageView img_local_type;
    @ViewById protected TextView visitor_player;
    @ViewById protected TextView visitor_assist;
    @ViewById protected ImageView img_visitor_type;
    @ViewById protected TextView minute;
    protected Context context;

    public EventItem(Context context)
    {
        super(context);

        this.context = context;
    }

    public void bind(Event event)
    {
        minute.setText(event.minute);


        if(event.team.equals("localteam"))
        {
            local_player.setText(event.player);

            lay_localteam.setVisibility(VISIBLE);
            lay_visitorteam.setVisibility(INVISIBLE);
            local_assist.setVisibility(VISIBLE);

            if(event.type.equals("subst"))
            {
                local_assist.setText(event.assist);
                local_player.setTextColor(getResources().getColor(R.color.positive));
                local_assist.setTextColor(getResources().getColor(R.color.negative));
                img_local_type.setImageResource(R.drawable.ic_substitution);
            }
            else if(event.type.equals("goal"))
            {
                local_assist.setText(event.assist);
                img_local_type.setImageResource(R.drawable.ic_ball);
            }
            else if(event.type.equals("yellowcard"))
            {
                local_assist.setVisibility(GONE);
                img_local_type.setImageResource(R.drawable.ic_card_yellow);
            }
            else if (event.type.equals("redcard"))
            {
                local_assist.setVisibility(GONE);
                img_local_type.setImageResource(R.drawable.ic_card_red);
            }
        }

        if(event.team.equals("visitorteam"))
        {
            visitor_player.setText(event.player);

            lay_localteam.setVisibility(INVISIBLE);
            lay_visitorteam.setVisibility(VISIBLE);
            visitor_assist.setVisibility(VISIBLE);

            if(event.type.equals("subst"))
            {
                visitor_assist.setText(event.assist);
                visitor_player.setTextColor(getResources().getColor(R.color.positive));
                visitor_assist.setTextColor(getResources().getColor(R.color.negative));
                img_visitor_type.setImageResource(R.drawable.ic_substitution);
            }
            else if(event.type.equals("goal"))
            {
                visitor_assist.setText(event.assist);
                img_local_type.setImageResource(R.drawable.ic_ball);
            }
            else if(event.type.equals("yellowcard"))
            {
                visitor_assist.setVisibility(GONE);
                img_visitor_type.setImageResource(R.drawable.ic_card_yellow);
            }
            else if (event.type.equals("redcard"))
            {
                visitor_assist.setVisibility(GONE);
                img_local_type.setImageResource(R.drawable.ic_card_red);
            }
        }










    }
}
