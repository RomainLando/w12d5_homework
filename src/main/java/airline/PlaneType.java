package airline;

public enum PlaneType {
    BOEING747(416, 5000),
    BOEING777(314, 4000),
    PRIVATE(2,10);

    private final int capacity;
    private final double totalWeight;

    PlaneType(int capacity, double totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
