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
import sportsmobile.futebolandroid.mapper.SubstitutionsMapper;
import sportsmobile.futebolandroid.model.Substitutions;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class SubstitutionsRequest
{
    public static Substitutions getSubstitutions(final long id, final Context context){

        Substitutions substitutions = new Substitutions();
        Call<Substitutions> result = WebRoutines.retrofitCall().Substitutions(String.valueOf(id));

        try {
            Response<Substitutions> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = id;
                item.type = ValuesInterface.SUBSTITUTIONS;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.SUBSTITUTIONS);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(id == datas.get(i).id)
                {
                    substitutions = SubstitutionsMapper.toSubstitution(datas.get(i).value);
                }
            }
        }
        return substitutions;
    }
}
