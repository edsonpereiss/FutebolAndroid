package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Club {

    @SerializedName("id")
    public long id;
    @SerializedName("player_id")
    public long player_id;
    @SerializedName("name")
    public String name;
    @SerializedName("team_id")
    public long team_id;
    @SerializedName("team_slug")
    public String team_slug;
    @SerializedName("comp")
    public String comp;
    @SerializedName("comp_id")
    public long comp_id;
    @SerializedName("season")
    public String season;
    @SerializedName("minutes")
    public String minutes;
    @SerializedName("appearances")
    public String appearances;
    @SerializedName("lineups")
    public String lineups;
    @SerializedName("substitute_in")
    public String substitute_in;
    @SerializedName("substitute_out")
    public String substitute_out;
    @SerializedName("substitute_on_bench")
    public String substitute_on_bench;
    @SerializedName("goals")
    public String goals;
    @SerializedName("yellowcards")
    public String yellowcards;
    @SerializedName("yellowred")
    public String yellowred;
    @SerializedName("redcards")
    public String redcards;

    public Club()
    {

    }
    public Club(long id,
                long player_id,
                String name,
                long team_id,
                String team_slug,
                String comp,
                long comp_id,
                String season,
                String minutes,
                String appearances,
                String lineups,
                String substitute_in,
                String substitute_out,
                String substitute_on_bench,
                String goals,
                String yellowcards,
                String yellowred,
                String redcards

    )
    {
        this.id = id;
        this.player_id = player_id;
        this.name = name;
        this.team_id = team_id;
        this.team_slug = team_slug;
        this.comp = comp;
        this.comp_id = comp_id;
        this.season = season;
        this.minutes = minutes;
        this.appearances = appearances;
        this.lineups = lineups;
        this.substitute_in = substitute_in;
        this.substitute_out = substitute_out;
        this.substitute_on_bench = substitute_on_bench;
        this.goals = goals;
        this.yellowcards = yellowcards;
        this.yellowred = yellowred;
        this.redcards = redcards;
    }
}