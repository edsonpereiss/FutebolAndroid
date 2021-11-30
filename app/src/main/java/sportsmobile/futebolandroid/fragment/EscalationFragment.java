package sportsmobile.futebolandroid.fragment;

import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import sportsmobile.futebolandroid.R;
import sportsmobile.futebolandroid.Utils.NonScrollListView;
import sportsmobile.futebolandroid.adapter.LineupAdapter;
import sportsmobile.futebolandroid.adapter.SubsAdapter;
import sportsmobile.futebolandroid.adapter.SubstitutionAdapter;
import sportsmobile.futebolandroid.model.Lineup;
import sportsmobile.futebolandroid.model.Match;
import sportsmobile.futebolandroid.model.Subs;
import sportsmobile.futebolandroid.model.Substitutions;
import sportsmobile.futebolandroid.request.LineupRequest;
import sportsmobile.futebolandroid.request.SubsRequest;
import sportsmobile.futebolandroid.request.SubstitutionsRequest;

/**
 * Created by edsonreis on 07/12/17.
 */

@EFragment(R.layout.fragment_escalation)
public class EscalationFragment extends Fragment
{

    @ViewById NonScrollListView lv_lineup_localteam;
    @ViewById NonScrollListView lv_lineup_visitorteam;
    @ViewById NonScrollListView lv_substitution_localteam;
    @ViewById NonScrollListView lv_substitution_visitorteam;
    @ViewById NonScrollListView lv_subs_localteam;
    @ViewById NonScrollListView lv_subs_visitorteam;
    @ViewById LinearLayout lay_localteam;
    @ViewById LinearLayout lay_visitorteam;

    LineupAdapter lineup_adapter;
    SubsAdapter subs_adapter;
    SubstitutionAdapter substitution_adapter;
    
    Lineup lineup;
    Substitutions substitutions;
    Subs subs;
    Match match;

    protected int count = 0;

    @AfterViews
    protected void viewsInitialized()
    {
        requestLineup();
        requestSubstitutions();
        requestSubs();

    }

    public void requestLineup()
    {
        match = (Match) this.getArguments().getSerializable("Match");
        lineup = LineupRequest.getLineup(match.match_id, getContext());
        //String json = "{\"id\":2185826,\"localteam\":[{\"id\":\"17304\",\"name\":\"CÃ¡ssio\",\"number\":\"12\",\"pos\":\"G\",\"slug\":\"cassio_br\"},{\"id\":\"\",\"name\":\"Pablo\",\"number\":\"3\",\"pos\":\"CD-L\",\"slug\":\"\"},{\"id\":\"225552\",\"name\":\"FabiÃ¡n Balbuena\",\"number\":\"4\",\"pos\":\"CD-R\",\"slug\":\"f_balbuena_br\"},{\"id\":\"\",\"name\":\"Gabriel\",\"number\":\"5\",\"pos\":\"DM\",\"slug\":\"\"},{\"id\":\"355909\",\"name\":\"Guilherme Arana\",\"number\":\"13\",\"pos\":\"LB\",\"slug\":\"g_arana_br\"},{\"id\":\"17306\",\"name\":\"Fagner\",\"number\":\"23\",\"pos\":\"RB\",\"slug\":\"fagner_br\"},{\"id\":\"78714\",\"name\":\"Rodriguinho\",\"number\":\"26\",\"pos\":\"CM-L\",\"slug\":\"rodriguinho_br\"},{\"id\":\"\",\"name\":\"Maycon\",\"number\":\"8\",\"pos\":\"CM-R\",\"slug\":\"\"},{\"id\":\"192525\",\"name\":\"Ã\u0081ngel Romero\",\"number\":\"11\",\"pos\":\"LM\",\"slug\":\"a_romero_br\"},{\"id\":\"19656\",\"name\":\"JÃ¡dson\",\"number\":\"10\",\"pos\":\"RM\",\"slug\":\"jadson_br\"},{\"id\":\"6414\",\"name\":\"JÃ´\",\"number\":\"7\",\"pos\":\"F\",\"slug\":\"jo_br\"}],\"visitorteam\":[{\"id\":\"\",\"name\":\"Jandrei\",\"number\":\"24\",\"pos\":\"G\",\"slug\":\"\"},{\"id\":\"\",\"name\":\"Victor Ramos\",\"number\":\"80\",\"pos\":\"CD-L\",\"slug\":\"\"},{\"id\":\"328076\",\"name\":\"Luiz OtÃ¡vio\",\"number\":\"21\",\"pos\":\"CD-R\",\"slug\":\"luiz_otavio_br\"},{\"id\":\"174478\",\"name\":\"Reinaldo\",\"number\":\"6\",\"pos\":\"LB\",\"slug\":\"reinaldo_br\"},{\"id\":\"33252\",\"name\":\"Apodi\",\"number\":\"22\",\"pos\":\"RB\",\"slug\":\"apodi_br\"},{\"id\":\"216429\",\"name\":\"JoÃ£o Pedro\",\"number\":\"2\",\"pos\":\"AM\",\"slug\":\"\"},{\"id\":\"171544\",\"name\":\"Andrei Girotto\",\"number\":\"8\",\"pos\":\"LM\",\"slug\":\"a_girotto_br\"},{\"id\":\"193049\",\"name\":\"Luiz Antonio\",\"number\":\"18\",\"pos\":\"RM\",\"slug\":\"l_antonio_br\"},{\"id\":\"32327\",\"name\":\"Wellington Paulista\",\"number\":\"9\",\"pos\":\"F\",\"slug\":\"w_paulista_br\"},{\"id\":\"148322\",\"name\":\"Arthur\",\"number\":\"17\",\"pos\":\"AM-L\",\"slug\":\"arthur_br\"},{\"id\":\"226564\",\"name\":\"Rossi\",\"number\":\"7\",\"pos\":\"AM-R\",\"slug\":\"rossi_br\"}]}";
        //lineup = LineupMapper.toLineup(json);
        listLineupLocal();
        listLineupVisitor();
    }

