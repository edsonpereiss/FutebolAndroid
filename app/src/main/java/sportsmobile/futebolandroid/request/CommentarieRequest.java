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
import sportsmobile.futebolandroid.mapper.CommentarieMapper;
import sportsmobile.futebolandroid.model.ItemDataBase;
import sportsmobile.futebolandroid.model.Commentarie;

/**
 * Created by edsonreis on 31/10/17.
 */

public class CommentarieRequest
{
    public static Commentarie getCommentarie(final int id, final Context context){

        Commentarie commentarie = new Commentarie();
        Call<Commentarie> result = WebRoutines.retrofitCall().Commentarie(String.valueOf(id));

        try {
            Response<Commentarie> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = id;
                item.type = ValuesInterface.COMMENTARIE;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.COMMENTARIE);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(id == datas.get(i).id)
                {
                    commentarie = CommentarieMapper.toCommentarie(datas.get(i).value);
                }
            }
        }
        return commentarie;
    }
}
