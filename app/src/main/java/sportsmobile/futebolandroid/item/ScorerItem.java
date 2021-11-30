package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.model.Scorer;

/**
 * Created by edsonreis on 03/03/18.
 */

@EViewGroup(R.layout.item_scorer)
public class ScorerItem extends CardView {

    @ViewById protected TextView position;
    @ViewById protected TextView goals;
    @ViewById protected TextView player_name;
    @ViewById protected TextView team_name;


    protected Context context;

    public ScorerItem(Context context){
        super(context);

        this.context = context;
    }

    public void bind(Scorer scorer, int number_position){

        position.setText(String.valueOf(number_position + 1));
        goals.setText(String.valueOf(scorer.gols));
        player_name.setText(scorer.player_name);
        team_name.setText(scorer.team_name);

    }
}