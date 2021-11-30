package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 24/02/18.
 */

public class Scorer {

    @SerializedName("comp_id")
    public int comp_id;


    // MUDAR GOLS PARA GOALS
    @SerializedName("gols")
    public int gols;

    @SerializedName("player_id")
    public int player_id;

    @SerializedName("player_name")
    public String player_name;

    @SerializedName("player_slug")
    public String player_slug;

    @SerializedName("team_id")
    public int team_id;

    @SerializedName("team_name")
    public String team_name;

    @SerializedName("team_slug")
    public String team_slug;


    public Scorer()
    {
    }

    public Scorer(int comp_id,
                  int gols,
                  String player_name,
                  String player_slug,
                  int team_id,
                  String team_name,
                  String team_slug
                  )
    {
        this.comp_id = comp_id;
        this.gols = gols;
        this.player_name = player_name;
        this.player_slug = player_slug;
        this.team_id = team_id;
        this.team_name = team_name;
        this.team_slug = team_slug;
    }

}
