package sportsmobile.futebolandroid.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsonreis on 30/10/17.
 */

public class Subs {

    public long id;
    public List<SubsItem> localteam = new ArrayList<SubsItem>();
    public List<SubsItem> visitorteam = new ArrayList<SubsItem>();

    public Subs()
    {

    }

    public Subs(long id,
                List<SubsItem> localteam,
                List<SubsItem> visitorteam
    )
    {
        this.id = id;
        this.localteam = localteam;
        this.visitorteam = visitorteam;
    }

}
