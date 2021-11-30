package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Subs;

/**
 * Created by edsonreis on 30/10/17.
 */

public class SubsMapper
{
    private static Gson gson = new Gson();

    public  static List<Subs> toSubs(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Subs[].class));
    }

    public  static  Subs toSub(String json)
    {
        return gson.fromJson(json,Subs.class);
    }
}
