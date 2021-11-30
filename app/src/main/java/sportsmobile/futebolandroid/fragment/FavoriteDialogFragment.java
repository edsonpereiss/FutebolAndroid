package sportsmobile.futebolandroid.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.adapter.FavoriteDialogAdapter;
import sportsmobile.futebolandroid.model.Standing;
import sportsmobile.futebolandroid.request.StandingsRequest;


/**
 * Created by edsonreis on 05/12/17.
 */

@EFragment(R.layout.dialog_favorite)
public class FavoriteDialogFragment extends DialogFragment
{
}
