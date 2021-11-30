package sportsmobile.futebolandroid.item;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.Utils.SharedPreferences;
import sportsmobile.futebolandroid.fragment.MatchFragment;
import sportsmobile.futebolandroid.fragment.NewMatchFragment;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 05/12/17.
 */

@EViewGroup(R.layout.item_favorite)
public class FavoriteDialogItem extends CardView {

    @ViewById protected TextView team_name;
    @ViewById protected ImageView img_team;
    @ViewById protected RadioButton rb_team;
    protected Context context;

    public FavoriteDialogItem(Context context)
    {
        super(context);
        this.context = context;
    }

    public void bind(final Standing favorite, Standing current_favorite){


        team_name.setText(favorite.team_name);

        if(current_favorite != null)
        {
            if(favorite.team_name.equals(current_favorite.team_name)){
                team_name.setTextColor(getResources().getColor(R.color.header_text));
                rb_team.setSelected(true);
                rb_team.setChecked(true);

            }
            else
            {
                team_name.setTextColor(getResources().getColor(R.color.text_1));
                rb_team.setSelected(false);
                rb_team.setChecked(false);
            }

        }


        rb_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                NewMatchFragment.setupChoiceFavorite(favorite,context);
            }
        });

    }
}
