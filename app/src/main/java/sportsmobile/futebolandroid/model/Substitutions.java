package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Substitutions {

    @SerializedName("id")
    public long id;
    @SerializedName("localteam")
    public List<SubstitutionItem> localteam = new ArrayList<SubstitutionItem>();
    @SerializedName("visitorteam")
    public List<SubstitutionItem> visitorteam = new ArrayList<SubstitutionItem>();

    public Substitutions()
    {

    }

    public Substitutions(long id,
                         List<SubstitutionItem> localteam,
                         List<SubstitutionItem> visitorteam
    )
    {
        this.id = id;
        this.localteam = localteam;
        this.visitorteam = visitorteam;
    }
}

