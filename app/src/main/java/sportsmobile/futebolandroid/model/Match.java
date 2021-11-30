package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by edsonreis on 25/10/17.
 */

public class Match implements Serializable {

    @SerializedName("id")
    public long id;
    @SerializedName("match_id")
    public long match_id;
    @SerializedName("comp_id")
    public long comp_id;
    @SerializedName("date")
    public String date;
    @SerializedName("hour")
    public String hour;
   // @SerializedName("formatted_utc")
   // public Date formatted_utc;
    //@SerializedName("formatted_zone")
    //public Date formatted_zone;
    @SerializedName("season")
    public String season;
    @SerializedName("stage")
    public long stage;
    @SerializedName("venue")
    public String venue;
    @SerializedName("venue_id")
    public String venue_id;
    @SerializedName("venue_city")
    public String venue_city;
    @SerializedName("status")
    public String status;
    @SerializedName("timer")
    public String timer;
    @SerializedName("localteam_id")
    public long localteam_id;
    @SerializedName("localteam_name")
    public String localteam_name;
    @SerializedName("localteam_slug")
    public String localteam_slug;
    @SerializedName("localteam_score")
    public String localteam_score;
    @SerializedName("visitorteam_id")
    public long visitorteam_id;
    @SerializedName("visitorteam_name")
    public String visitorteam_name;
    @SerializedName("visitorteam_slug")
    public String visitorteam_slug;
    @SerializedName("visitorteam_score")
    public String visitorteam_score;
    @SerializedName("ht_score")
    public String ht_score;
    @SerializedName("ft_score")
    public String ft_score;
    @SerializedName("et_score")
    public String et_score;
    @SerializedName("penalty_local")
    public String penalty_local;
    @SerializedName("penalty_visitor")
    public String penalty_visitor;
    //public List<Event> events = new ArrayList<Event>();

    public Match()
    {

    }

    public Match(long id,
                 long match_id,
                 long comp_id,
                 String date,
                 String hour,
                 Date formatted_utc,
                 Date formatted_zone,
                 String season,
                 long stage,
                 String venue,
                 String venue_id,
                 String venue_city,
                 String status,
                 String timer,
                 long localteam_id,
                 String localteam_name,
                 String localteam_score,
                 String localteam_slug,
                 long visitorteam_id,
                 String visitorteam_name,
                 String visitorteam_score,
                 String visitorteam_slug,
                 String ht_score,
                 String ft_score,
                 String et_score,
                 String penalty_local,
                 String penalty_visitor

    )
    {
        this.id = id;
        this.match_id = match_id;
        this.comp_id = comp_id;
        this.date = date;
        this.hour = hour;
        //this.formatted_utc = formatted_utc;
        //this.formatted_zone = formatted_zone;
        this.season = season;
        this.stage = stage;
        this.venue = venue;
        this.venue_id = venue_id;
        this.venue_city = venue_city;
        this.status = status;
        this.timer = timer;
        this.localteam_id =localteam_id;
        this.localteam_name = localteam_name;
        this.localteam_score = localteam_score;
        this.localteam_slug = localteam_slug;
        this.visitorteam_id = visitorteam_id;
        this.visitorteam_name = visitorteam_name;
        this.visitorteam_score = visitorteam_score;
        this.visitorteam_slug = visitorteam_slug;
        this.ht_score = ht_score;
        this.ft_score = ft_score;
        this.et_score = et_score;
        this.penalty_local = penalty_local;
        this.penalty_visitor = penalty_visitor;
    }

}