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
import sportsmobile.futebolandroid.model.ClubIntl;
import sportsmobile.futebolandroid.model.ItemDataBase;

/**
 * Created by edsonreis on 31/10/17.
 */

public class ClubIntlRequest
{
    public static List<ClubIntl> getClubsIntl(final int player_id, final Context context){

        List<ClubIntl> clubs_intl = new ArrayList<ClubIntl>();
        Call<List<ClubIntl>> result = WebRoutines.retrofitCall().ClubsIntl(String.valueOf(player_id));

        try
        {
            Response<List<ClubIntl>> response = result.execute();

            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = player_id;
                item.type = ValuesInterface.CLUBS_INTL;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.CLUBS_INTL);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(player_id == datas.get(i).id)
                {
                    clubs_intl = ClubIntlMapper.toClubsIntl(datas.get(i).value);
                }
            }
        }

        return clubs_intl;
    }
}
