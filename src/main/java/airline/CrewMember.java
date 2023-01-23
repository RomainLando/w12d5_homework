package airline;

public abstract class CrewMember {

    private String name;
    private Rank rank;

    public CrewMember(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return this.name;
    }

    public Rank getRank() {
        return this.rank;
    }
}
