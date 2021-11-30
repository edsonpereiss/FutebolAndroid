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
import sportsmobile.futebolandroid.mapper.CommentsMapper;
import sportsmobile.futebolandroid.model.Comment;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class CommentsRequest
{
    public static List<Comment> getComments(final int id, final Context context){

        List<Comment> comments = new ArrayList<Comment>();
        Call<List<Comment>> result = WebRoutines.retrofitCall().Comments(String.valueOf(id));

        try {
            Response<List<Comment>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = id;
                item.type = ValuesInterface.COMMENTS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.COMMENTS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(id == datas.get(i).id)
                {
                    comments = CommentsMapper.toComments(datas.get(i).value);
                }
            }
        }

        return comments;
    }
}
