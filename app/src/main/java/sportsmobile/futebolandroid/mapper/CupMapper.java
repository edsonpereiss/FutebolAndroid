package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Cup;

/**
 * Created by edsonreis on 30/10/17.
 */

public class CupMapper
{
    private static Gson gson = new Gson();

    public  static List<Cup> toCups(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Cup[].class));
    }

    public  static  Cup toCup(String json)
    {
        return gson.fromJson(json,Cup.class);
    }
}
