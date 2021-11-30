package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import sportsmobile.futebolandroid.model.MatchStats;

/**
 * Created by edsonreis on 09/12/17.
 */

public class MatchStatsMapper {

    private static Gson gson = new Gson();

    public  static List<MatchStats> toMatchesStats(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                MatchStats[].class));
    }

    public  static  MatchStats toMatchStats (String json)
    {
        return gson.fromJson(json,MatchStats.class);
    }
}
