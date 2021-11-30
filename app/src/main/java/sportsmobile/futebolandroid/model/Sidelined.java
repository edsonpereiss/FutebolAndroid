package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Sidelined {

    @SerializedName("id")
    public long id;
    @SerializedName("team_id")
    public long team_id;
    @SerializedName("team_slug")
    public String team_slug;
    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;
    @SerializedName("startdate")
    public String startdate;
    @SerializedName("enddate")
    public String enddate;

    public Sidelined()
    {

    }

    public Sidelined(long id,
                     long team_id,
                     String team_slug,
                     String name,
                     String description,
                     String startdate,
                     String enddate
    )
    {
        this.id = id;
        this.team_id = team_id;
        this.team_slug = team_slug;
        this.name = name;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
    }
}
