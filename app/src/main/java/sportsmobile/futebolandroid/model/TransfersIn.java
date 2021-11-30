package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class TransfersIn {

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
    @SerializedName("from_team")
    public String from_team;
    @SerializedName("from_team_id")
    public long from_team_id;
    @SerializedName("type")
    public String type;

    public TransfersIn()
    {

    }

    public TransfersIn(long id,
                       long player_id,
                       long team_id,
                       String team_slug,
                       String name,
                       String date,
                       String from_team,
                       long from_team_id,
                       String type
    )
    {
        this.id = id;
        this.player_id = player_id;
        this.team_id = team_id;
        this.team_slug = team_slug;
        this.name = name;
        this.date = date;
        this.from_team = from_team;
        this.from_team_id = from_team_id;
        this.type = type;
    }
}
