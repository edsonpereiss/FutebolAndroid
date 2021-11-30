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
import sportsmobile.futebolandroid.mapper.NationalMapper;
import sportsmobile.futebolandroid.mapper.SidelinedMapper;
import sportsmobile.futebolandroid.model.Sidelined;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class SidelinedRequest
{
    public static List<Sidelined> getSidelineds(int team_id, final Context context){

        List<Sidelined> sidelineds = new ArrayList<Sidelined>();
        Call<List<Sidelined>> result = WebRoutines.retrofitCall().Sidelineds( String.valueOf(team_id));

        try {
            Response<List<Sidelined>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = team_id;
                item.type = ValuesInterface.SIDELINEDS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.SIDELINEDS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(team_id == datas.get(i).id)
                {
                    sidelineds = SidelinedMapper.toSidelineds(datas.get(i).value);
                }
            }
        }

        return sidelineds;
    }
}
