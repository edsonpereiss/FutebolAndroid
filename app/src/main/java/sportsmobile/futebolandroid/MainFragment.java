package sportsmobile.futebolandroid;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.Utils.FragmentHelper;
import sportsmobile.futebolandroid.fragment.ClassificationFragment;
import sportsmobile.futebolandroid.fragment.ClassificationFragment_;
import sportsmobile.futebolandroid.fragment.MatchFragment;
import sportsmobile.futebolandroid.fragment.MatchFragment_;
import sportsmobile.futebolandroid.fragment.ScorerFragment;
import sportsmobile.futebolandroid.fragment.ScorerFragment_;


/**
 * Created by edsonreis on 28/11/17.
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends Fragment
{
    @ViewById protected TabLayout tab_layout;
    @ViewById protected ViewPager view_pager;
    protected ClassificationFragment f_classification;
    protected MatchFragment f_match;
    protected ScorerFragment f_scorer;
    protected FragmentHelper adapter;

    @AfterViews
    protected void viewsInitialized(){

        adapter = new FragmentHelper(getChildFragmentManager());
        if (view_pager != null) {
            setupViewPager(view_pager);
        }
        initAction();
    }

    private void initAction() {

        tab_layout.setupWithViewPager(view_pager);

        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
            f_match = new MatchFragment_();
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
}