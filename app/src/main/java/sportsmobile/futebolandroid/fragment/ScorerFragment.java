package sportsmobile.futebolandroid.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.adapter.ClassificationAdapter;
import sportsmobile.futebolandroid.adapter.ScorerAdapter;
import sportsmobile.futebolandroid.model.Scorer;
import sportsmobile.futebolandroid.request.ScorerRequest;
import sportsmobile.futebolandroid.request.StandingsRequest;

/**
 * Created by edsonreis on 03/03/18.
 */

@EFragment(R.layout.fragment_scorer)
@OptionsMenu(R.menu.menu_main)
public class ScorerFragment extends Fragment
{

    @ViewById protected ListView lv_scorer;
    @ViewById protected ProgressBar progress_bar;
    @Bean protected ScorerAdapter scorer_adapter;

    protected static List<Scorer> scorers;
    protected static IconButton iconButtonMessages;
    protected static TextView itemMessagesBadgeTextView;

    @AfterViews
    protected void viewsInitialized(){
        requestScorer();
    }

    private void progressBarLoad(boolean activated)
    {
        progress_bar.setVisibility(activated ? View.VISIBLE : View.GONE);
    }

    private void listScorer()
    {
        scorer_adapter = new ScorerAdapter();
        scorer_adapter.ScorerAdapter(scorers, getContext());
        lv_scorer.setAdapter(scorer_adapter);
    }

    private void requestScorer()
    {
        scorers = ScorerRequest.getScorers(1148, getActivity().getApplicationContext());
        Collections.sort(scorers, new Comparator<Scorer>() {
            public int compare(Scorer o1, Scorer o2) {
                return o2.gols - o1.gols;
            }
        });

        listScorer();
    }

    public static void updateNotification(String size){

        if(size.equals("0"))
        {
            itemMessagesBadgeTextView.setVisibility(View.GONE);
            iconButtonMessages.setVisibility(View.GONE);
        }
        else
        {
            itemMessagesBadgeTextView.setVisibility(View.VISIBLE);
            itemMessagesBadgeTextView.setText(size);

            iconButtonMessages.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // MainFragment.sliding();
                }
            });
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        if(isMenuVisible())
        {
            menu.setGroupVisible(0,false);
        }

        menu.findItem(R.id.menu_escolher_favorito).setVisible(false);
        menu.findItem(R.id.menu_refresh).setVisible(true);
        menu.findItem(R.id.menu_today).setVisible(false);

        MenuItem item = menu.findItem(R.id.menu_today);
        MenuItemCompat.setActionView(item, R.layout.badge_layout);

        View badgeLayout = MenuItemCompat.getActionView(item);

        iconButtonMessages = (IconButton) badgeLayout.findViewById(R.id.badge_icon_button);
        itemMessagesBadgeTextView = (TextView) badgeLayout.findViewById(R.id.number_today);
    }

    @OptionsItem(R.id.menu_refresh)
    public void refreshlist()
    {
    }

    @OptionsItem (R.id.menu_escolher_favorito)
    public void choiceFavorite()
    {
    }

    @OptionsItem (R.id.menu_today)
    public void showToday()
    {
    }
}

