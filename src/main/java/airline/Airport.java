package airline;

public enum Airport {
    EDI("Edinburgh"),
    GLA("Glasgow"),
    BFS("Belfast"),
    MAN("Manchester");

    private final String city;

    Airport(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
