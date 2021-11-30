package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.National;

/**
 * Created by edsonreis on 30/10/17.
 */

public class NationalMapper
{
    private static Gson gson = new Gson();

    public  static List<National> toNationals(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                National[].class));
    }

    public  static  National toNational(String json)
    {
        return gson.fromJson(json,National.class);
    }
}
