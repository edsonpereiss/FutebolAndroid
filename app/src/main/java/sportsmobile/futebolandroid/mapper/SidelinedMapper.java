package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Sidelined;

/**
 * Created by edsonreis on 30/10/17.
 */

public class SidelinedMapper
{
    private static Gson gson = new Gson();

    public  static List<Sidelined> toSidelineds(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Sidelined[].class));
    }

    public  static  Sidelined toSidelined(String json)
    {
        return gson.fromJson(json,Sidelined.class);
    }
}
