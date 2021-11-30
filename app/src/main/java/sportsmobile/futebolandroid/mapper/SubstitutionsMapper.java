package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Substitutions;

/**
 * Created by edsonreis on 30/10/17.
 */

public class SubstitutionsMapper
{
    private static Gson gson = new Gson();

    public  static List<Substitutions> toSubstitutions(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Substitutions[].class));
    }

    public  static  Substitutions toSubstitution(String json)
    {
        return gson.fromJson(json,Substitutions.class);
    }
}
