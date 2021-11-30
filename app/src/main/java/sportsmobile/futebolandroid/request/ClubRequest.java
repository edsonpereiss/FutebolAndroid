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
import sportsmobile.futebolandroid.mapper.ClubMapper;
import sportsmobile.futebolandroid.model.Club;
import sportsmobile.futebolandroid.model.ItemDataBase;


/**
 * Created by edsonreis on 31/10/17.
 */

public class ClubRequest
{
    public static List<Club> getClubs(final int player_id, final Context context){

        List<Club> clubs = new ArrayList<Club>();
        Call<List<Club>> result = WebRoutines.retrofitCall().Clubs(String.valueOf(player_id));

        try {
            Response<List<Club>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = player_id;
                item.type = ValuesInterface.CLUBS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.CLUBS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(player_id == datas.get(i).id)
                {
                    clubs = ClubMapper.toClubs(datas.get(i).value);
                }
            }
        }

        return clubs;
    }
}
