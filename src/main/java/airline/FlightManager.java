package airline;

public class FlightManager {


    public static double calculateAllowedBagWeight(Flight flight){
        return (flight.getTotalWeight()/2)/ flight.getCapacity();
    }

    public static double calculateBookedWeight(Flight flight){
        return calculateAllowedBagWeight(flight)*flight.getNumberOfPassengers();
    }

    public static double calculateRemainingWeight(Flight flight){
        return (flight.getTotalWeight()/2)-calculateBookedWeight(flight);
    }
}
