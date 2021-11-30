package sportsmobile.futebolandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Statistics {

    @SerializedName("id")
    public long id;
    @SerializedName("team_slug")
    public String team_slug;
    @SerializedName("rank")
    public String rank;
    @SerializedName("wins")
    public String wins;
    @SerializedName("wins_home")
    public String wins_home;
    @SerializedName("wins_away")
    public String wins_away;
    @SerializedName("draws")
    public String draws;
    @SerializedName("draws_home")
    public String draws_home;
    @SerializedName("draws_away")
    public String draws_away;
    @SerializedName("losses")
    public String losses;
    @SerializedName("losses_home")
    public String losses_home;
    @SerializedName("losses_away")
    public String losses_away;
    @SerializedName("clean_sheets")
    public String clean_sheets;
    @SerializedName("clean_sheets_home")
    public String clean_sheets_home;
    @SerializedName("clean_sheets_away")
    public String clean_sheets_away;
    @SerializedName("goals")
    public String goals;
    @SerializedName("goals_home")
    public String goals_home;
    @SerializedName("goals_away")
    public String goals_away;
    @SerializedName("goals_conceded")
    public String goals_conceded;
    @SerializedName("goals_conceded_home")
    public String goals_conceded_home;
    @SerializedName("goals_conceded_away")
    public String goals_conceded_away;
    @SerializedName("avg_goals_per_game_scored")
    public String avg_goals_per_game_scored;
    @SerializedName("avg_goals_per_game_scored_home")
    public String avg_goals_per_game_scored_home;
    @SerializedName("avg_goals_per_game_scored_away")
    public String avg_goals_per_game_scored_away;
    @SerializedName("avg_goals_per_game_conceded")
    public String avg_goals_per_game_conceded;
    @SerializedName("avg_goals_per_game_conceded_home")
    public String avg_goals_per_game_conceded_home;
    @SerializedName("avg_goals_per_game_conceded_away")
    public String avg_goals_per_game_conceded_away;
    @SerializedName("avg_first_goal_scored")
    public String avg_first_goal_scored;
    @SerializedName("avg_first_goal_scored_home")
    public String avg_first_goal_scored_home;
    @SerializedName("avg_first_goal_scored_away")
    public String avg_first_goal_scored_away;
    @SerializedName("avg_first_goal_conceded")
    public String avg_first_goal_conceded;
    @SerializedName("avg_first_goal_conceded_home")
    public String avg_first_goal_conceded_home;
    @SerializedName("avg_first_goal_conceded_away")
    public String avg_first_goal_conceded_away;
    @SerializedName("failed_to_score")
    public String failed_to_score;
    @SerializedName("failed_to_score_home")
    public String failed_to_score_home;
    @SerializedName("failed_to_score_away")
    public String failed_to_score_away;
    @SerializedName("biggest_defeat")
    public String biggest_defeat;
    @SerializedName("biggest_defeat_home")
    public String biggest_defeat_home;
    @SerializedName("biggest_defeat_away")
    public String biggest_defeat_away;
    @SerializedName("scoring_minutes_0_15_pct")
    public String scoring_minutes_0_15_pct;
    @SerializedName("scoring_minutes_0_15_cnt")
    public String scoring_minutes_0_15_cnt;
    @SerializedName("scoring_minutes_15_30_pct")
    public String scoring_minutes_15_30_pct;
    @SerializedName("scoring_minutes_15_30_cnt")
    public String scoring_minutes_15_30_cnt;
    @SerializedName("scoring_minutes_30_45_pct")
    public String scoring_minutes_30_45_pct;
    @SerializedName("scoring_minutes_30_45_cnt")
    public String scoring_minutes_30_45_cnt;
    @SerializedName("scoring_minutes_45_60_pct")
    public String scoring_minutes_45_60_pct;
    @SerializedName("scoring_minutes_45_60_cnt")
    public String scoring_minutes_45_60_cnt;
    @SerializedName("scoring_minutes_60_75_pct")
    public String scoring_minutes_60_75_pct;
    @SerializedName("scoring_minutes_60_75_cnt")
    public String scoring_minutes_60_75_cnt;
    @SerializedName("scoring_minutes_75_90_pct")
    public String scoring_minutes_75_90_pct;
    @SerializedName("scoring_minutes_75_90_cnt")
    public String scoring_minutes_75_90_cnt;

    public Statistics()
    {

    }

    public Statistics(long id,
                      String team_slug,
                      String rank,
                      String wins,
                      String wins_home,
                      String wins_away,
                      String draws,
                      String draws_home,
                      String draws_away,
                      String losses,
                      String losses_home,
                      String losses_away,
                      String clean_sheets,
                      String clean_sheets_home,
                      String clean_sheets_away,
                      String goals,
                      String goals_home,
                      String goals_away,
                      String goals_conceded,
                      String goals_conceded_home,
                      String goals_conceded_away,
                      String avg_goals_per_game_scored,
                      String avg_goals_per_game_scored_home,
                      String avg_goals_per_game_scored_away,
                      String avg_goals_per_game_conceded,
                      String avg_goals_per_game_conceded_home,
                      String avg_goals_per_game_conceded_away,
                      String avg_first_goal_scored,
                      String avg_first_goal_scored_home,
                      String avg_first_goal_scored_away,
                      String avg_first_goal_conceded,
                      String avg_first_goal_conceded_home,
                      String avg_first_goal_conceded_away,
                      String failed_to_score,
                      String failed_to_score_home,
                      String failed_to_score_away,
                      String biggest_defeat,
                      String biggest_defeat_home,
                      String biggest_defeat_away,
                      String scoring_minutes_0_15_pct,
                      String scoring_minutes_0_15_cnt,
                      String scoring_minutes_15_30_pct,
                      String scoring_minutes_15_30_cnt,
                      String scoring_minutes_30_45_pct,
                      String scoring_minutes_30_45_cnt,
                      String scoring_minutes_45_60_pct,
                      String scoring_minutes_45_60_cnt,
                      String scoring_minutes_60_75_pct,
                      String scoring_minutes_60_75_cnt,
                      String scoring_minutes_75_90_pct,
                      String scoring_minutes_75_90_cnt
    )
    {
        this.id = id;
        this.team_slug = team_slug;
        this.rank = rank;
        this.wins = wins;
        this.wins_home = wins_home;
        this.wins_away = wins_away;
        this.draws = draws;
        this.draws_home = draws_home;
        this.draws_away = draws_away;
        this.losses = losses;
        this.losses_home = losses_home;
        this.losses_away = losses_away;
        this.clean_sheets = clean_sheets;
        this.clean_sheets_home = clean_sheets_home;
        this.clean_sheets_away = clean_sheets_away;
        this.goals = goals;
        this.goals_home = goals_home;
        this.goals_away = goals_away;
        this.goals_conceded = goals_conceded;
        this.goals_conceded_home = goals_conceded_home;
        this.goals_conceded_away = goals_conceded_away;
        this.avg_goals_per_game_scored = avg_goals_per_game_scored;
        this.avg_goals_per_game_scored_home = avg_goals_per_game_scored_home;
        this.avg_goals_per_game_scored_away = avg_goals_per_game_scored_away;
        this.avg_goals_per_game_conceded = avg_goals_per_game_conceded;
        this.avg_goals_per_game_conceded_home = avg_goals_per_game_conceded_home;
        this.avg_goals_per_game_conceded_away = avg_goals_per_game_conceded_away;
        this.avg_first_goal_scored = avg_first_goal_scored;
        this.avg_first_goal_scored_home = avg_first_goal_scored_home;
        this.avg_first_goal_scored_away = avg_first_goal_scored_away;
        this.avg_first_goal_conceded = avg_first_goal_conceded;
        this.avg_first_goal_conceded_home = avg_first_goal_conceded_home;
        this.avg_first_goal_conceded_away = avg_first_goal_conceded_away;
        this.failed_to_score = failed_to_score;
        this.failed_to_score_home = failed_to_score_home;
        this.failed_to_score_away = failed_to_score_away;
        this.biggest_defeat = biggest_defeat;
        this.biggest_defeat_home = biggest_defeat_home;
        this.biggest_defeat_away = biggest_defeat_away;
        this.scoring_minutes_0_15_pct = scoring_minutes_0_15_pct;
        this.scoring_minutes_0_15_cnt = scoring_minutes_0_15_cnt;
        this.scoring_minutes_15_30_pct = scoring_minutes_15_30_pct;
        this.scoring_minutes_15_30_cnt = scoring_minutes_15_30_cnt;
        this.scoring_minutes_30_45_pct = scoring_minutes_30_45_pct;
        this.scoring_minutes_30_45_cnt = scoring_minutes_30_45_cnt;
        this.scoring_minutes_45_60_pct = scoring_minutes_45_60_pct;
        this.scoring_minutes_45_60_cnt = scoring_minutes_45_60_cnt;
        this.scoring_minutes_60_75_pct = scoring_minutes_60_75_pct;
        this.scoring_minutes_60_75_cnt = scoring_minutes_60_75_cnt;
        this.scoring_minutes_75_90_pct = scoring_minutes_75_90_pct;
        this.scoring_minutes_75_90_cnt = scoring_minutes_75_90_cnt;
    }
}
