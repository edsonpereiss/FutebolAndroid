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
import sportsmobile.futebolandroid.mapper.TeamMapper;
import sportsmobile.futebolandroid.model.Team;
import sportsmobile.futebolandroid.model.ItemDataBase;


/**
 * Created by edsonreis on 31/10/17.
 */

public class TeamRequest
{
    public static Team getTeam(final int id, final Context context){

        Team team = new Team();
        Call<Team> result = WebRoutines.retrofitCall().Team(String.valueOf(id));

        try {
            Response<Team> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = id;
                item.type = ValuesInterface.TEAM;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.TEAM);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(id == datas.get(i).id)
                {
                    team = TeamMapper.toTeam(datas.get(i).value);
                }
            }
        }
        return team;
    }

    public static List<Team> getTeams(final int comp_id, final Context context){

        List<Team> teams = new ArrayList<Team>();
        Call<List<Team>> result = WebRoutines.retrofitCall().Teams(String.valueOf(comp_id));

        try {
            Response<List<Team>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = comp_id;
                item.type = ValuesInterface.TEAMS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.TEAMS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(comp_id == datas.get(i).id)
                {
                    teams = TeamMapper.toTeams(datas.get(i).value);
                }
            }
        }

        return teams;
    }
}
