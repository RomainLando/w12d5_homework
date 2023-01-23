import airline.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FlightTest {

    Flight flight;
    Pilot pilot;
    Passenger passenger;
    Passenger passenger1;
    Passenger passenger2;
    CabinCrewMember cabinCrewMember;
    Plane plane;

    @Before
    public void before(){
        pilot = new Pilot("Velma", Rank.CAPTAIN, "ACE4263R");
        passenger = new Passenger("Shaggy", 1);
        passenger1 = new Passenger("Scooby", 1);
        passenger2 = new Passenger("Daphne", 1);
        cabinCrewMember = new CabinCrewMember("Fred", Rank.ATTENDANT);
        plane = new Plane(PlaneType.PRIVATE);
        flight = new Flight(pilot, plane, "BA567", Airport.EDI, Airport.MAN, "2023/03/01 10:15");
    }

    @Test
    public void hasPilot(){
        assertEquals("Velma", flight.getPilot().getName());
    }

    @Test
    public void hasNoPassengers(){
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    public void hasNoCrewMembers(){
        assertEquals(0, flight.getNumberOfCrewMembers());
    }

    @Test
    public void hasPlaneWithCapacity(){
        assertEquals(2, flight.getPlane().getPlaneType().getCapacity());
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("BA567", flight.getFlightNumber());
    }

    @Test
    public void hasDepartureAirport(){
        assertEquals("Manchester", flight.getDepartureLocation().getCity());
    }

    @Test
    public void hasDestinationAirport(){
        assertEquals("Edinburgh", flight.getDestination().getCity());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals("2023/03/01 10:15", flight.getDepartureTime());
    }

    @Test
    public void canAddPassengers(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getNumberOfPassengers());
        assertEquals(1, flight.numberOfAvailableSeats());
    }

    @Test
    public void CanNotAddPassengersWhenAllSeatsTaken(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        assertEquals(2, flight.getNumberOfPassengers());
        assertEquals(0, flight.numberOfAvailableSeats());
    }

    @Test
    public void CanBookPassenger(){
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getNumberOfPassengers());
        assertEquals(1, flight.numberOfAvailableSeats());
        assertEquals("BA567", flight.getPassengers().get(0).getFlightNumber());
        assertEquals("Seat 13", flight.getPassengers().get(0).getSeatNumber());
    }

    @Test
    public void CanNotBookPassengerIfFlightFull(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(2, flight.getNumberOfPassengers());
        assertEquals(0, flight.numberOfAvailableSeats());
        assertEquals("BA567", flight.getPassengers().get(0).getFlightNumber());
        assertEquals("BA567", flight.getPassengers().get(1).getFlightNumber());
        assertEquals("Seat 13", flight.getPassengers().get(0).getSeatNumber());
        assertEquals("Seat 04", flight.getPassengers().get(1).getSeatNumber());
    }

    @Test
    public void bagWeightCalculated(){
        assertEquals(2.5, FlightManager.calculateAllowedBagWeight(flight), 0.0);
    }

    @Test
    public void initialAllocatedWeightIsAvailable(){
        assertEquals(0, FlightManager.calculateBookedWeight(flight), 0.0);
        assertEquals(5, FlightManager.calculateRemainingWeight(flight), 0.0);
    }

    @Test
    public void WeightCalculationsChangeAfterPassengerAdded(){
        flight.bookPassenger(passenger);
        assertEquals(2.5, FlightManager.calculateBookedWeight(flight), 0.0);
        assertEquals(2.5, FlightManager.calculateRemainingWeight(flight), 0.0);
    }

    @Test
    public void WeightCalculationsChangeFlightIsFull(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger1);
        assertEquals(5, FlightManager.calculateBookedWeight(flight), 0.0);
        assertEquals(0, FlightManager.calculateRemainingWeight(flight), 0.0);
    }
}
