package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.Event;

/**
 * Created by edsonreis on 30/10/17.
 */

public class EventMapper
{
    private static Gson gson = new Gson();

    public  static List<Event> toEvents(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                Event[].class));
    }

    public  static  Event toEvent(String json)
    {
        return gson.fromJson(json,Event.class);
    }
}
