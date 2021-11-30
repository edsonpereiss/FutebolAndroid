package sportsmobile.futebolandroid.request;


import android.content.Context;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import sportsmobile.futebolandroid.Utils.WebRoutines;
import sportsmobile.futebolandroid.interfaces.ValuesInterface;
import sportsmobile.futebolandroid.mapper.MatchMapper;
import sportsmobile.futebolandroid.model.ItemDataBase;
import sportsmobile.futebolandroid.model.Match;
import sportsmobile.futebolandroid.Utils.SharedPreferences;

/**
 * Created by edsonreis on 25/10/17.
 */

public class MatchRequest
{
    public static List<Match> getMatchesByDates(final int comp_id, String init_date, String end_date, final Context context){

        List<Match> matches = new ArrayList<Match>();
        Call<List<Match>> result = WebRoutines.retrofitCall().matchesByDates(String.valueOf(comp_id), init_date, end_date);

        try {
            Response<List<Match>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = comp_id;
                item.type = ValuesInterface.MATCHES_BY_DATES;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.MATCHES_BY_DATES);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(comp_id == datas.get(i).id)
                {
                    matches = MatchMapper.toMatches(datas.get(i).value);
                }
            }
        }

        return matches;
    }

    public static List<Match> getMatchesByDate(final int comp_id , String date, final Context context){

        List<Match> matches = new ArrayList<Match>();
        Call<List<Match>> result = WebRoutines.retrofitCall().matchesByDate(String.valueOf(comp_id), date);

        try {
            Response<List<Match>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = comp_id;
                item.type = ValuesInterface.MATCHES_BY_DATE;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.MATCHES_BY_DATE);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(comp_id == datas.get(i).id)
                {
                    matches = MatchMapper.toMatches(datas.get(i).value);
                }
            }
        }

        return matches;
    }

    public static List<Match> getMatchesComp(final int comp_id, final Context context){

        List<Match> matches = new ArrayList<Match>();
        Call<List<Match>> result = WebRoutines.retrofitCall().matchesComp(String.valueOf(comp_id));

        try {
            Response<List<Match>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = comp_id;
                item.type = ValuesInterface.MATCHES_COMP;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.MATCHES_COMP);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(comp_id == datas.get(i).id)
                {
                    matches = MatchMapper.toMatches(datas.get(i).value);
                }
            }
        }

        return matches;
    }

    public static Match getMatch(final int match_id, final Context context){

        Match match = new Match();
        Call<Match> result = WebRoutines.retrofitCall().Match(String.valueOf(match_id));

        try {
            Response<Match> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = match_id;
                item.type = ValuesInterface.MATCH;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.MATCH);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(match_id == datas.get(i).id)
                {
                    match = MatchMapper.toMatch(datas.get(i).value);
                }
            }
        }
        return match;
    }
}
