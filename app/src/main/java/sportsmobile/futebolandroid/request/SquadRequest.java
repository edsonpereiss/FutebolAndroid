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
import sportsmobile.futebolandroid.mapper.SquadMapper;
import sportsmobile.futebolandroid.model.ItemDataBase;
import sportsmobile.futebolandroid.model.Squad;

/**
 * Created by edsonreis on 31/10/17.
 */

public class SquadRequest
{
    public static List<Squad> getSquads(int team_id, final Context context){

        List<Squad> squads = new ArrayList<Squad>();
        Call<List<Squad>> result = WebRoutines.retrofitCall().Squads( String.valueOf(team_id));

        try {
            Response<List<Squad>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = team_id;
                item.type = ValuesInterface.SQUADS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.SQUADS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(team_id == datas.get(i).id)
                {
                    squads = SquadMapper.toSquads(datas.get(i).value);
                }
            }
        }

        return squads;
    }
}
