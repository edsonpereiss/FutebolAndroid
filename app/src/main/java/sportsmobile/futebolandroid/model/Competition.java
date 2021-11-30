package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Competition {

    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("region")
    public String region;

    public Competition()
    {

    }

    public Competition(long id,
                       String name,
                       String region
    )

    {
        this.name = name;
        this.id = id;
        this.region = region;
    }
}
