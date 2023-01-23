import airline.Pilot;
import airline.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Velma", Rank.CAPTAIN, "ACB45YEW");
    }

    @Test
    public void haslicenceNumber(){
        assertEquals("ACB45YEW", pilot.getLicenceNumber());
    }

    @Test
    public void canFly(){
        assertEquals("Prepare for lift off", pilot.fly());
    }
}
