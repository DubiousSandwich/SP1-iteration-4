public class Venue {

    private String name;
    private int capacity;
    private double payoutAmount;

    public Venue(String name, int capacity, double payoutAmount){
        this.name = name;
        this.capacity = capacity;
        this.payoutAmount = payoutAmount;
    }

    public int getVenueCapacity(){
        return this.capacity;
    }

    public double getPayoutAmount(){
        return this.payoutAmount;
    }

    @Override
    public String toString(){
        return "Venue: " + name + " || Capacity: " + capacity + " || Payout: " + payoutAmount;
    }

}
