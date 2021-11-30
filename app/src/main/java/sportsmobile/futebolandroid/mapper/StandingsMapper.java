package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 30/10/17.
 */

public class StandingsMapper
{
    private static Gson gson = new Gson();

    public  static List<Standing> toStandings(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Standing[].class));
    }

    public  static  Standing toStanding(String json)
    {
        return gson.fromJson(json,Standing.class);
    }
}
