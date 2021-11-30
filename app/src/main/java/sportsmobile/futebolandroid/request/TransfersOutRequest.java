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
import sportsmobile.futebolandroid.mapper.TransfersOutMapper;
import sportsmobile.futebolandroid.model.ItemDataBase;
import sportsmobile.futebolandroid.model.TransfersOut;

/**
 * Created by edsonreis on 31/10/17.
 */

public class TransfersOutRequest
{
    public static List<TransfersOut> getTransfersOut(final int comp_id, final Context context){

        List<TransfersOut> transfers_in = new ArrayList<TransfersOut>();
        Call<List<TransfersOut>> result = WebRoutines.retrofitCall().TransfersOut(String.valueOf(comp_id));

        try {
            Response<List<TransfersOut>> response = result.execute();
            if(response.isSuccessful() && response.code() == 200 && WebRoutines.checkNetwork(context))
            {
                String json = new Gson().toJson(response.body());
                ItemDataBase item = new ItemDataBase();

                item.id = comp_id;
                item.type = ValuesInterface.TRANSFERS_OUT;
                item.value = json;

                SharedPreferences.checkData(item,context, item.type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemDataBase> datas = SharedPreferences.loadData(context, ValuesInterface.TRANSFERS_OUT);
        if(datas != null)
        {
            for(int i = 0; i < datas.size(); i++)
            {
                if(comp_id == datas.get(i).id)
                {
                    transfers_in = TransfersOutMapper.toTransfersOut(datas.get(i).value);
                }
            }
        }

        return transfers_in;
    }
}
