package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */
public class Lineup {

    @SerializedName("id")
    public long id;
    @SerializedName("localteam")
    public List<LineupItem> localteam = new ArrayList<>();
    @SerializedName("visitorteam")
    public List<LineupItem> visitorteam = new ArrayList<>();

    public Lineup()
    {

    }

    public Lineup(long id,
                  List<LineupItem> localteam,
                  List<LineupItem> visitorteam)
    {
        this.id = id;
        this.localteam = localteam;
        this.visitorteam = visitorteam;
    }
}