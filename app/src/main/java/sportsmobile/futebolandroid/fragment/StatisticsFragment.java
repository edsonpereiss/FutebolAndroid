package sportsmobile.futebolandroid.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.Utils.NonScrollListView;
import sportsmobile.futebolandroid.adapter.StatisticsAdapter;
import sportsmobile.futebolandroid.mapper.MatchStatsMapper;
import sportsmobile.futebolandroid.model.Match;
import sportsmobile.futebolandroid.model.MatchStats;
import sportsmobile.futebolandroid.model.Standing;
import sportsmobile.futebolandroid.request.StandingsRequest;


/**
 * Created by edsonreis on 07/12/17.
 */

@EFragment(R.layout.fragment_statistics)
public class StatisticsFragment extends Fragment
{
    @ViewById PieChart chart_possesiontime;
    @ViewById HorizontalBarChart chart_shots_ongoal;
    @ViewById HorizontalBarChart chart_shots_total;
    @ViewById HorizontalBarChart chart_saves;
    @ViewById HorizontalBarChart chart_corners;
    @ViewById HorizontalBarChart chart_fouls;
    @ViewById HorizontalBarChart chart_offsides;
    @ViewById HorizontalBarChart chart_yellowcards;
    @ViewById HorizontalBarChart chart_redcards;

    @ViewById TextView visitor_possesiontime;
    @ViewById TextView visitor_shots_ongoal;
    @ViewById TextView visitor_shots_total;
    @ViewById TextView visitor_saves;
    @ViewById TextView visitor_corners;
    @ViewById TextView visitor_fouls;
    @ViewById TextView visitor_offsides;
    @ViewById TextView visitor_yellowcards;
    @ViewById TextView visitor_redcards;

    @ViewById TextView local_possesiontime;
    @ViewById TextView local_shots_ongoal;
    @ViewById TextView local_shots_total;
    @ViewById TextView local_saves;
    @ViewById TextView local_corners;
    @ViewById TextView local_fouls;
    @ViewById TextView local_offsides;
    @ViewById TextView local_yellowcards;
    @ViewById TextView local_redcards;
    @ViewById NonScrollListView lv_standings;

    List<Float> float_possesiontime = new ArrayList<>();
    List<Float> float_shots_ongoal = new ArrayList<>();
    List<Float> float_shots_total = new ArrayList<>();
    List<Float> float_saves = new ArrayList<>();
    List<Float> float_corners = new ArrayList<>();
    List<Float> float_fouls = new ArrayList<>();
    List<Float> float_offsides = new ArrayList<>();
    List<Float> float_yellowcards = new ArrayList<>();
    List<Float> float_redcards = new ArrayList<>();
    List<Standing> standings = new ArrayList<>();
    MatchStats match_stats = new MatchStats();
    StatisticsAdapter statistics_adapter;
    Match match;

    @AfterViews
    protected void viewsInitialized()
    {
        requestMatchStats();
        refreshStandings();
    }

    public void requestMatchStats()
    {
        match = (Match) this.getArguments().getSerializable("Match");

        //NAO EXISTE A API VERIFICAR DEPOIS
        //match_stats = MatchstatsRequest.getMatchStats()
        String json = "{\"id\":2185826,\"localteam\":[{\"corners\":\"1\",\"fouls\":\"10\",\"offsides\":\"0\",\"possesiontime\":\"67%\",\"redcards\":\"0\",\"saves\":\"0\",\"shots_ongoal\":\"2\",\"shots_total\":\"5\",\"yellowcards\":\"2\"}],\"visitorteam\":[{\"corners\":\"7\",\"fouls\":\"12\",\"offsides\":\"3\",\"possesiontime\":\"33%\",\"redcards\":\"0\",\"saves\":\"1\",\"shots_ongoal\":\"1\",\"shots_total\":\"15\",\"yellowcards\":\"2\"}]}";
        match_stats = MatchStatsMapper.toMatchStats(json);
        refreshCharts();
    }

