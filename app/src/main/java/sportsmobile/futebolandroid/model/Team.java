package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Team {

    @SerializedName("id")
    public long id;
    @SerializedName("is_national")
    public String is_national;
    @SerializedName("name")
    public String name;
    @SerializedName("country")
    public String country;
    @SerializedName("founded")
    public String founded;
    @SerializedName("leagues")
    public String leagues;
    @SerializedName("venue_name")
    public String venue_name;
    @SerializedName("venue_id")
    public String venue_id;
    @SerializedName("venue_surface")
    public String venue_surface;
    @SerializedName("venue_address")
    public String venue_address;
    @SerializedName("venue_city")
    public String venue_city;
    @SerializedName("venue_capacity")
    public String venue_capacity;
    @SerializedName("coach_name")
    public String coach_name;
    @SerializedName("coach_id")
    public String coach_id;
    @SerializedName("squad")
    public List<Squad> squad = new ArrayList<Squad>();
    @SerializedName("sidelined")
    public List<Sidelined> sidelined = new ArrayList<Sidelined>();
    @SerializedName("transfers_in")
    public List<TransfersIn> transfers_in = new ArrayList<TransfersIn>();
    @SerializedName("transfers_out")
    public List<TransfersOut> transfers_out = new ArrayList<TransfersOut>();
    @SerializedName("statistics")
    public List<Statistics> statistics = new ArrayList<Statistics>();

    public Team()
    {

    }

    public Team(long id,
                String is_national,
                String name,
                String country,
                String founded,
                String leagues,
                String venue_name,
                String venue_id,
                String venue_surface,
                String venue_address,
                String venue_city,
                String venue_capacity,
                String coach_name,
                String coach_id,
                List<Squad> squad,
                List<Sidelined> sidelined,
                List<TransfersIn> transfers_in,
                List<TransfersOut> transfers_out,
                List<Statistics> statistics
    )
    {
        this.id = id;
        this.is_national = is_national;
        this.name = name;
        this.country = country;
        this.founded = founded;
        this.leagues = leagues;
        this.venue_name = venue_name;
        this.venue_id = venue_id;
        this.venue_surface = venue_surface;
        this.venue_address = venue_address;
        this.venue_city = venue_city;
        this.venue_capacity = venue_capacity;
        this.coach_name = coach_name;
        this.coach_id = coach_id;
        this.squad = squad;
        this.sidelined = sidelined;
        this.transfers_in = transfers_in;
        this.transfers_out = transfers_out;
        this.statistics = statistics;
    }
}
