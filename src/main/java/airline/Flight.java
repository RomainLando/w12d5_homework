package airline;
import java.util.ArrayList;

public class Flight {

    private Pilot pilot;
    private ArrayList<CabinCrewMember> cabinCrewMembers;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private Airport destination;
    private Airport departureLocation;
    private String departureTime;

    public Flight(Pilot pilot, Plane plane, String flightNumber, Airport destination, Airport departureLocation, String departureTime) {
        this.pilot = pilot;
        this.cabinCrewMembers = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public ArrayList<CabinCrewMember> getCabinCrewMembers() {
        return cabinCrewMembers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getDepartureLocation() {
        return departureLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }


    public int getNumberOfPassengers() {
        return this.passengers.size();
    }


    public int getNumberOfCrewMembers() {
        return this.cabinCrewMembers.size();
    }

    public int getCapacity(){
        return this.plane.getPlaneType().getCapacity();
    }

    public double getTotalWeight(){
        return this.plane.getPlaneType().getTotalWeight();
    }

    public int numberOfAvailableSeats(){
        return this.getCapacity()-this.getNumberOfPassengers();
    }

    public void addPassenger(Passenger passenger){
        if (this.numberOfAvailableSeats()>0){
            this.passengers.add(passenger);
        }
    }

    public String generateSeatNumber(){
        int num1 = this.getCapacity()-this.getNumberOfPassengers();
        int num2 = this.getCapacity()+this.getNumberOfPassengers();
        return "Seat "+String.valueOf(num1)+String.valueOf(num2);
    }

    public void bookPassenger(Passenger passenger){
        if (this.numberOfAvailableSeats()>0){
            this.addPassenger(passenger);
            passenger.setSeatNumber(this.generateSeatNumber());
            passenger.setFlightNumber(this.flightNumber);
        }
    }
}
