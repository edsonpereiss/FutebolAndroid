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
import sportsmobile.futebolandroid.adapter.CommentAdapter;
import sportsmobile.futebolandroid.mapper.CommentsMapper;
import sportsmobile.futebolandroid.model.Comment;

/**
 * Created by edsonreis on 07/12/17.
 */

@EFragment(R.layout.fragment_comments)
public class CommentFragment extends Fragment
{
    protected List<Comment> comments = new ArrayList<>();
    protected List<Comment> sort_comments = new ArrayList<>();;
    protected CommentAdapter comment_adapter;
    @ViewById ListView lv_comment;

    @AfterViews
    protected void viewsInitialized()
    {
        requestComment();
    }

    private void requestComment()
    {
        String json = "[{\"comment\":\"Foul by Kazim (Corinthians).\",\"comment_id\":388468760,\"id\":1712071426063510,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'\"},{\"comment\":\"Jandrei (Chapecoense) wins a free kick in the defensive half.\",\"comment_id\":388468761,\"id\":1712071426063590,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'\"},{\"comment\":\"Maycon (Corinthians) wins a free kick in the defensive half.\",\"comment_id\":388468762,\"id\":1712071426063640,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'+4\"},{\"comment\":\"Foul by NA¡dson (Chapecoense).\",\"comment_id\":388468763,\"id\":1712071426063670,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'+4\"},{\"comment\":\"Jandrei (Chapecoense) wins a free kick in the defensive half.\",\"comment_id\":388468764,\"id\":1712071426063700,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'\"},{\"comment\":\"Foul by Kazim (Corinthians).\",\"comment_id\":388468765,\"id\":1712071426063730,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'\"},{\"comment\":\"Offside, Chapecoense. Osman Junior tries a through ball, but Arthur is caught offside.\",\"comment_id\":388468766,\"id\":1712071426063770,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'+2\"},{\"comment\":\"Foul by Leo JabA¡ (Corinthians).\",\"comment_id\":388468767,\"id\":1712071426063800,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'+1\"},{\"comment\":\"Apodi (Chapecoense) wins a free kick in the attacking half.\",\"comment_id\":388468768,\"id\":1712071426063840,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'+1\"},{\"comment\":\"Delay over. They are ready to continue.\",\"comment_id\":388468769,\"id\":1712071426063870,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"90'\"},{\"comment\":\"Delay in match Jandrei (Chapecoense) because of an injury.\",\"comment_id\":388468770,\"id\":1712071426063901,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"89'\"},{\"comment\":\"Jandrei (Chapecoense) wins a free kick in the defensive half.\",\"comment_id\":388468771,\"id\":1712071426063940,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"89'\"},{\"comment\":\"Foul by JA´ (Corinthians).\",\"comment_id\":388468772,\"id\":1712071426063980,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"89'\"},{\"comment\":\"Foul by Osman Junior (Chapecoense).\",\"comment_id\":388468773,\"id\":1712071426064010,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"88'\"},{\"comment\":\"FabiA¡n Balbuena (Corinthians) wins a free kick in the defensive half.\",\"comment_id\":388468774,\"id\":1712071426064040,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"88'\"},{\"comment\":\"Substitution, Chapecoense. NenA©m replaces Rossi.\",\"comment_id\":388468775,\"id\":1712071426064080,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"85'\"},{\"comment\":\"Andrei Girotto (Chapecoense) is shown the yellow card for a bad foul.\",\"comment_id\":388468776,\"id\":1712071426064111,\"important\":\"1\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"84'\"},{\"comment\":\"Foul by Andrei Girotto (Chapecoense).\",\"comment_id\":388468777,\"id\":1712071426064150,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"84'\"},{\"comment\":\"Rodriguinho (Corinthians) wins a free kick in the attacking half.\",\"comment_id\":388468778,\"id\":1712071426064190,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"84'\"},{\"comment\":\"Attempt missed. Jadson (Corinthians) right footed shot from outside the box is high and wide to the right. Assisted by Fagner.\",\"comment_id\":388468779,\"id\":1712071426064312,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"83'\"},{\"comment\":\"Kazim (Corinthians) wins a free kick in the attacking half.\",\"comment_id\":388468780,\"id\":1712071426064351,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"79'\"},{\"comment\":\"Foul by Victor Ramos (Chapecoense).\",\"comment_id\":388468781,\"id\":1712071426064390,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"79'\"},{\"comment\":\"Substitution, Chapecoense. NA¡dson replaces Luiz AntA´nio.\",\"comment_id\":388468782,\"id\":1712071426064420,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"78'\"},{\"comment\":\"Substitution, Corinthians. Kazim replaces Gabriel.\",\"comment_id\":388468783,\"id\":1712071426064460,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"78'\"},{\"comment\":\"Attempt missed. Luiz AntA´nio (Chapecoense) left footed shot from outside the box is high and wide to the left. Assisted by Arthur.\",\"comment_id\":388468784,\"id\":1712071426064490,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"78'\"},{\"comment\":\"Substitution, Chapecoense. Osman Junior replaces Wellington Paulista.\",\"comment_id\":388468785,\"id\":1712071426064530,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"75'\"},{\"comment\":\"Foul by Apodi (Chapecoense).\",\"comment_id\":388468786,\"id\":1712071426064560,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"73'\"},{\"comment\":\"Leo JabA¡ (Corinthians) wins a free kick on the left wing.\",\"comment_id\":388468787,\"id\":1712071426064600,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"73'\"},{\"comment\":\"Foul by Leo JabA¡ (Corinthians).\",\"comment_id\":388468788,\"id\":1712071426064631,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"71'\"},{\"comment\":\"Apodi (Chapecoense) wins a free kick in the defensive half.\",\"comment_id\":388468789,\"id\":1712071426064670,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"71'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by Rodriguinho.\",\"comment_id\":388468790,\"id\":1712071426064710,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"69'\"},{\"comment\":\"Substitution, Corinthians. Leo JabA¡ replaces A\u0081ngel Romero.\",\"comment_id\":388468791,\"id\":1712071426064740,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"69'\"},{\"comment\":\"JoA£o Pedro (Chapecoense) wins a free kick in the defensive half.\",\"comment_id\":388468792,\"id\":1712071426064781,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"67'\"},{\"comment\":\"Foul by Fagner (Corinthians).\",\"comment_id\":388468793,\"id\":1712071426064810,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"67'\"},{\"comment\":\"Attempt missed. Andrei Girotto (Chapecoense) header from the right side of the six yard box is close, but misses to the left. Assisted by Reinaldo with a cross following a corner.\",\"comment_id\":388468794,\"id\":1712071426064840,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"65'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by Pedro Henrique.\",\"comment_id\":388468795,\"id\":1712071426064890,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"65'\"},{\"comment\":\"Fagner (Corinthians) wins a free kick in the defensive half.\",\"comment_id\":388468796,\"id\":1712071426064930,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"64'\"},{\"comment\":\"Wellington Paulista (Chapecoense) is shown the yellow card.\",\"comment_id\":388468797,\"id\":1712071426064970,\"important\":\"1\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"64'\"},{\"comment\":\"Foul by Wellington Paulista (Chapecoense).\",\"comment_id\":388468798,\"id\":1712071426065000,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"64'\"},{\"comment\":\"Attempt blocked. Arthur (Chapecoense) right footed shot from outside the box is blocked.\",\"comment_id\":388468799,\"id\":1712071426065040,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"64'\"},{\"comment\":\"Fagner (Corinthians) is shown the yellow card.\",\"comment_id\":388468800,\"id\":1712071426065071,\"important\":\"1\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"63'\"},{\"comment\":\"Foul by Fagner (Corinthians).\",\"comment_id\":388468801,\"id\":1712071426065110,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"62'\"},{\"comment\":\"Arthur (Chapecoense) wins a free kick in the attacking half.\",\"comment_id\":388468802,\"id\":1712071426065140,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"62'\"},{\"comment\":\"A\u0081ngel Romero (Corinthians) wins a free kick on the left wing.\",\"comment_id\":388468803,\"id\":1712071426065180,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"60'\"},{\"comment\":\"Foul by Apodi (Chapecoense).\",\"comment_id\":388468804,\"id\":1712071426065210,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"60'\"},{\"comment\":\"Goal!  Corinthians 1, Chapecoense 1. Wellington Paulista (Chapecoense) right footed shot from the right side of the six yard box to the top right corner.\",\"comment_id\":388468805,\"id\":1712071426065241,\"important\":\"1\",\"isgoal\":\"1\",\"match_id\":2185826,\"minute\":\"56'\"},{\"comment\":\"Arthur (Chapecoense) hits the bar with a header from the centre of the box. Assisted by Rossi with a cross.\",\"comment_id\":388468806,\"id\":1712071426065280,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"56'\"},{\"comment\":\"Attempt missed. Rodriguinho (Corinthians) right footed shot from outside the box is close, but misses to the right. Assisted by Guilherme Arana.\",\"comment_id\":388468807,\"id\":1712071426065310,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"55'\"},{\"comment\":\"Rodriguinho (Corinthians) wins a free kick in the defensive half.\",\"comment_id\":388468808,\"id\":1712071426065341,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"54'\"},{\"comment\":\"Dangerous play by Andrei Girotto (Chapecoense).\",\"comment_id\":388468809,\"id\":1712071426065380,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"54'\"},{\"comment\":\"Foul by Guilherme Arana (Corinthians).\",\"comment_id\":388468810,\"id\":1712071426065420,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"53'\"},{\"comment\":\"Rossi (Chapecoense) wins a free kick on the right wing.\",\"comment_id\":388468811,\"id\":1712071426065450,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"53'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by Guilherme Arana.\",\"comment_id\":388468812,\"id\":1712071426065491,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"51'\"},{\"comment\":\"Guilherme Arana (Corinthians) wins a free kick on the left wing.\",\"comment_id\":388468813,\"id\":1712071426065521,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"48'\"},{\"comment\":\"Foul by Apodi (Chapecoense).\",\"comment_id\":388468814,\"id\":1712071426065570,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"48'\"},{\"comment\":\"Attempt missed. Arthur (Chapecoense) header from very close range is just a bit too high. Assisted by Apodi with a cross.\",\"comment_id\":388468815,\"id\":1712071426065610,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"47'\"},{\"comment\":\"Second Half begins Corinthians 1, Chapecoense 0.\",\"comment_id\":388468816,\"id\":1712071426065640,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"45'\"},{\"comment\":\"First Half ends, Corinthians 1, Chapecoense 0.\",\"comment_id\":388468817,\"id\":1712071426065670,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"45'+3\"},{\"comment\":\"Offside, Chapecoense. Luiz OtA¡vio tries a through ball, but Arthur is caught offside.\",\"comment_id\":388468818,\"id\":1712071426065710,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"45'\"},{\"comment\":\"Substitution, Corinthians. Pedro Henrique replaces Pablo because of an injury.\",\"comment_id\":388468819,\"id\":1712071426065751,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"44'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by Jadson.\",\"comment_id\":388468820,\"id\":1712071426065780,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"44'\"},{\"comment\":\"Attempt blocked. JoA£o Pedro (Chapecoense) right footed shot from the centre of the box is blocked. Assisted by Apodi.\",\"comment_id\":388468821,\"id\":1712071426065820,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"44'\"},{\"comment\":\"Delay over. They are ready to continue.\",\"comment_id\":388468822,\"id\":1712071426065850,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"42'\"},{\"comment\":\"Delay in match Pablo (Corinthians) because of an injury.\",\"comment_id\":388468823,\"id\":1712071426065880,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"40'\"},{\"comment\":\"Rodriguinho (Corinthians) is shown the yellow card for a bad foul.\",\"comment_id\":388468824,\"id\":1712071426065940,\"important\":\"1\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"35'\"},{\"comment\":\"Foul by Rodriguinho (Corinthians).\",\"comment_id\":388468825,\"id\":1712071426065970,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"35'\"},{\"comment\":\"Apodi (Chapecoense) wins a free kick in the defensive half.\",\"comment_id\":388468826,\"id\":1712071426066000,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"35'\"},{\"comment\":\"Attempt missed. Luiz OtA¡vio (Chapecoense) header from the centre of the box misses to the left. Assisted by Reinaldo.\",\"comment_id\":388468827,\"id\":1712071426066040,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"32'\"},{\"comment\":\"A\u0081ngel Romero (Corinthians) wins a free kick in the attacking half.\",\"comment_id\":388468828,\"id\":1712071426066090,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"30'\"},{\"comment\":\"Foul by Apodi (Chapecoense).\",\"comment_id\":388468829,\"id\":1712071426066120,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"30'\"},{\"comment\":\"Attempt blocked. JoA£o Pedro (Chapecoense) right footed shot from outside the box is blocked. Assisted by Luiz AntA´nio.\",\"comment_id\":388468830,\"id\":1712071426066151,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"30'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by Fagner.\",\"comment_id\":388468831,\"id\":1712071426066181,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"29'\"},{\"comment\":\"Attempt blocked. Apodi (Chapecoense) right footed shot from outside the box is blocked.\",\"comment_id\":388468832,\"id\":1712071426066240,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"26'\"},{\"comment\":\"Offside, Chapecoense. Andrei Girotto tries a through ball, but Apodi is caught offside.\",\"comment_id\":388468833,\"id\":1712071426066280,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"24'\"},{\"comment\":\"Goal!  Corinthians 1, Chapecoense 0. JA´ (Corinthians) right footed shot from the centre of the box to the top right corner. Assisted by Rodriguinho.\",\"comment_id\":388468834,\"id\":1712071426066310,\"important\":\"1\",\"isgoal\":\"1\",\"match_id\":2185826,\"minute\":\"22'\"},{\"comment\":\"Delay over. They are ready to continue.\",\"comment_id\":388468835,\"id\":1712071426066340,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"21'\"},{\"comment\":\"Delay in match Rossi (Chapecoense) because of an injury.\",\"comment_id\":388468836,\"id\":1712071426066370,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"20'\"},{\"comment\":\"Foul by Wellington Paulista (Chapecoense).\",\"comment_id\":388468837,\"id\":1712071426066420,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"16'\"},{\"comment\":\"FabiA¡n Balbuena (Corinthians) wins a free kick in the defensive half.\",\"comment_id\":388468838,\"id\":1712071426066450,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"16'\"},{\"comment\":\"Attempt missed. Reinaldo (Chapecoense) left footed shot from long range on the right is too high from a direct free kick.\",\"comment_id\":388468839,\"id\":1712071426066490,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"15'\"},{\"comment\":\"Foul by Pablo (Corinthians).\",\"comment_id\":388468840,\"id\":1712071426066520,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"15'\"},{\"comment\":\"Apodi (Chapecoense) wins a free kick on the right wing.\",\"comment_id\":388468841,\"id\":1712071426066550,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"15'\"},{\"comment\":\"Rodriguinho (Corinthians) wins a free kick in the attacking half.\",\"comment_id\":388468842,\"id\":1712071426066610,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"11'\"},{\"comment\":\"Foul by Andrei Girotto (Chapecoense).\",\"comment_id\":388468843,\"id\":1712071426066641,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"11'\"},{\"comment\":\"Attempt missed. Rodriguinho (Corinthians) header from the centre of the box is close, but misses to the left. Assisted by Guilherme Arana with a cross.\",\"comment_id\":388468844,\"id\":1712071426066670,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"11'\"},{\"comment\":\"Attempt blocked. JoA£o Pedro (Chapecoense) left footed shot from the left side of the box is blocked. Assisted by Rossi.\",\"comment_id\":388468845,\"id\":1712071426066710,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"10'\"},{\"comment\":\"Corner,  Corinthians. Conceded by Jandrei.\",\"comment_id\":388468846,\"id\":1712071426066770,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"8'\"},{\"comment\":\"Attempt saved. A\u0081ngel Romero (Corinthians) right footed shot from outside the box is saved in the bottom left corner. Assisted by Gabriel.\",\"comment_id\":388468847,\"id\":1712071426066800,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"8'\"},{\"comment\":\"Rossi (Chapecoense) hits the left post with a right footed shot from the right side of the box.\",\"comment_id\":388468848,\"id\":1712071426066831,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"5'\"},{\"comment\":\"Attempt blocked. Wellington Paulista (Chapecoense) left footed shot from the centre of the box is blocked.\",\"comment_id\":388468849,\"id\":1712071426066870,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"5'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by CA¡ssio.\",\"comment_id\":388468850,\"id\":1712071426066920,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"3'\"},{\"comment\":\"Corner,  Chapecoense. Conceded by A\u0081ngel Romero.\",\"comment_id\":388468851,\"id\":1712071426066960,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"2'\"},{\"comment\":\"Attempt missed. JoA£o Pedro (Chapecoense) left footed shot from outside the box is high and wide to the left. Assisted by Andrei Girotto.\",\"comment_id\":388468852,\"id\":1712071426066990,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"2'\"},{\"comment\":\"Lineups are announced and players are warming up.\",\"comment_id\":388468853,\"id\":1712071426067030,\"important\":\"0\",\"isgoal\":\"0\",\"match_id\":2185826,\"minute\":\"-\"}]";
        comments = CommentsMapper.toComments(json);
        sortCommentbyMinute(comments);
        listComments();
    }


    private void sortCommentbyMinute(List<Comment> comments)
    {
        for(int i = 0; i < comments.size(); i++)
        {
            Comment comment = comments.get(i);

            if(comments.get(i).minute.contains("90'+"))
            {
                comment.minute = comments.get(i).minute.replace("0'+","");
            }

            if(comments.get(i).minute.contains("45'+"))
            {
                comment.minute =comments.get(i).minute.replace("5'+","");
            }

            if(comments.get(i).minute.contains("'"))
            {
                comment.minute = comments.get(i).minute.replace("'","");
            }

            if(comments.get(i).minute.contains("-"))
            {
                comment.minute = comments.get(i).minute.replace("-","0");
            }

            if(comments.get(i) != null)
            {
                sort_comments.add(comment);
            }
        }

        Collections.sort(sort_comments, new Comparator<Comment>()
        {
            public int compare(Comment o1, Comment o2)
            {
                return Integer.valueOf(o2.minute) - Integer.valueOf(o1.minute);
            }
        });

    }


    private void listComments()
    {
        comment_adapter = new CommentAdapter();
        comment_adapter.CommentAdapter(sort_comments, getContext());
        lv_comment.setAdapter(comment_adapter);
    }
}