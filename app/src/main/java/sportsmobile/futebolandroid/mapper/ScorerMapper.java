package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Scorer;
import sportsmobile.futebolandroid.model.Sidelined;

/**
 * Created by edsonreis on 24/02/18.
 */

public class ScorerMapper
{
    private static Gson gson = new Gson();

    public  static List<Scorer> toScorers(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Scorer[].class));
    }

    public  static  Scorer toScorer(String json)
    {
        return gson.fromJson(json,Scorer.class);
    }
}
