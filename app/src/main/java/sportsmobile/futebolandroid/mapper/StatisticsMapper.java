package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Statistics;

/**
 * Created by edsonreis on 30/10/17.
 */

public class StatisticsMapper
{
    private static Gson gson = new Gson();

    public  static List<Statistics> toStatistics(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Statistics[].class));
    }

    public  static  Statistics toStatistic(String json)
    {
        return gson.fromJson(json,Statistics.class);
    }
}
