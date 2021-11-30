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
import sportsmobile.futebolandroid.mapper.ClubIntlMapper;
import sportsmobile.futebolandroid.mapper.ScorerMapper;
import sportsmobile.futebolandroid.model.ClubIntl;
import sportsmobile.futebolandroid.model.ItemDataBase;
import sportsmobile.futebolandroid.model.Scorer;

/**
 * Created by edsonreis on 24/02/18.
 */

public class ScorerRequest {

    public static List<Scorer> getScorers(final int comp_id, final Context context){

        List<Scorer> scorers = new ArrayList<Scorer>();
        Call<List<Scorer>> result = WebRoutines.retrofitCall().Scorers(String.valueOf(comp_id));

        try
        {
            Response<List<Scorer>> response = result.execute();

            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = comp_id;
                item.type = ValuesInterface.SCORERS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.SCORERS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(comp_id == datas.get(i).id)
                {
                    scorers = ScorerMapper.toScorers(datas.get(i).value);
                }
            }
        }

        return scorers;
    }
}