    public void requestSubstitutions()
    {
        match = (Match) this.getArguments().getSerializable("Match");
        substitutions = SubstitutionsRequest.getSubstitutions(match.match_id, getContext());
        //String json = "{\"id\":2185826,\"localteam\":[{\"minute\":\"44\",\"off_id\":\"\",\"off_name\":\"Pablo\",\"off_slug\":\"\",\"on_id\":\"329711\",\"on_name\":\"Pedro Henrique\",\"on_slug\":\"p_henrique_br\"},{\"minute\":\"69\",\"off_id\":\"192525\",\"off_name\":\"Ã\u0081ngel Romero\",\"off_slug\":\"a_romero_br\",\"on_id\":\"462617\",\"on_name\":\"LÃ©o JabÃ¡\",\"on_slug\":\"l_jaba_br\"},{\"minute\":\"78\",\"off_id\":\"\",\"off_name\":\"Gabriel\",\"off_slug\":\"\",\"on_id\":\"\",\"on_name\":\"Colin Kazim-Richards\",\"on_slug\":\"\"}],\"visitorteam\":[{\"minute\":\"75\",\"off_id\":\"32327\",\"off_name\":\"Wellington Paulista\",\"off_slug\":\"w_paulista_br\",\"on_id\":\"\",\"on_name\":\"Osman\",\"on_slug\":\"\"},{\"minute\":\"78\",\"off_id\":\"193049\",\"off_name\":\"Luiz Antonio\",\"off_slug\":\"l_antonio_br\",\"on_id\":\"170348\",\"on_name\":\"Nadson\",\"on_slug\":\"nadson_br\"},{\"minute\":\"85\",\"off_id\":\"226564\",\"off_name\":\"Rossi\",\"off_slug\":\"rossi_br\",\"on_id\":\"120553\",\"on_name\":\"NenÃ©m\",\"on_slug\":\"nenem_br\"}]}";
        //substitutions = SubstitutionsMapper.toSubstitution(json);
        listSubstitutionsVisitor();
        listSubstitutionsLocal();
    }

