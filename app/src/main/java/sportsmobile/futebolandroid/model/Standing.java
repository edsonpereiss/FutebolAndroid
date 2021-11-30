package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Standing {

    @SerializedName("id")
    public long id;
    @SerializedName("comp_id")
    public String comp_id;
    @SerializedName("season")
    public String season;
    @SerializedName("round")
    public String round;
    @SerializedName("stage_id")
    public int stage_id;
    @SerializedName("comp_group")
    public long comp_group;
    @SerializedName("country")
    public String country;
    @SerializedName("team_id")
    public long team_id;
    @SerializedName("team_slug")
    public String team_slug;
    @SerializedName("team_name")
    public String team_name;
    @SerializedName("status")
    public String status;
    @SerializedName("recent_form")
    public String recent_form;
    @SerializedName("position")
    public int position;
    @SerializedName("overall_gp")
    public int overall_gp;
    @SerializedName("overall_w")
    public int overall_w;
    @SerializedName("overall_d")
    public int overall_d;
    @SerializedName("overall_l")
    public int overall_l;
    @SerializedName("overall_gs")
    public int overall_gs;
    @SerializedName("overall_ga")
    public int overall_ga;
    @SerializedName("home_gp")
    public String home_gp;
    @SerializedName("home_w")
    public String home_w;
    @SerializedName("home_d")
    public String home_d;
    @SerializedName("home_l")
    public String home_l;
    @SerializedName("home_gs")
    public String home_gs;
    @SerializedName("home_ga")
    public String home_ga;
    @SerializedName("away_gp")
    public String away_gp;
    @SerializedName("away_w")
    public String away_w;
    @SerializedName("away_d")
    public String away_d;
    @SerializedName("away_l")
    public String away_l;
    @SerializedName("away_gs")
    public String away_gs;
    @SerializedName("away_ga")
    public String away_ga;
    @SerializedName("gd")
    public String gd;
    @SerializedName("points")
    public int points;
    @SerializedName("description")
    public int description;
    @SerializedName("displacement")
    public int displacement;
    @SerializedName("displacement_sign")
    public int displacement_sign;
    @SerializedName("efficiency")
    public double efficiency;

    public Standing()
    {

    }

    public Standing(long id,
                    String comp_id,
                    String season,
                    String round,
                    int stage_id,
                    long comp_group,
                    String country,
                    long team_id,
                    String team_slug,
                    String team_name,
                    String status,
                    String recent_form,
                    int position,
                    int overall_gp,
                    int overall_w,
                    int overall_d,
                    int overall_l,
                    int overall_gs,
                    int overall_ga,
                    String home_gp,
                    String home_w,
                    String home_d,
                    String home_l,
                    String home_gs,
                    String home_ga,
                    String away_gp,
                    String away_w,
                    String away_d,
                    String away_l,
                    String away_gs,
                    String away_ga,
                    String gd,
                    int points,
                    int description,
                    int displacement,
                    int displacement_sign,
                    double efficiency
    )
    {
        this.id = id;
        this.comp_id = comp_id;
        this.season = season;
        this.round = round;
        this.stage_id = stage_id;
        this.comp_group = comp_group;
        this.country = country;
        this.team_id = team_id;
        this.team_slug = team_slug;
        this.team_name = team_name;
        this.status = status;
        this.recent_form = recent_form;
        this.position = position;
        this.overall_gp = overall_gp;
        this.overall_w = overall_w;
        this.overall_d = overall_d;
        this.overall_l = overall_l;
        this.overall_gs = overall_gs;
        this.overall_ga = overall_ga;
        this.home_gp = home_gp;
        this.home_w = home_w;
        this.home_d = home_d;
        this.home_l = home_l;
        this.home_gs = home_gs;
        this.home_ga = home_ga;
        this.away_gp = away_gp;
        this.away_w = away_w;
        this.away_d = away_d;
        this.away_l = away_l;
        this.away_gs = away_gs;
        this.away_ga = away_ga;
        this.gd = gd;
        this.points = points;
        this.description = description;
        this.displacement = displacement;
        this.displacement_sign = displacement_sign;
        this.efficiency = efficiency;
    }
}
