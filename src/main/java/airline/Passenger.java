package airline;

public class Passenger {

    private String name;
    private int numberOfBags;
    private String seatNumber;
    private String flightNumber;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.seatNumber = "";
        this.flightNumber = "";
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
