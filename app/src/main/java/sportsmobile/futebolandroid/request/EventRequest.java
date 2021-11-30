package sportsmobile.futebolandroid.request;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import sportsmobile.futebolandroid.Utils.SharedPreferences;
import sportsmobile.futebolandroid.Utils.WebRoutines;
import sportsmobile.futebolandroid.interfaces.ValuesInterface;
import sportsmobile.futebolandroid.mapper.EventMapper;
import sportsmobile.futebolandroid.model.Event;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class EventRequest
{
    public static List<Event> getEvents(final long match_id, final Context context){

        List<Event> events = new ArrayList<Event>();
        Call<List<Event>> result = WebRoutines.retrofitCall().Events(String.valueOf(match_id));

        try {
            Response<List<Event>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();
                item.id = match_id;
                item.type = ValuesInterface.EVENTS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.EVENTS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(match_id == datas.get(i).id)
                {
                    events = EventMapper.toEvents(datas.get(i).value);
                }
            }
        }

        return events;
    }
}
