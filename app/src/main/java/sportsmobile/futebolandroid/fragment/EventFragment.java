package sportsmobile.futebolandroid.fragment;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.adapter.EventAdapter;
import sportsmobile.futebolandroid.model.Event;
import sportsmobile.futebolandroid.model.Match;
import sportsmobile.futebolandroid.request.EventRequest;

/**
 * Created by edsonreis on 07/12/17.
 */

@EFragment(R.layout.fragment_event)
public class EventFragment extends Fragment
{
    protected List<Event> events;
    protected List<Event> sort_events = new ArrayList<>();
    protected EventAdapter event_adapter;
    @ViewById ListView lv_event;
    Match match;

    @AfterViews
    protected void viewsInitialized()
    {
        requestEvent();
    }

    private void requestEvent()
    {
        match = (Match) this.getArguments().getSerializable("Match");
        events = EventRequest.getEvents(match.match_id, getContext());
        //String json = "[{\"assist\":\"\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507152228,\"match_id\":2185824,\"minute\":\"22\",\"player\":\"F. Santos\",\"player_id\":\"8968\",\"player_slug\":\"f_santos_br\",\"result\":\"\",\"team\":\"visitorteam\",\"type\":\"yellowcard\"},{\"assist\":\"\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507152338,\"match_id\":2185824,\"minute\":\"24\",\"player\":\"Matheus Savio\",\"player_id\":\"398674\",\"player_slug\":\"matheus_savio_br\",\"result\":\"[1-0]\",\"team\":\"localteam\",\"type\":\"goal\"},{\"assist\":\"R. Otero\",\"assist_id\":\"148555\",\"assist_slug\":\"r_otero_br\",\"extra_min\":\"\",\"id\":1711271507152458,\"match_id\":2185824,\"minute\":\"46\",\"player\":\"J. Cazares\",\"player_id\":\"169690\",\"player_slug\":\"j_cazares_br\",\"result\":\"\",\"team\":\"visitorteam\",\"type\":\"subst\"},{\"assist\":\"\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507152668,\"match_id\":2185824,\"minute\":\"59\",\"player\":\"Elias\",\"player_id\":\"34971\",\"player_slug\":\"elias_br\",\"result\":\"[1-1]\",\"team\":\"visitorteam\",\"type\":\"goal\"},{\"assist\":\"Not on pitch\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507152808,\"match_id\":2185824,\"minute\":\"59\",\"player\":\"R.\",\"player_id\":\"32329\",\"player_slug\":\"victor_br\",\"result\":\"\",\"team\":\"visitorteam\",\"type\":\"yellowcard\"},{\"assist\":\"Matheus Savio\",\"assist_id\":\"398674\",\"assist_slug\":\"matheus_savio_br\",\"extra_min\":\"\",\"id\":1711271507152958,\"match_id\":2185824,\"minute\":\"60\",\"player\":\"Rene\",\"player_id\":\"225802\",\"player_slug\":\"rene_br\",\"result\":\"\",\"team\":\"localteam\",\"type\":\"subst\"},{\"assist\":\"\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507153118,\"match_id\":2185824,\"minute\":\"65\",\"player\":\"M. Trauco\",\"player_id\":\"176390\",\"player_slug\":\"m_trauco_br\",\"result\":\"\",\"team\":\"localteam\",\"type\":\"yellowcard\"},{\"assist\":\"M. Trauco\",\"assist_id\":\"176390\",\"assist_slug\":\"m_trauco_br\",\"extra_min\":\"\",\"id\":1711271507153258,\"match_id\":2185824,\"minute\":\"76\",\"player\":\"Ederson\",\"player_id\":\"1270\",\"player_slug\":\"ederson_br\",\"result\":\"\",\"team\":\"localteam\",\"type\":\"subst\"},{\"assist\":\"Robinho\",\"assist_id\":\"157\",\"assist_slug\":\"robinho_br\",\"extra_min\":\"\",\"id\":1711271507153448,\"match_id\":2185824,\"minute\":\"80\",\"player\":\"Maicosuel\",\"player_id\":\"8978\",\"player_slug\":\"maicosuel_br\",\"result\":\"\",\"team\":\"visitorteam\",\"type\":\"subst\"},{\"assist\":\"Fred\",\"assist_id\":\"155\",\"assist_slug\":\"fred_br\",\"extra_min\":\"\",\"id\":1711271507153628,\"match_id\":2185824,\"minute\":\"81\",\"player\":\"R. Moura\",\"player_id\":\"9150\",\"player_slug\":\"r_moura_br\",\"result\":\"\",\"team\":\"visitorteam\",\"type\":\"subst\"},{\"assist\":\"\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507153818,\"match_id\":2185824,\"minute\":\"83\",\"player\":\"Everton\",\"player_id\":\"9333\",\"player_slug\":\"everton_br\",\"result\":\"\",\"team\":\"localteam\",\"type\":\"yellowcard\"},{\"assist\":\"O. Berrio\",\"assist_id\":\"74436\",\"assist_slug\":\"o_berrio_br\",\"extra_min\":\"\",\"id\":1711271507153968,\"match_id\":2185824,\"minute\":\"84\",\"player\":\"V. J.\",\"player_id\":\"\",\"player_slug\":\"\",\"result\":\"\",\"team\":\"localteam\",\"type\":\"subst\"},{\"assist\":\"\",\"assist_id\":\"\",\"assist_slug\":\"\",\"extra_min\":\"\",\"id\":1711271507154108,\"match_id\":2185824,\"minute\":\"84\",\"player\":\"R. Carioca\",\"player_id\":\"33519\",\"player_slug\":\"r_carioca_br\",\"result\":\"\",\"team\":\"visitorteam\",\"type\":\"yellowcard\"}]";
        //events = EventMapper.toEvents(json);
        sortEventByMinute(events);
        listEvent();
    }


    private void sortEventByMinute(List<Event> events)
    {

        for(int i = 0; i < events.size(); i++)
        {
            Event event = events.get(i);

            if(events.get(i).minute.contains("90+"))
            {
                event.minute = events.get(i).minute.replace("0+","");
            }

            if(events.get(i).minute.contains("45+"))
            {
                event.minute = events.get(i).minute.replace("5+","");
            }

            if(events.get(i).minute.contains("-"))
            {
                event.minute = events.get(i).minute.replace("-","0");
            }

            sort_events.add(event);
        }

        Collections.sort(sort_events, new Comparator<Event>()
        {
            public int compare(Event o1, Event o2)
            {
                return Integer.valueOf(o2.minute) - Integer.valueOf(o1.minute);
            }
        });

    }


    private void listEvent()
    {
        event_adapter = new EventAdapter();
        event_adapter.EventAdapter(sort_events, getContext());
        lv_event.setAdapter(event_adapter);
    }
}

