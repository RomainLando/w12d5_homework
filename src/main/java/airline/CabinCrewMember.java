package airline;

public class CabinCrewMember extends CrewMember{

    public CabinCrewMember(String name, Rank rank) {
        super(name, rank);
    }

    public String announce(){
        return "We hope you enjoy your flight";
    }
}
