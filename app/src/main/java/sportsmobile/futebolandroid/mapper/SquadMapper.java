package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Squad;

/**
 * Created by edsonreis on 30/10/17.
 */

public class SquadMapper
{
    private static Gson gson = new Gson();

    public  static List<Squad> toSquads(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Squad[].class));
    }

    public  static  Squad toSquad(String json)
    {
        return gson.fromJson(json,Squad.class);
    }
}
