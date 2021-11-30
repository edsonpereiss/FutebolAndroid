package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class PlayerStatistics {

    @SerializedName("id")
    public long id;
    @SerializedName("club")
    public List<Club> club = new ArrayList<Club>();
    @SerializedName("cups")
    public List<Cup> cups = new ArrayList<Cup>();
    @SerializedName("club_intl")
    public List<ClubIntl> club_intl = new ArrayList<ClubIntl>();
    @SerializedName("national")
    public List<National> national = new ArrayList<National>();

    public PlayerStatistics()
    {

    }

    public PlayerStatistics(long id,
                            List<Club> club,
                            List<Cup> cups,
                            List<ClubIntl> club_intl,
                            List<National> national
    )
    {
        this.id = id;
        this.club = club;
        this.cups = cups;
        this.club_intl = club_intl;
        this.national = national;
    }



}

