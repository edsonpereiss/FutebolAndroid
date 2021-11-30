package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Team;

/**
 * Created by edsonreis on 30/10/17.
 */

public class TeamMapper
{
    private static Gson gson = new Gson();

    public  static List<Team> toTeams(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Team[].class));
    }

    public  static  Team toTeam(String json)
    {
        return gson.fromJson(json,Team.class);
    }
}
