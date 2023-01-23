import airline.Passenger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Bob", 1);
    }

    @Test
    public void hasName(){
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void hasNumberofBags(){
        assertEquals(1, passenger.getNumberOfBags());
    }

    @Test
    public void hasEmptySeatNumber(){
        assertEquals("", passenger.getSeatNumber());
    }

    @Test
    public void hasEmptyFlightNumber(){
        assertEquals("", passenger.getFlightNumber());
    }

    @Test
    public void canAddSeatNumber(){
        passenger.setSeatNumber("36C");
        assertEquals("36C", passenger.getSeatNumber());
    }

    @Test
    public void canAddFlightNumber(){
        passenger.setFlightNumber("BA345");
        assertEquals("BA345", passenger.getFlightNumber());
    }


}
