package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class PlayerStats {

    @SerializedName("id")
    public long id;
    @SerializedName("localteam")
    public LocalTeam localteam;
    @SerializedName("visitorteam")
    public VisitorTeam visitorteam;

    public PlayerStats()
    {

    }

    public PlayerStats(long id,
                       LocalTeam localteam,
                       VisitorTeam visitorteam
    )
    {
        this.id = id;
        this.localteam = localteam;
        this.visitorteam = visitorteam;
    }

}
