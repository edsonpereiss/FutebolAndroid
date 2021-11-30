package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.model.Match;

/**
 * Created by edsonreis on 29/11/17.
 */

@EViewGroup(R.layout.item_match)
public class MatchItem extends CardView {

    @ViewById protected TextView stadium;
    @ViewById protected TextView address;
    @ViewById protected TextView formatted_utc;
    @ViewById protected TextView localteam_name;
    @ViewById protected TextView localteam_score;
    @ViewById protected TextView visitorteam_name;
    @ViewById protected TextView visitorteam_score;
    protected Context context;

    public MatchItem(Context context){
        super(context);

        this.context = context;
    }

    public void bind(Match match){

        if(match.venue.contains("("))
        {
            String[] localization = match.venue.split("\\(");
            String string_stadium = localization[0];
            String string_address = localization[1].replace(")","");
            stadium.setText(string_stadium);
            address.setText(string_address);
        }
        else
        {
            stadium.setText(match.venue);
        }
        //formatted_utc.setText(match.formatted_utc);
        localteam_name.setText(match.localteam_name);
        localteam_score.setText(match.localteam_score);
        visitorteam_name.setText(match.visitorteam_name);
        visitorteam_score.setText(match.visitorteam_score);

    }
}