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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.adapter.ClassificationAdapter;
import sportsmobile.futebolandroid.model.Scorer;
import sportsmobile.futebolandroid.model.Standing;
import sportsmobile.futebolandroid.request.ScorerRequest;
import sportsmobile.futebolandroid.request.StandingsRequest;

/**
 * Created by edsonreis on 27/11/17.
 */

@EFragment(R.layout.fragment_classification)
@OptionsMenu(R.menu.menu_main)
public class ClassificationFragment extends Fragment
{

    @ViewById protected ListView lv_standings;
    @ViewById protected ProgressBar progress_bar;
    @Bean protected ClassificationAdapter classification_adapter;

    protected static List<Standing> standings;
    protected static IconButton iconButtonMessages;
    protected static TextView itemMessagesBadgeTextView;

    @AfterViews
    protected void viewsInitialized(){
        requestClassification();

    }

    private void progressBarLoad(boolean activated)
    {
        progress_bar.setVisibility(activated ? View.VISIBLE : View.GONE);
    }

    private void listClassification()
    {
        classification_adapter = new ClassificationAdapter();
        classification_adapter.ClassificationAdapter(standings, getContext());
        lv_standings.setAdapter(classification_adapter);
    }

    private void listGroup()
    {
    }

    private void requestClassification()
    {
        standings = StandingsRequest.getStandings(1117, getActivity().getApplicationContext());
        sortClassification();
        listClassification();
    }

    private void sortClassification()
    {
        Collections.sort(standings, new Comparator<Standing>() {
            public int compare(Standing o1, Standing o2) {
                return o2.position - o1.position;
            }
        });
        Collections.reverse(standings);
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

    @OptionsItem (R.id.menu_refresh)
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

