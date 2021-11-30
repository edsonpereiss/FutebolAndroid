package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class MatchStats {

    @SerializedName("id")
    public long id;
    @SerializedName("localteam")
    public List<MatchStatsItem> localteam = new ArrayList<>();
    @SerializedName("visitorteam")
    public List<MatchStatsItem> visitorteam = new ArrayList<>();

    public MatchStats()
    {

    }

    public MatchStats(long id,
                      List<MatchStatsItem> localteam,
                      List<MatchStatsItem> visitorteam)
    {
        this.id = id;
        this.localteam = localteam;
        this.visitorteam = visitorteam;
    }
}

