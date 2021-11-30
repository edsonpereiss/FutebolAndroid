package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class MatchInfo {

    @SerializedName("stadium")
    public String stadium;
    @SerializedName("attendance")
    public String attendance;
    @SerializedName("referee")
    public String referee;

    public MatchInfo()
    {

    }

    public MatchInfo(String stadium,
                     String attendance,
                     String referee

    )
    {
        this.stadium = stadium;
        this.attendance = attendance;
        this.referee = referee;
    }
}