    public List<Standing> requestStandings()
    {
        standings = StandingsRequest.getStandings(1117, getContext());
        List<Standing> new_standings = new ArrayList<>();

        for(int i = 0; i < standings.size() ; i++)
        {
            if(standings.get(i).team_slug.equals(match.visitorteam_slug) || standings.get(i).team_slug.equals(match.localteam_slug))
            {
                new_standings.add(standings.get(i));
            }
        }
        return new_standings;
    }

    public void refreshStandings()
    {
        statistics_adapter = new StatisticsAdapter();
        statistics_adapter.StatisticsAdapter(requestStandings(), getContext());
        lv_standings.setAdapter(statistics_adapter);
    }


    public void refreshCharts()
    {
        for(int i = 0; i < match_stats.localteam.size(); i++)
        {
            local_possesiontime.setText(match_stats.localteam.get(i).possesiontime);
            local_shots_ongoal.setText(match_stats.localteam.get(i).shots_ongoal);
            local_shots_total.setText(match_stats.localteam.get(i).shots_total);
            local_saves.setText(match_stats.localteam.get(i).saves);
            local_corners.setText(match_stats.localteam.get(i).corners);
            local_fouls.setText(match_stats.localteam.get(i).fouls);
            local_offsides.setText(match_stats.localteam.get(i).offsides);
            local_yellowcards.setText(match_stats.localteam.get(i).yellowcards);
            local_redcards.setText(match_stats.localteam.get(i).redcards);

            float_possesiontime.add(Float.valueOf(match_stats.localteam.get(i).possesiontime.replace("%","")));
            float_shots_ongoal.add(Float.valueOf(match_stats.localteam.get(i).shots_ongoal));
            float_shots_total.add(Float.valueOf(match_stats.localteam.get(i).shots_total));
            float_saves.add(Float.valueOf(match_stats.localteam.get(i).saves));
            float_corners.add(Float.valueOf(match_stats.localteam.get(i).corners));
            float_fouls.add(Float.valueOf(match_stats.localteam.get(i).fouls));
            float_offsides.add(Float.valueOf(match_stats.localteam.get(i).offsides));
            float_yellowcards.add(Float.valueOf(match_stats.localteam.get(i).yellowcards));
            float_redcards.add(Float.valueOf(match_stats.localteam.get(i).redcards));
        }

        for(int i = 0; i < match_stats.visitorteam.size(); i++)
        {
            visitor_possesiontime.setText(match_stats.visitorteam.get(i).possesiontime);
            visitor_shots_ongoal.setText(match_stats.visitorteam.get(i).shots_ongoal);
            visitor_shots_total.setText(match_stats.visitorteam.get(i).shots_total);
            visitor_saves.setText(match_stats.visitorteam.get(i).saves);
            visitor_corners.setText(match_stats.visitorteam.get(i).corners);
            visitor_fouls.setText(match_stats.visitorteam.get(i).fouls);
            visitor_offsides.setText(match_stats.visitorteam.get(i).offsides);
            visitor_yellowcards.setText(match_stats.visitorteam.get(i).yellowcards);
            visitor_redcards.setText(match_stats.visitorteam.get(i).redcards);

            float_possesiontime.add(Float.valueOf(match_stats.visitorteam.get(i).possesiontime.replace("%","")));
            float_shots_ongoal.add(Float.valueOf(match_stats.visitorteam.get(i).shots_ongoal));
            float_shots_total.add(Float.valueOf(match_stats.visitorteam.get(i).shots_total));
            float_saves.add(Float.valueOf(match_stats.visitorteam.get(i).saves));
            float_corners.add(Float.valueOf(match_stats.visitorteam.get(i).corners));
            float_fouls.add(Float.valueOf(match_stats.visitorteam.get(i).fouls));
            float_offsides.add(Float.valueOf(match_stats.visitorteam.get(i).offsides));
            float_yellowcards.add(Float.valueOf(match_stats.visitorteam.get(i).yellowcards));
            float_redcards.add(Float.valueOf(match_stats.visitorteam.get(i).redcards));
        }

        chart_possesiontime = pieChartSettings(float_possesiontime.get(0),float_possesiontime.get(1), chart_possesiontime);
        chart_shots_ongoal = horizontalBarChartSettings(float_shots_ongoal.get(0),float_shots_ongoal.get(1),chart_shots_ongoal);
        chart_shots_total = horizontalBarChartSettings(float_shots_total.get(0),float_shots_total.get(1), chart_shots_total);
        chart_saves = horizontalBarChartSettings(float_saves.get(0),float_saves.get(1), chart_saves);
        chart_corners = horizontalBarChartSettings(float_corners.get(0),float_corners.get(1), chart_corners);
        chart_fouls= horizontalBarChartSettings(float_fouls.get(0),float_fouls.get(1), chart_fouls);
        chart_offsides = horizontalBarChartSettings(float_offsides.get(0),float_offsides.get(1), chart_offsides);
        chart_yellowcards = horizontalBarChartSettings(float_yellowcards.get(0),float_yellowcards.get(1), chart_yellowcards);
        chart_redcards = horizontalBarChartSettings(float_redcards.get(0),float_redcards.get(1), chart_redcards);
    }

