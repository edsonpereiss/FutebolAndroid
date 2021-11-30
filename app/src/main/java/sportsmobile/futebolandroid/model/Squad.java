package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Squad {

    @SerializedName("id")
    public long id;
    @SerializedName("slug")
    public String slug;
    @SerializedName("team_id")
    public long team_id;
    @SerializedName("team_slug")
    public String team_slug;
    @SerializedName("name")
    public String name;
    @SerializedName("number")
    public String number;
    @SerializedName("age")
    public String age;
    @SerializedName("position")
    public String position;
    @SerializedName("injured")
    public String injured;
    @SerializedName("minutes")
    public String minutes;
    @SerializedName("appearences")
    public String appearences;
    @SerializedName("lineups")
    public String lineups;
    @SerializedName("substitute_in")
    public String substitute_in;
    @SerializedName("substitute_out")
    public String substitute_out;
    @SerializedName("substitutes_on_bench")
    public String substitutes_on_bench;
    @SerializedName("goals")
    public String goals;
    @SerializedName("assists")
    public String assists;
    @SerializedName("yellowcards")
    public String yellowcards;
    @SerializedName("yellowred")
    public String yellowred;
    @SerializedName("redcards")
    public String redcards;

    public Squad()
    {

    }

    public Squad(long id,
                 String slug,
                 long team_id,
                 String team_slug,
                 String name,
                 String number,
                 String age,
                 String position,
                 String injured,
                 String minutes,
                 String appearences,
                 String lineups,
                 String substitute_in,
                 String substitute_out,
                 String substitutes_on_bench,
                 String goals,
                 String assists,
                 String yellowcards,
                 String yellowred,
                 String redcards
    )
    {
        this.id = id;
        this.slug = slug;
        this.team_id = team_id;
        this.team_slug = team_slug;
        this.name = name;
        this.number = number;
        this.age = age;
        this.position = position;
        this.injured = injured;
        this.minutes = minutes;
        this.appearences = appearences;
        this.lineups = lineups;
        this.substitute_in = substitute_in;
        this.substitute_out = substitute_out;
        this.substitutes_on_bench = substitutes_on_bench;
        this.goals = goals;
        this.assists = assists;
        this.yellowcards = yellowcards;
        this.yellowred = yellowred;
        this.redcards = redcards;
    }
}
