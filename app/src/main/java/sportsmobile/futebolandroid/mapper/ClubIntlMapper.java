package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;


import sportsmobile.futebolandroid.model.ClubIntl;
import sportsmobile.futebolandroid.model.Match;

/**
 * Created by edsonreis on 30/10/17.
 */

public class ClubIntlMapper
{
    private static Gson gson = new Gson();

    public static List<ClubIntl> toClubsIntl(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                ClubIntl[].class));
    }

    public static  ClubIntl toClubIntl (String json)
    {
        return gson.fromJson(json,ClubIntl.class);
    }
}
