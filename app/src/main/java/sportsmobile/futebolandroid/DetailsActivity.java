package sportsmobile.futebolandroid;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.Utils.FragmentHelper;
import sportsmobile.futebolandroid.fragment.CommentFragment;
import sportsmobile.futebolandroid.fragment.CommentFragment_;
import sportsmobile.futebolandroid.fragment.EventFragment;
import sportsmobile.futebolandroid.fragment.EventFragment_;
import sportsmobile.futebolandroid.fragment.EscalationFragment;
import sportsmobile.futebolandroid.fragment.EscalationFragment_;
import sportsmobile.futebolandroid.fragment.StatisticsFragment;
import sportsmobile.futebolandroid.fragment.StatisticsFragment_;
import sportsmobile.futebolandroid.model.Match;


/**
 * Created by edsonreis on 06/12/17.
 */

@EActivity(R.layout.details_test)
public class DetailsActivity extends AppCompatActivity
{
    @ViewById protected Toolbar toolbar;
    @ViewById protected TabLayout tab_layout;
    @ViewById protected ViewPager view_pager;

    protected CommentFragment f_commentarie;
    protected StatisticsFragment f_statistics;
    protected EscalationFragment f_escalation;
    protected EventFragment f_event;
    protected FragmentHelper adapter;
    protected Bundle bundle = new Bundle();


    @AfterViews
    protected void viewsInitialized()
    {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        Match match = (Match) this.getIntent().getSerializableExtra("Match");

        View mCustomView = mInflater.inflate(R.layout.custom_toolbar, null);
        TextView title = (TextView) mCustomView.findViewById(R.id.title);
        TextView date = (TextView) mCustomView.findViewById(R.id.date);

        title.setText(match.localteam_name.substring(0,3)+"  "+match.localteam_score+" - "+ match.visitorteam_score+"  "+match.visitorteam_name.substring(0,3));
        date.setText(match.date);

        getSupportActionBar().setCustomView(mCustomView);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        initAction();
    }

    private void initAction()
    {

        adapter = new FragmentHelper(getSupportFragmentManager());
        if (view_pager != null) {
            setupViewPager(view_pager);
        }

        tab_layout.setupWithViewPager(view_pager);
        ViewCompat.setNestedScrollingEnabled(view_pager,true);

        initTabLayout();
    }


    private void initTabLayout()
    {
        tab_layout.getTabAt(0).setIcon(R.drawable.ic_chart_on);
        tab_layout.getTabAt(1).setIcon(R.drawable.ic_timer_off);
        tab_layout.getTabAt(2).setIcon(R.drawable.ic_timeline_off);
        tab_layout.getTabAt(3).setIcon(R.drawable.ic_stadium_off);



        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tab_layout.getTabAt(0).setIcon(R.drawable.ic_chart_on);
                        break;
                    case 1:
                        tab_layout.getTabAt(1).setIcon(R.drawable.ic_timer_on);
                        break;
                    case 2:
                        tab_layout.getTabAt(2).setIcon(R.drawable.ic_timeline_on);
                        break;
                    case 3:
                        tab_layout.getTabAt(3).setIcon(R.drawable.ic_stadium_on);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab_layout.getTabAt(0).setIcon(R.drawable.ic_chart_off);
                tab_layout.getTabAt(1).setIcon(R.drawable.ic_timer_off);
                tab_layout.getTabAt(2).setIcon(R.drawable.ic_timeline_off);
                tab_layout.getTabAt(3).setIcon(R.drawable.ic_stadium_off);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tab_layout.getTabAt(0).setIcon(R.drawable.ic_chart_on);
                tab_layout.getTabAt(1).setIcon(R.drawable.ic_timer_on);
                tab_layout.getTabAt(2).setIcon(R.drawable.ic_timeline_on);
                tab_layout.getTabAt(3).setIcon(R.drawable.ic_stadium_on);
            }
        });


    }

    public void setupViewPager(ViewPager viewPager) {


        if (f_statistics == null)
        {
            f_statistics = new StatisticsFragment_();
            bundle.putSerializable("Match", getIntent().getSerializableExtra("Match"));
            f_statistics.setArguments(bundle);
        }

        if (f_commentarie == null)
        {
            f_commentarie = new CommentFragment_();
            bundle.putSerializable("Match", getIntent().getSerializableExtra("Match"));
            f_commentarie.setArguments(bundle);

        }

        if (f_event == null)
        {
            f_event = new EventFragment_();
            bundle.putSerializable("Match", getIntent().getSerializableExtra("Match"));
            f_event.setArguments(bundle);
        }

        if (f_escalation == null)
        {
            f_escalation = new EscalationFragment_();
            bundle.putSerializable("Match", getIntent().getSerializableExtra("Match"));
            f_escalation.setArguments(bundle);
        }

        adapter.addFragment(f_statistics,"");
        adapter.addFragment(f_commentarie,"");
        adapter.addFragment(f_event,"");
        adapter.addFragment(f_escalation,"");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super. onBackPressed();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}