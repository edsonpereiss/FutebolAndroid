package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Commentarie;

/**
 * Created by edsonreis on 30/10/17.
 */

public class CommentarieMapper
{
    private static Gson gson = new Gson();

    public static List<Commentarie> toCommentaries(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Commentarie[].class));
    }

    public static  Commentarie toCommentarie(String json)
    {
        return gson.fromJson(json,Commentarie.class);
    }
}
