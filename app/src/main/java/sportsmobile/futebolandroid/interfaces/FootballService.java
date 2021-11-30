package sportsmobile.futebolandroid.interfaces;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sportsmobile.futebolandroid.model.Club;
import sportsmobile.futebolandroid.model.ClubIntl;
import sportsmobile.futebolandroid.model.Comment;
import sportsmobile.futebolandroid.model.Commentarie;
import sportsmobile.futebolandroid.model.Competition;
import sportsmobile.futebolandroid.model.Cup;
import sportsmobile.futebolandroid.model.Event;
import sportsmobile.futebolandroid.model.Lineup;
import sportsmobile.futebolandroid.model.Match;
import sportsmobile.futebolandroid.model.National;
import sportsmobile.futebolandroid.model.Player;
import sportsmobile.futebolandroid.model.Scorer;
import sportsmobile.futebolandroid.model.Sidelined;
import sportsmobile.futebolandroid.model.Squad;
import sportsmobile.futebolandroid.model.Standing;
import sportsmobile.futebolandroid.model.Statistics;
import sportsmobile.futebolandroid.model.Subs;
import sportsmobile.futebolandroid.model.Substitutions;
import sportsmobile.futebolandroid.model.Team;
import sportsmobile.futebolandroid.model.TransfersIn;
import sportsmobile.futebolandroid.model.TransfersOut;

/**
 * Created by edsonreis on 25/10/17.
 */

public interface FootballService {

    String URL_BASE = "http://35.197.59.69/";
    String TOKEN = "sDotZce9EUOtGKhAwLYwjw";


    @GET("football/api/club/" + TOKEN + "/{player_id}")
    Call<List<Club>> Clubs(@Path("player_id") String player_id
    );

    @GET("football/api/clubintl/" + TOKEN + "/{player_id}")
    Call<List<ClubIntl>> ClubsIntl(@Path("player_id") String player_id
    );

    @GET("football/api/commentarie/" + TOKEN + "/{id}")
    Call<Commentarie> Commentarie(@Path("id") String id
    );

    @GET("football/api/comments/" + TOKEN + "/{id}")
    Call<List<Comment>> Comments(@Path("id") String id
    );

    @GET("football/api/competition/" + TOKEN + "/{id}")
    Call<Competition> Competition(@Path("id") String id
    );

    @GET("football/api/competitions/" + TOKEN )
    Call<List<Competition>> Competitions();

    @GET("football/api/cup/" + TOKEN + "/{player_id}")
    Call<List<Cup>> Cups(@Path("player_id") String player_id
    );

    @GET("football/api/event/" + TOKEN + "/{match_id}")
    Call<List<Event>> Events(@Path("match_id") String player_id
    );

    @GET("football/api/lineup/" + TOKEN + "/{id}")
    Call<Lineup> Lineup(@Path("id") String id
    );

    @GET("football/api/match/" + TOKEN + "/{match_id}")
    Call<Match> Match(@Path("match_id") String match_id
    );

    @GET("football/api/matchesByDate/" + TOKEN + "/{comp_id}/{date}")
    Call<List<Match>> matchesByDate(@Path("comp_id") String comp_id,
                                    @Path("date") String date
    );

    @GET("football/api/matchesByDates/" + TOKEN + "/{comp_id}/{init_date}/{end_date}")
    Call<List<Match>> matchesByDates(@Path("comp_id") String comp_id,
                                     @Path("init_date") String init_date,
                                     @Path("end_date") String end_date
    );

    @GET("football/api/matchesComp/" + TOKEN + "/{comp_id}")
    Call<List<Match>> matchesComp(@Path("comp_id") String comp_id
    );

    @GET("football/api/national/" + TOKEN + "/{player_id}")
    Call<List<National>> Nationals(@Path("player_id") String player_id
    );

    @GET("football/api/player/" + TOKEN + "/{id}")
    Call<Player> Player(@Path("id") String id
    );

    @GET("football/api/sidelined/" + TOKEN + "/{team_id}")
    Call<List<Sidelined>> Sidelineds(@Path("team_id") String team_id
    );

    @GET("football/api/squad/" + TOKEN + "/{team_id}")
    Call<List<Squad>> Squads(@Path("team_id") String team_id
    );

    @GET("football/api/standings/" + TOKEN + "/{comp_id}")
    Call<List<Standing>> Standings(@Path("comp_id") String comp_id
    );

    @GET("football/api/statistics/" + TOKEN + "/{id}")
    Call<Statistics> Statistics(@Path("id") String id
    );

    @GET("football/api/subs/" + TOKEN + "/{id}")
    Call<Subs> Subs(@Path("id") String id
    );

    @GET("football/api/substitutions/" + TOKEN + "/{id}")
    Call<Substitutions> Substitutions(@Path("id") String id
    );

    @GET("football/api/team/" + TOKEN + "/{id}")
    Call<Team> Team(@Path("id") String id
    );

    @GET("football/api/teams/" + TOKEN + "/{comp_id}")
    Call<List<Team>> Teams(@Path("comp_id") String comp_id
    );

    @GET("football/api/transfersin/" + TOKEN + "/{team_id}")
    Call<List<TransfersIn>> TransfersIn(@Path("comp_id") String team_id
    );

    @GET("football/api/transfersout/" + TOKEN + "/{team_id}")
    Call<List<TransfersOut>> TransfersOut(@Path("comp_id") String team_id
    );

    @GET("football/api/playergoals/" + TOKEN + "/{comp_id}")
    Call<List<Scorer>> Scorers(@Path("comp_id") String comp_id
    );

}
