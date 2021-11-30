package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Commentarie {

    @SerializedName("id")
    public long id;
    @SerializedName("match_info")
    public List<MatchInfo> match_info = new ArrayList<MatchInfo>();
    @SerializedName("lineup")
    public Lineup lineup;
    @SerializedName("subs")
    public Subs subs;
    @SerializedName("substitutions")
    public Substitutions substitutions;
    @SerializedName("comments")
    public List<Comment> comments = new ArrayList<Comment>();
    @SerializedName("match_stats")
    public MatchStats match_stats;
    @SerializedName("player_stats")
    public PlayerStats player_stats;

    public Commentarie()
    {

    }

    public Commentarie(long id,
                       List<MatchInfo> match_info,
                       Lineup lineup,
                       Subs subs,
                       Substitutions substitutions,
                       List<Comment> comments,
                       MatchStats match_stats,
                       PlayerStats player_stats
    )
    {
        this.id = id;
        this.match_info = match_info;
        this.lineup = lineup;
        this.subs = subs;
        this.substitutions = substitutions;
        this.comments = comments;
        this.match_stats = match_stats;
        this.player_stats = player_stats;
    }
}
