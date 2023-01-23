import airline.Plane;
import airline.PlaneType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasPlaneType(){
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void hasCapacity(){
        assertEquals(416, plane.getPlaneType().getCapacity());
    }

    @Test
    public void hasTotalWeight(){
        assertEquals(5000, plane.getPlaneType().getTotalWeight(), 0.0);
    }

}
