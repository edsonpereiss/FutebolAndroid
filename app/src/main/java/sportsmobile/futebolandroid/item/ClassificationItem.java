package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 27/11/17.
 */

@EViewGroup (R.layout.item_classification)
public class ClassificationItem extends CardView {

    @ViewById protected TextView team_name;
    @ViewById protected TextView position;
    @ViewById protected ImageView status;
    @ViewById protected TextView points;
    @ViewById protected TextView round;
    @ViewById protected TextView overall_w;
    @ViewById protected TextView overall_d;
    @ViewById protected TextView overall_l;
    @ViewById protected TextView overall_gs;
    @ViewById protected TextView overall_ga;
    @ViewById protected TextView gd;
    protected Context context;

    public ClassificationItem(Context context){
        super(context);

        this.context = context;
    }

    public void bind(Standing standing){

        if (standing.team_name.length() > 16)
        {
            standing.team_name = standing.team_name.substring(0,15) + "...";
        }

        if (standing.gd.contains("+"))
        {
            gd.setTextColor(getResources().getColor(R.color.positive));
        }
        else if (standing.gd.contains("-"))
        {
            gd.setTextColor(getResources().getColor(R.color.negative));
        }

        status.setVisibility(VISIBLE);
        if(standing.status.equals("up"))
        {
            status.setImageResource (getResources().getIdentifier("ic_position_up", "drawable", context.getPackageName()));
        }
        else if (standing.status.equals("down"))
        {
            status.setImageResource (getResources().getIdentifier("ic_position_down", "drawable", context.getPackageName()));
        }
        else if (standing.status.equals("same"))
        {
            status.setImageResource (getResources().getIdentifier("ic_position_stop", "drawable", context.getPackageName()));
        }
        else
        {
            status.setVisibility(GONE);
        }

        position.setText(String.valueOf(standing.position));
        team_name.setText(standing.team_name);
        points.setText(String.valueOf(standing.points));
        round.setText(String.valueOf(standing.round));
        overall_w.setText(String.valueOf(standing.overall_w));
        overall_d.setText(String.valueOf(standing.overall_d));
        overall_l.setText(String.valueOf(standing.overall_l));
        overall_gs.setText(String.valueOf(standing.overall_gs));
        overall_ga.setText(String.valueOf(standing.overall_ga));
        gd.setText(String.valueOf(standing.gd));
    }
}