    public void requestSubs()
    {
        match = (Match) this.getArguments().getSerializable("Match");
        subs = SubsRequest.getSubs(match.match_id, getContext());
        //String json = "{\"id\":2185826,\"localteam\":[{\"id\":\"329711\",\"name\":\"Pedro Henrique\",\"number\":\"34\",\"pos\":\"Sub\",\"slug\":\"p_henrique_br\"},{\"id\":\"\",\"name\":\"Colin Kazim-Richards\",\"number\":\"18\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"462617\",\"name\":\"LÃ©o JabÃ¡\",\"number\":\"30\",\"pos\":\"Sub\",\"slug\":\"l_jaba_br\"},{\"id\":\"73192\",\"name\":\"Marquinhos Gabriel\",\"number\":\"31\",\"pos\":\"Sub\",\"slug\":\"marquinhos_gabriel_br\"},{\"id\":\"84752\",\"name\":\"Camacho\",\"number\":\"29\",\"pos\":\"Sub\",\"slug\":\"camacho_br\"},{\"id\":\"\",\"name\":\"Paulo Roberto\",\"number\":\"28\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"247922\",\"name\":\"Matheus Vidotto\",\"number\":\"1\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"136425\",\"name\":\"Walter\",\"number\":\"27\",\"pos\":\"Sub\",\"slug\":\"walter_br\"},{\"id\":\"\",\"name\":\"Clayton\",\"number\":\"9\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"396804\",\"name\":\"Marciel\",\"number\":\"22\",\"pos\":\"Sub\",\"slug\":\"marciel_br\"},{\"id\":\"\",\"name\":\"LÃ©o Santos\",\"number\":\"14\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"\",\"name\":\"Pedrinho\",\"number\":\"38\",\"pos\":\"Sub\",\"slug\":\"\"}],\"visitorteam\":[{\"id\":\"170348\",\"name\":\"Nadson\",\"number\":\"20\",\"pos\":\"Sub\",\"slug\":\"nadson_br\"},{\"id\":\"\",\"name\":\"Osman\",\"number\":\"27\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"120553\",\"name\":\"NenÃ©m\",\"number\":\"30\",\"pos\":\"Sub\",\"slug\":\"nenem_br\"},{\"id\":\"4968\",\"name\":\"Tulio de Melo\",\"number\":\"10\",\"pos\":\"Sub\",\"slug\":\"t_de_melo_br\"},{\"id\":\"61115\",\"name\":\"Artur MorÃ£es\",\"number\":\"1\",\"pos\":\"Sub\",\"slug\":\"artur_br\"},{\"id\":\"\",\"name\":\"MoisÃ©s Wolschick\",\"number\":\"23\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"74810\",\"name\":\"Diego Renan\",\"number\":\"16\",\"pos\":\"Sub\",\"slug\":\"d_renan_br\"},{\"id\":\"121698\",\"name\":\"Douglas Grolli\",\"number\":\"3\",\"pos\":\"Sub\",\"slug\":\"d_grolli_br\"},{\"id\":\"365417\",\"name\":\"Nathan\",\"number\":\"15\",\"pos\":\"Sub\",\"slug\":\"nathan_br\"},{\"id\":\"302812\",\"name\":\"Niltinho\",\"number\":\"11\",\"pos\":\"Sub\",\"slug\":\"niltinho_br\"},{\"id\":\"395709\",\"name\":\"Elias Curzel\",\"number\":\"12\",\"pos\":\"Sub\",\"slug\":\"\"},{\"id\":\"438564\",\"name\":\"FabrÃ\u00ADcio Bruno\",\"number\":\"14\",\"pos\":\"Sub\",\"slug\":\"f_bruno_br\"}]}";
        //subs = SubsMapper.toSub(json);
        listSubsLocal();
        listSubsVisitor();
    }

    private void listLineupLocal()
    {
        lineup_adapter = new LineupAdapter();
        lineup_adapter.LineupAdapter(lineup.localteam, "local", getContext());
        lv_lineup_localteam.setAdapter(lineup_adapter);
    }

    private void listSubstitutionsLocal()
    {
        substitution_adapter = new SubstitutionAdapter();
        substitution_adapter.SubstitutionAdapter(substitutions.localteam, "local", getContext());
        lv_substitution_localteam.setAdapter(substitution_adapter);

    }

    private void listSubsLocal()
    {
        subs_adapter = new SubsAdapter();
        subs_adapter.SubsAdapter(subs.localteam, "local", getContext());
        lv_subs_localteam.setAdapter(subs_adapter);
    }

    private void listLineupVisitor()
    {
        lineup_adapter = new LineupAdapter();
        lineup_adapter.LineupAdapter(lineup.visitorteam, "visitor", getContext());
        lv_lineup_visitorteam.setAdapter(lineup_adapter);
    }

    private void listSubstitutionsVisitor()
    {
        substitution_adapter = new SubstitutionAdapter();
        substitution_adapter.SubstitutionAdapter(substitutions.visitorteam, "visitor", getContext());
        lv_substitution_visitorteam.setAdapter(substitution_adapter);
    }

    private void listSubsVisitor()
    {
        subs_adapter = new SubsAdapter();
        subs_adapter.SubsAdapter(subs.visitorteam, "visitor", getContext());
        lv_subs_visitorteam.setAdapter(subs_adapter);
    }

}
