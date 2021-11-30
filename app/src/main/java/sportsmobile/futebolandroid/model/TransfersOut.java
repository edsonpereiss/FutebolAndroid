package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class TransfersOut {

    @SerializedName("id")
    public long id;
    @SerializedName("player_id")
    public long player_id;
    @SerializedName("team_id")
    public long team_id;
    @SerializedName("team_slug")
    public String team_slug;
    @SerializedName("name")
    public String name;
    @SerializedName("date")
    public String date;
    @SerializedName("to_team")
    public String to_team;
    @SerializedName("to_team_id")
    public long to_team_id;
    @SerializedName("type")
    public String type;

    public TransfersOut()
    {

    }

    public TransfersOut(long id,
                       long player_id,
                       long team_id,
                       String team_slug,
                       String name,
                       String date,
                       String to_team,
                       long to_team_id,
                       String type
    )
    {
        this.id = id;
        this.player_id = player_id;
        this.team_id = team_id;
        this.team_slug = team_slug;
        this.name = name;
        this.date = date;
        this.to_team = to_team;
        this.to_team_id = to_team_id;
        this.type = type;
    }
}
