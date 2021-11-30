package sportsmobile.futebolandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import sportsmobile.futebolandroid.Utils.SharedPreferences;
import sportsmobile.futebolandroid.item.FavoriteDialogItem;
import sportsmobile.futebolandroid.item.FavoriteDialogItem_;
import sportsmobile.futebolandroid.model.Standing;

/**
 * Created by edsonreis on 05/12/17.
 */

@EBean
public class FavoriteDialogAdapter extends BaseAdapter
{
    protected List<Standing> favorites = new ArrayList<>();
    protected Context context;
    protected Standing current_favorite = new Standing();

    public void FavoriteDialogAdapter(List<Standing> favorites, Context context)
    {
        this.favorites = favorites;
        this.context = context;
        this.current_favorite = SharedPreferences.loadTeamFavorite(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        FavoriteDialogItem favoritesItem;

        if (view == null)
        {
            favoritesItem = FavoriteDialogItem_.build(context);
        }
        else
        {
            favoritesItem = (FavoriteDialogItem) view;
        }

        favoritesItem.bind(getItem(position), current_favorite);
/*
        FavoriteDialogFragment dialog = new FavoriteDialogFragment();
        dialog.dismiss();
*/
        return favoritesItem;
    }


    @Override
    public int getCount() {
        return favorites.size();
    }

    @Override
    public Standing getItem(int position) {
        return favorites.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
