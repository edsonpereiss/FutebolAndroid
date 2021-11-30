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
import sportsmobile.futebolandroid.mapper.CupMapper;
import sportsmobile.futebolandroid.model.Cup;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class CupRequest
{
    public static List<Cup> getCups(final int player_id, final Context context){

        List<Cup> cups = new ArrayList<Cup>();
        Call<List<Cup>> result = WebRoutines.retrofitCall().Cups(String.valueOf(player_id));

        try {
            Response<List<Cup>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = player_id;
                item.type = ValuesInterface.CUPS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.CUPS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(player_id == datas.get(i).id)
                {
                    cups = CupMapper.toCups(datas.get(i).value);
                }
            }
        }

        return cups;
    }
}
