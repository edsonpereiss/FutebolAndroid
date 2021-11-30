package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import sportsmobile.futebolandroid.model.TransfersIn;

/**
 * Created by edsonreis on 30/10/17.
 */

public class TransfersInMapper 
{
    private static Gson gson = new Gson();

    public  static List<TransfersIn> toTransfersIn(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                TransfersIn[].class));
    }

    public  static  TransfersIn toTransferIn(String json)
    {
        return gson.fromJson(json,TransfersIn.class);
    }
}
