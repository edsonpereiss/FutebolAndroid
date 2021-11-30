package sportsmobile.futebolandroid.Utils;

import android.content.Context;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sportsmobile.futebolandroid.database.Mensagens;
import sportsmobile.futebolandroid.database.MensagensScript;
import sportsmobile.futebolandroid.interfaces.ValuesInterface;
import sportsmobile.futebolandroid.mapper.MatchMapper;
import sportsmobile.futebolandroid.mapper.StandingsMapper;
import sportsmobile.futebolandroid.model.ItemDataBase;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 27/10/17.
 */

public class SharedPreferences {


    public static int CURRENT_COMPETITION = 1117;

    public static void saveMessage(Context context, String key, String content)
    {
        MensagensScript rMensagem = new MensagensScript(context);
        Mensagens mensagem;
        mensagem = rMensagem.findByTitulo(key);
        boolean exist;
        if (mensagem == null)
        {
            mensagem = new Mensagens();
            exist = false;
        }
        else
        {
            exist = true;
        }
        mensagem.titulo = key;
        mensagem.descricao = content;
        rMensagem.save(mensagem, exist);
    }

    public static String loadMessage(Context context, String key)
    {
        MensagensScript rMensagem = new MensagensScript(context);
        Mensagens mensagem;
        mensagem = rMensagem.findByTitulo(key);
        if (mensagem == null)
        {
            return "";
        }
        else
        {
            return mensagem.descricao;
        }
    }

    public static void saveData(Context context, List<ItemDataBase> database, String key)
    {
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(database);
        saveMessage(context, key, jsonFavorites);
    }

    public static ArrayList<ItemDataBase> loadData(Context context, String key)
    {
        List<ItemDataBase> data;
        String jsonFavorites = loadMessage(context, key);
        if (!jsonFavorites.equals(""))
        {
            Gson gson = new Gson();
            ItemDataBase[] data_items = gson.fromJson(jsonFavorites, ItemDataBase[].class);
            data = Arrays.asList(data_items);
            data = new ArrayList<ItemDataBase>(data);
        }else
            return null;
        return (ArrayList<ItemDataBase>) data;
    }


    public static void checkData(ItemDataBase check_data, Context context, String key) {

        ArrayList<ItemDataBase> datas = loadData(context,key);

        if(datas != null){

            for(int i = 0; i < datas.size(); i++)
            {
                if (datas.get(i).id == check_data.id)
                {
                    datas.remove(i);
                }
            }
        }else
        {
            datas = new ArrayList<>();
        }

        datas.add(check_data);
        saveData(context, datas, key);

    }


    public static Standing loadTeamFavorite(Context context) {

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.TEAM_FAVORITE);
        Standing team_favorite = new Standing();

        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                team_favorite = StandingsMapper.toStanding(datas.get(i).value);
            }
        }
        else
        {
           team_favorite = null;
        }

        return team_favorite;
    }

    public static void saveTeamFavorite(Standing standing, Context context) {

        ItemDataBase item = new ItemDataBase();
        Gson gson = new Gson();
        item.id =  CURRENT_COMPETITION;
        item.type = ValuesInterface.TEAM_FAVORITE;
        item.value = String.valueOf(gson.toJson(standing));

        SharedPreferences.checkData(item, context, item.type);
    }
}
