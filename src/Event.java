public class Event {

    private String type;
    private String description;
    private int fanImpact;
    private double moneyImpact;

    public Event(String type, String description, int fanImpact, double moneyImpact){
        this.type = type;
        this.description = description;
        this.fanImpact = fanImpact;
        this.moneyImpact = moneyImpact;
    }


}
