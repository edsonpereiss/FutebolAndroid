package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Player {

    @SerializedName("id")
    public long id;
    @SerializedName("common_name")
    public String common_name;
    @SerializedName("firstname")
    public String firstname;
    @SerializedName("lastname")
    public String lastname;
    @SerializedName("team")
    public String team;
    @SerializedName("teamid")
    public long teamid;
    @SerializedName("nationality")
    public String nationality;
    @SerializedName("birthdate")
    public String birthdate;
    @SerializedName("age")
    public String age;
    @SerializedName("birthcountry")
    public String birthcountry;
    @SerializedName("birthplace")
    public String birthplace;
    @SerializedName("position")
    public String position;
    @SerializedName("height")
    public String height;
    @SerializedName("weight")
    public String weight;

    public Player()
    {

    }

    public Player (long id,
                   String common_name,
                   String firstname,
                   String lastname,
                   String team,
                   long teamid,
                   String nationality,
                   String birthdate,
                   String age,
                   String birthcountry,
                   String birthplace,
                   String position,
                   String height,
                   String weight
    )

    {
        this.id = id;
        this.common_name = common_name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.team = team;
        this.teamid = teamid;
        this.nationality = nationality;
        this.birthdate = birthdate;
        this.age = age;
        this.birthcountry = birthcountry;
        this.birthplace = birthplace;
        this.position = position;
        this.height = height;
        this.weight = weight;
    }
}
