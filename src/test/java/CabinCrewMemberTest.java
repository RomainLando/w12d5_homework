import airline.CabinCrewMember;
import airline.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    CabinCrewMember cabinCrewMember;

    @Before
    public void before(){
        cabinCrewMember = new CabinCrewMember("Theo", Rank.ATTENDANT);
    }

    @Test
    public void hasName(){
        assertEquals("Theo", cabinCrewMember.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(Rank.ATTENDANT, cabinCrewMember.getRank());
    }

    @Test
    public void canAnnounce(){
        assertEquals("We hope you enjoy your flight", cabinCrewMember.announce());
    }
}
