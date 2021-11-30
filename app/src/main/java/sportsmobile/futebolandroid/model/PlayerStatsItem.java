package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class PlayerStatsItem {

    @SerializedName("id")
    public String id;
    @SerializedName("slug")
    public String slug;
    @SerializedName("num")
    public String num;
    @SerializedName("name")
    public String name;
    @SerializedName("pos")
    public String pos;
    @SerializedName("posx")
    public String posx;
    @SerializedName("posy")
    public String posy;
    @SerializedName("shots_total")
    public String shots_total;
    @SerializedName("shots_on_goal")
    public String shots_on_goal;
    @SerializedName("goals")
    public String goals;
    @SerializedName("assists")
    public String assists;
    @SerializedName("offsides")
    public String offsides;
    @SerializedName("fouls_drawn")
    public String fouls_drawn;
    @SerializedName("fouls_committed")
    public String fouls_committed;
    @SerializedName("saves")
    public String saves;
    @SerializedName("yellowcards")
    public String yellowcards;
    @SerializedName("redcards")
    public String redcards;
    @SerializedName("pen_score")
    public String pen_score;
    @SerializedName("pen_miss")
    public String pen_miss;

    public PlayerStatsItem()
    {

    }

    public PlayerStatsItem(String id,
                           String slug,
                           String num,
                           String name,
                           String pos,
                           String posx,
                           String posy,
                           String shots_total,
                           String shots_on_goal,
                           String goals,
                           String assists,
                           String offsides,
                           String fouls_drawn,
                           String fouls_committed,
                           String saves,
                           String yellowcards,
                           String redcards,
                           String pen_score,
                           String pen_miss
    )
    {
        this.id = id;
        this.slug = slug;
        this.num = num;
        this.name = name;
        this.pos = pos;
        this.posx = posx;
        this.posy = posy;
        this.shots_total = shots_total;
        this.shots_on_goal = shots_on_goal;
        this.goals = goals;
        this.assists = assists;
        this.offsides = offsides;
        this.fouls_drawn = fouls_drawn;
        this.fouls_committed = fouls_committed;
        this.saves = saves;
        this.yellowcards = yellowcards;
        this.redcards = redcards;
        this.pen_score = pen_score;
        this.pen_miss = pen_miss;
    }
}
