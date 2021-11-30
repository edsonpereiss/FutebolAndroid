package sportsmobile.futebolandroid.fragment;

import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sportsmobile.futebolandroid.DetailsActivity_;
import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.Utils.SharedPreferences;
import sportsmobile.futebolandroid.adapter.FavoriteDialogAdapter;
import sportsmobile.futebolandroid.adapter.MatchAdapter;
import sportsmobile.futebolandroid.model.Match;
import sportsmobile.futebolandroid.model.Standing;
import sportsmobile.futebolandroid.request.MatchRequest;
import sportsmobile.futebolandroid.request.StandingsRequest;

/**
 * Created by edsonreis on 03/03/18.
 */

@EFragment(R.layout.fragment_matches)
@OptionsMenu(R.menu.menu_main)
public class NewMatchFragment extends Fragment {

    protected static List<Standing> standings;
    protected static List<Match> matches;
    protected static List<Match> favorites_matches;
    protected static List<Match> matches_stage;
    protected static List<Integer> rounds;
    protected static Standing favorite_item;

    @Bean protected static MatchAdapter match_adapter;
    @Bean protected static FavoriteDialogAdapter favorite_dialog_adapter;

    @ViewById protected Toolbar toolbar;
    @ViewById protected static LinearLayout lay_button_favorite;
    @ViewById protected static LinearLayout lay_team_name;
    @ViewById protected static LinearLayout lay_round;
    @ViewById protected static ImageView ic_favorite;
    @ViewById protected static TextView number_stage;
    @ViewById protected static TextView team_name;
    @ViewById protected static ListView lv_matches;
    @ViewById protected static ListView lv_favorite_matches;
    @ViewById protected static ProgressBar progress_bar;

    protected static ListView lv_dialog_favorite;
    protected static AlertDialog dialog_favorite;
    protected static int count_stage = 1;
    protected static int count_max;
    protected static boolean isButtonClicked;
    protected static Context context;


    @AfterViews
    protected void viewsInitialized()
    {
        context = getActivity().getApplicationContext();
        rounds = new ArrayList<>();
        requestMatches();
        requestFavoriteMatches();

    }

    private static void requestMatches()
    {
        matches = new ArrayList<>();
        matches = MatchRequest.getMatchesComp(1117, context);
        sortMatchesByStage();
        listMatches();
    }

    private static void requestFavoriteMatches()
    {
        favorites_matches = new ArrayList<>();
        favorite_item = SharedPreferences.loadTeamFavorite(context);
        filterFavoriteMatches();
        listFavoriteMatches();
    }

    private static void listMatches()
    {
        match_adapter = new MatchAdapter();
        match_adapter.MatchAdapter(matches_stage, context);
        lv_matches.setAdapter(match_adapter);
    }

    private static void listFavoriteMatches()
    {
        match_adapter = new MatchAdapter();
        match_adapter.MatchAdapter(favorites_matches, context);
        lv_favorite_matches.setAdapter(match_adapter);
    }

    private static void listFavoriteDialog()
    {
        favorite_dialog_adapter = new FavoriteDialogAdapter();
        favorite_dialog_adapter.FavoriteDialogAdapter(standings, context);
        lv_dialog_favorite.setAdapter(favorite_dialog_adapter);
    }

    public void favoriteDialog()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.DialogFavorite));
        dialog_favorite = alert.create();

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_favorite,null);

        lv_dialog_favorite = (ListView) v.findViewById(R.id.lv_dialog_favorite);
        standings = StandingsRequest.getStandings(1117, context);

        listFavoriteDialog();

        if(lv_dialog_favorite.getParent()!=null)
        {
            ((ViewGroup)lv_dialog_favorite.getParent()).removeView(lv_dialog_favorite);
        }

        dialog_favorite.setView(lv_dialog_favorite);
        dialog_favorite.show();
    }

    private static void setupLayoutMatches()
    {
        ic_favorite.setImageResource(R.drawable.ic_escudo_default_g);

        lay_round.setVisibility(View.VISIBLE);
        lv_matches.setVisibility(View.VISIBLE);


        lv_favorite_matches.setVisibility(View.GONE);
        lay_team_name.setVisibility(View.GONE);

        isButtonClicked = true;

    }

    private static void setupLayoutFavorite()
    {
        ic_favorite.setImageResource(R.drawable.ic_ball);

        lay_round.setVisibility(View.GONE);
        lv_matches.setVisibility(View.GONE);


        lv_favorite_matches.setVisibility(View.VISIBLE);
        lay_team_name.setVisibility(View.VISIBLE);

        isButtonClicked = false;
    }

    public static void setupChoiceFavorite(Standing standing, Context context)
    {
        favorite_item = standing;
        team_name.setText(standing.team_name);

        SharedPreferences.saveTeamFavorite(standing, context);

        requestFavoriteMatches();
        setupLayoutFavorite();

        dialog_favorite.dismiss();
    }

    private static void sortMatchesByStage()
    {
        matches_stage = new ArrayList<>();
        for(int i = 0; i < matches.size(); i++)
        {
            if(matches.get(i).stage == count_stage)
            {
                matches_stage.add(matches.get(i));
            }
            rounds.add((int) (long) matches.get(i).stage);
        }

        count_max = Collections.max(rounds);
    }

    private static void filterFavoriteMatches()
    {

        if(favorite_item!= null)
        {
            for (int i = 0; i < matches.size(); i++)
            {
                if(matches.get(i).localteam_id == favorite_item.team_id || matches.get(i).visitorteam_id == favorite_item.team_id)
                {
                    favorites_matches.add(matches.get(i));
                }
            }
        }

    }

    @Click(R.id.lay_arrow_left)
    void arrowLeftWasClicked()
    {
        if(count_stage > 1)
        {
            count_stage --;
            number_stage.setText(String.valueOf(count_stage));

            sortMatchesByStage();
            listMatches();
        }
    }

    @Click(R.id.lay_arrow_right)
    void arrowRightWasClicked()
    {
        if(count_stage < count_max)
        {
            count_stage ++;
            number_stage.setText(String.valueOf(count_stage));

            sortMatchesByStage();
            listMatches();
        }
    }

    @Click(R.id.lay_favorite)
    void buttonFavoriteClicked()
    {
        if(SharedPreferences.loadTeamFavorite(context) != null)
        {
            if(isButtonClicked == false)
            {
                setupLayoutMatches();
            }
            else
            {
                setupLayoutFavorite();
            }
        }
        else
        {
            ic_favorite.setImageResource(R.drawable.ic_star);
            lay_button_favorite.setBackgroundColor(getResources().getColor(R.color.line));


        }

    }

    @OptionsItem(R.id.menu_refresh)
    public void refreshlist()
    {
    }

    @OptionsItem (R.id.menu_escolher_favorito)
    public void choiceFavorite()
    {
        favoriteDialog();
    }

    @OptionsItem (R.id.menu_today)
    public void showToday()
    {
    }

    @ItemClick(R.id.lv_matches)
    void itemMatchClicked(Match match)
    {
        DetailsActivity_.intent(this).extra("Match", match).start();
    }
}
