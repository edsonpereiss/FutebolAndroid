package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Lineup;

/**
 * Created by edsonreis on 30/10/17.
 */

public class LineupMapper
{
    private static Gson gson = new Gson();

    public  static List<Lineup> toLineups(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Lineup[].class));
    }

    public  static  Lineup toLineup(String json)
    {
        return gson.fromJson(json,Lineup.class);
    }
}
