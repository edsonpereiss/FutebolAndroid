package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import sportsmobile.futebolandroid.model.Match;

/**
 * Created by edsonreis on 26/10/17.
 */

public class MatchMapper {

    private static Gson gson = new Gson();

    public  static List<Match> toMatches(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Match[].class));
    }

    public  static  Match toMatch (String json)
    {
        return gson.fromJson(json,Match.class);
    }
}
