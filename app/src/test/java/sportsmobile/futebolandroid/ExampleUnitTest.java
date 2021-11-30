package sportsmobile.futebolandroid;

import org.junit.Test;

import sportsmobile.futebolandroid.request.MatchRequest;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMatchesByDates() throws Exception {
      //  MatchRequest.getMatchesByDates("2.0/matches?comp_id=1141&from_date=01.10.2017&to_date=02.10.2017&Authorization=565ec012251f932ea4000001b1d6d97603114f036764e4a8c6e4516c/","","");
    }
}