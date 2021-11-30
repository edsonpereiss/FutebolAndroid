package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import sportsmobile.futebolandroid.model.Club;

/**
 * Created by edsonreis on 31/10/17.
 */

public class ClubMapper
{
    private static Gson gson = new Gson();

    public static List<Club> toClubs(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Club[].class));
    }

    public static  Club toClub(String json)
    {
        return gson.fromJson(json,Club.class);
    }
}
