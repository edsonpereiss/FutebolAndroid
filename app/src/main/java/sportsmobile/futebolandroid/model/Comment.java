package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Comment {

    @SerializedName("id")
    public long id;
    @SerializedName("match_id")
    public long match_id;
    @SerializedName("comment_id")
    public long comment_id;
    @SerializedName("important")
    public String important;
    @SerializedName("isgoal")
    public String isgoal;
    @SerializedName("minute")
    public String minute;
    @SerializedName("comment")
    public String comment;

    public Comment()
    {

    }

    public Comment(long id,
                   long match_id,
                   long comment_id,
                   String important,
                   String isgoal,
                   String minute,
                   String comment
    )
    {
        this.id = id;
        this.match_id = match_id;
        this.comment_id = comment_id;
        this.important = important;
        this.isgoal = isgoal;
        this.minute = minute;
        this.comment = comment;
    }
}
