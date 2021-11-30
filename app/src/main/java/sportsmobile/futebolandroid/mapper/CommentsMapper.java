package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Comment;

/**
 * Created by edsonreis on 30/10/17.
 */

public class CommentsMapper
{
    private static Gson gson = new Gson();

    public  static List<Comment> toComments(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Comment[].class));
    }

    public  static  Comment toComment(String json)
    {
        return gson.fromJson(json,Comment.class);
    }
}
