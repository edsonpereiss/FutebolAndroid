package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 21/12/17.
 */

public class SubstitutionItem
{
    @SerializedName("off_name")
    public String off_name;
    @SerializedName("on_name")
    public String on_name;
    @SerializedName("off_id")
    public String off_id;
    @SerializedName("on_id")
    public String on_id;
    @SerializedName("minute")
    public String minute;
    @SerializedName("off_slug")
    public String off_slug;
    @SerializedName("on_slug")
    public String on_slug;

    public SubstitutionItem()
    {

    }

    public SubstitutionItem(String off_name,
                            String on_name,
                            String off_id,
                            String on_id,
                            String minute,
                            String off_slug,
                            String on_slug)
    {
        this.off_name = off_name;
        this.on_name = on_name;
        this.off_id = off_id;
        this.on_id = on_id;
        this.minute = minute;
        this.off_slug = off_slug;
        this.on_slug = on_slug;
    }
}