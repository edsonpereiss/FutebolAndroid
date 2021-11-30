package sportsmobile.futebolandroid.request;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import sportsmobile.futebolandroid.Utils.SharedPreferences;
import sportsmobile.futebolandroid.Utils.WebRoutines;
import sportsmobile.futebolandroid.interfaces.ValuesInterface;
import sportsmobile.futebolandroid.mapper.StatisticsMapper;
import sportsmobile.futebolandroid.model.Statistics;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class StatisticsRequest
{
    public static Statistics getStatistics(final int id, final Context context){

        Statistics statistics = new Statistics();
        Call<Statistics> result = WebRoutines.retrofitCall().Statistics(String.valueOf(id));

        try {
            Response<Statistics> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = id;
                item.type = ValuesInterface.STATISTICS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.STATISTICS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(id == datas.get(i).id)
                {
                    statistics = StatisticsMapper.toStatistic(datas.get(i).value);
                }
            }
        }
        return statistics;
    }
}