    public PieChart pieChartSettings(float value1, float value2, PieChart chart)
    {
        chart.setUsePercentValues(true);

        List<PieEntry> entries_pie = new ArrayList<>();
        entries_pie.add(new PieEntry(value2, 0));
        entries_pie.add(new PieEntry(value1, 0));
        PieDataSet dataSet = new PieDataSet(entries_pie, "");

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ContextCompat.getColor(getContext(), R.color.positive));
        colors.add(ContextCompat.getColor(getContext(), R.color.header_text));
        dataSet.setColors(colors);
        dataSet.setDrawValues(false);
        chart.animateY(2500);
        PieData data = new PieData(dataSet);
        chart.setData(data);
        chart.setHoleRadius(75f);
        chart.setHoleColor(ContextCompat.getColor(getContext(), R.color.background));
        chart.setDrawHoleEnabled(true);
        chart.setClickable(false);
        chart.setTouchEnabled(false);
        chart.setDrawSlicesUnderHole(true);
        chart.setTransparentCircleRadius(80);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);

        return chart;
    }


    public HorizontalBarChart horizontalBarChartSettings(float value1, float value2, HorizontalBarChart chart)
    {
        List<BarEntry> entries_horizontal = new ArrayList<>();

        if(value1 > value2)
        {
            entries_horizontal.add(new BarEntry(value1, new float[]{ -value1, value2 }));
        }

        if(value1 < value2)
        {
            entries_horizontal.add(new BarEntry(value2, new float[]{ -value1, value2 }));
        }

        if (value1 == value2)
        {
            entries_horizontal.add(new BarEntry(value1, new float[]{ -value1, value2 }));
        }

        BarDataSet dataset_horizontal = new BarDataSet(entries_horizontal, "");
        dataset_horizontal.setColors(new int[] {ContextCompat.getColor(getContext(), R.color.header_text), ContextCompat.getColor(getContext(), R.color.positive)});
        dataset_horizontal.setDrawValues(false);
        BarData data_horizontal = new BarData(dataset_horizontal);
        chart.setData(data_horizontal);
        chart.animateXY(2000, 2000);
        chart.setClickable(false);
        chart.setTouchEnabled(false);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisLeft().setDrawAxisLine(false);
        chart.getXAxis().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.getAxisRight().setDrawAxisLine(false);
        chart.setScaleXEnabled(false);
        chart.setScaleYEnabled(false);
        chart.setScaleEnabled(false);
        chart.setDrawValueAboveBar(false);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);
        chart.setAutoScaleMinMaxEnabled(false);
        chart.invalidate();

        return chart;
    }

}
