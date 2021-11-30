package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Event {

    @SerializedName("id")
    public long id;
    @SerializedName("match_id")
    public long match_id;
    @SerializedName("type")
    public String type;
    @SerializedName("minute")
    public String minute;
    @SerializedName("extra_min")
    public String extra_min;
    @SerializedName("team")
    public String team;
    @SerializedName("player")
    public String player;
    @SerializedName("player_id")
    public String player_id;
    @SerializedName("player_slug")
    public String player_slug;
    @SerializedName("assist")
    public String assist;
    @SerializedName("assist_id")
    public String assist_id;
    @SerializedName("assist_slug")
    public String assist_slug;
    @SerializedName("result")
    public String result;

    public Event()
    {

    }

    public Event(long id,
                 long match_id,
                 String type,
                 String minute,
                 String extra_min,
                 String team,
                 String player,
                 String player_id,
                 String player_slug,
                 String assist,
                 String assist_id,
                 String assist_slug,
                 String result
    )
    {
        this.id = id;
        this.match_id = match_id;
        this.type = type;
        this.minute = minute;
        this.extra_min = extra_min;
        this.team = team;
        this.player = player;
        this.player_id = player_id;
        this.player_slug = player_slug;
        this.player_id = type;
        this.assist = assist;
        this.assist_id = assist_id;
        this.assist_slug = assist_slug;
        this.result = result;
    }
}
