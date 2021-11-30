package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class LineupItem
{
    @SerializedName("id")
    public String id;
    @SerializedName("slug")
    public String slug;
    @SerializedName("number")
    public String number;
    @SerializedName("name")
    public String name;
    @SerializedName("pos")
    public String pos;

    public LineupItem()
    {

    }

    public LineupItem(String id,
                      String slug,
                      String number,
                      String name,
                      String pos)
    {
        this.id = id;
        this.slug = slug;
        this.number = number;
        this.name = name;
        this.pos = pos;
    }
}
