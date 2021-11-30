package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Competition;

/**
 * Created by edsonreis on 30/10/17.
 */

public class CompetitionMapper
{
    private static Gson gson = new Gson();

    public  static List<Competition> toCompetitions(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Competition[].class));
    }

    public  static  Competition toCompetition(String json)
    {
        return gson.fromJson(json,Competition.class);
    }
}
