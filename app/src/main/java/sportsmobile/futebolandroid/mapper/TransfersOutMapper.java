package sportsmobile.futebolandroid.mapper;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import sportsmobile.futebolandroid.model.TransfersOut;

/**
 * Created by edsonreis on 30/10/17.
 */

public class TransfersOutMapper
{
    private static Gson gson = new Gson();

    public  static List<TransfersOut> toTransfersOut(String json)
    {
        return  Arrays.asList(gson.fromJson(json,
                TransfersOut[].class));
    }

    public  static  TransfersOut toTransferOut(String json)
    {
        return gson.fromJson(json,TransfersOut.class);
    }
}
