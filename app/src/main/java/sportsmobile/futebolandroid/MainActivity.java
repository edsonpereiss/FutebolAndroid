package sportsmobile.futebolandroid;

/**
 * Created by edsonreis on 29/11/17.
 */

import android.Manifest;
import android.graphics.Point;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.Utils.FragmentHelper;
import sportsmobile.futebolandroid.fragment.ClassificationFragment;
import sportsmobile.futebolandroid.fragment.ClassificationFragment_;

import sportsmobile.futebolandroid.fragment.NewMatchFragment;
import sportsmobile.futebolandroid.fragment.NewMatchFragment_;
import sportsmobile.futebolandroid.fragment.ScorerFragment;
import sportsmobile.futebolandroid.fragment.ScorerFragment_;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById protected Toolbar toolbar;
    @ViewById protected DrawerLayout drawer_layout;
    @ViewById protected NavigationView nav_view;
    @ViewById protected TabLayout tab_layout;
    @ViewById protected ViewPager view_pager;

    protected ClassificationFragment f_classification;
    protected NewMatchFragment f_match;
    protected ScorerFragment f_scorer;
    protected FragmentHelper adapter;

    @AfterViews
    protected void viewsInitialized()
    {
        setSupportActionBar(toolbar);
        initAction();

    }


    private void initAction()
    {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (
                        this,
                        drawer_layout,
                        toolbar,
                        R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close
                );

        drawer_layout.addDrawerListener(toggle);
        nav_view.setNavigationItemSelectedListener(this);
        adapter = new FragmentHelper(getSupportFragmentManager());

        toggle.syncState();

        if (view_pager != null)
        {
            setupViewPager(view_pager);
        }

        initTabLayout();
    }

    private void initTabLayout()
    {
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void setupViewPager(ViewPager viewPager) {

        if (f_classification == null) {
            f_classification = new ClassificationFragment_();
        }
        if (f_match == null) {
            f_match = new NewMatchFragment_();
        }

        if (f_scorer== null) {
            f_scorer = new ScorerFragment_();
        }

        adapter.addFragment(f_classification, "CLASSIFICAÇÃO");
        adapter.addFragment(f_match, "JOGOS");
        adapter.addFragment(f_scorer, "ARTILHEIROS");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
    }

    @Override
    public void onBackPressed()
    {
        if(drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.home)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }
}