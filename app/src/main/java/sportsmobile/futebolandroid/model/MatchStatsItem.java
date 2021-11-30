package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class MatchStatsItem {

    @SerializedName("shots_total")
    public String shots_total;
    @SerializedName("shots_ongoal")
    public String shots_ongoal;
    @SerializedName("fouls")
    public String fouls;
    @SerializedName("corners")
    public String corners;
    @SerializedName("offsides")
    public String offsides;
    @SerializedName("possesiontime")
    public String possesiontime;
    @SerializedName("yellowcards")
    public String yellowcards;
    @SerializedName("redcards")
    public String redcards;
    @SerializedName("saves")
    public String saves;

    public MatchStatsItem()
    {

    }

    public MatchStatsItem(String shots_total,
                            String shots_ongoal,
                            String fouls,
                            String corners,
                            String offsides,
                            String possesiontime,
                            String yellowcards,
                            String redcards,
                            String saves

    )
    {
        this.shots_total = shots_total;
        this.shots_ongoal = shots_ongoal;
        this.fouls = fouls;
        this.corners = corners;
        this.offsides = offsides;
        this.possesiontime = possesiontime;
        this.yellowcards = yellowcards;
        this.redcards = redcards;
        this.saves = saves;
    }
}
