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
import sportsmobile.futebolandroid.mapper.CompetitionMapper;
import sportsmobile.futebolandroid.model.Competition;
import sportsmobile.futebolandroid.model.ItemDataBase;


/**
 * Created by edsonreis on 31/10/17.
 */

public class CompetitionRequest
{
    public static Competition getCompetition(final int id, final Context context){

        Competition competition = new Competition();
        Call<Competition> result = WebRoutines.retrofitCall().Competition(String.valueOf(id));

        try {
            Response<Competition> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = id;
                item.type = ValuesInterface.COMPETITION;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.COMPETITION);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(id == datas.get(i).id)
                {
                    competition = CompetitionMapper.toCompetition(datas.get(i).value);
                }
            }
        }
        return competition;
    }

    public static List<Competition> getCompetitions(final Context context){

        List<Competition> competitions = new ArrayList<Competition>();
        Call<List<Competition>> result = WebRoutines.retrofitCall().Competitions();

        try {
            Response<List<Competition>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = 0;
                item.type = ValuesInterface.COMPETITIONS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.COMPETITIONS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                competitions = CompetitionMapper.toCompetitions(datas.get(i).value);
            }
        }

        return competitions;
    }
}
