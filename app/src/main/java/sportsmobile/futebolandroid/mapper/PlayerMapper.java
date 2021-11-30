package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Player;

/**
 * Created by edsonreis on 30/10/17.
 */

public class PlayerMapper
{
    private static Gson gson = new Gson();

    public  static List<Player> toPlayers(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Player[].class));
    }

    public  static  Player toPlayer(String json)
    {
        return gson.fromJson(json,Player.class);
    }
}
