package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class LocalTeam {

    @SerializedName("player")
    public List<PlayerStatsItem> player = new ArrayList<>();

    public LocalTeam()
    {

    }

    public  LocalTeam(List<PlayerStatsItem> player)
    {
        this.player = player;
    }
}
