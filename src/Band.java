public class Band {

    private char genre;

    private String bandName;
    private int fans;
    private int maxFans;
    private int fameLevel;
    private int xP;
    private double money;
    private boolean isActive;
    private Repertoire repertoire;

    //Konstruktør (opretter band med repetoire)
    Band(String bandName, char genre){
        this.bandName = bandName;
        this.fans = 1000;
        this.maxFans = 5000;
        this.fameLevel = 1;
        this.xP = 10;
        this.money = 4200.0;
        this.isActive = true;
        this.repertoire = new Repertoire();
        this.genre = genre;
    }

    //todo: band name print, Addfans, losefans, level up, addMoney, loseMoney, !isActive,

    public void gainFans(int amount){
        fans += amount;
        if (fans > maxFans){
            fans = maxFans;
        }
    }
    public void loseFans(int amount){
        fans -= amount;
        if (fans < 0){
            fans = 0;
        }
        isLoosingRelevance();
        isActive();
    }
    boolean isActive(){
        if (fans == 0){
            bandHasBrokenUp();
            return false;
        }
        return true;
    }
    void addXP(int amount){
        xP += amount;
        levelUp();
    }
    void earnMoney(double amount){
        money += amount;
    }
    boolean spendMoney(double amount){
        if (money >= amount){
            money -= amount;
            System.out.println("Transaction successful!");
            return true;
        } else {
            System.out.println("Not enough money... womp womp");
            return false;
        }
    }

    public void addSongToRepertoire(Song song){
        repertoire.addSong(song);
    }
    public void removeSongFromRepertoire(String title){
        Song song = repertoire.getSongByName(title);
        if (song != null){
            repertoire.removeSong(song);
            System.out.println("Song: " + title + " has been removed from repertoire.");
        } else {
            System.out.println("Song does not exist.");
        }

    }

    void levelUp(){
        if (xP >= (2000*fameLevel)){
            System.out.println("LEVEL UP!");
            maxFans += maxFans * fameLevel;
            fameLevel++;
            xP = 0;
            System.out.println(getStatusTitle());
        }
    }
    String getStatusTitle(){
        switch (fameLevel) {
            case 1 ->{ return "Level 1: \"Unknown - Playing in garages\""; }
            case 2 ->{ return "Level 2: \"Local Hero - Small venues await\""; }
            case 3 ->{ return "Level 3: \"Festival invitations coming up!\""; }
            case 4 ->{ return "Level 4: \"Mainstream - Arena tours possible\""; }
            case 5 ->{ return "Level 5: \"Superstar - Stadium glory!\""; }
            default ->{ return "You have exceeded the boundaries and transcended humanity."; }
        }
    }

    public void bandHasBrokenUp(){
        System.out.println("The band has broken up...");
        switch (genre){
            case 'R' -> System.out.println("Guess the real rock n' roll was the friends we made along the way...");
            case 'E' -> System.out.println("Back to the bedrooms buckos! Those YouTube house mixes wont make themselves!");
            case 'H' -> System.out.println("Try again, surely one day your rhymes will gain some rhythm, this just wasn't the day.");
            case 'P' -> System.out.println("Fame hits the one in a million, you just weren't Sombr in this case...");
            default -> System.out.println("Invalid Genre.");

        }
    }


    //Getters and setters
    public double getFanPercentage(){
        return ((double) fans / maxFans) * 100;
    }
    public String getBandGenre(){
        switch (genre){
            case 'R' -> { return "(Rock)"; }
            case 'E' -> { return "(Electronic)"; }
            case 'H' -> { return "(HipHop)"; }
            case 'P' -> { return "(Pop)"; }
            default -> { return null; }
        }
    }
    public int getFans(){
        return fans;
    }

    public int getAttendance(Venue venue){
        int capacity = venue.getVenueCapacity();
        int attendance;
        int attendancePicker = (int) (Math.random() * 4);
        switch (attendancePicker){
            case 1 -> attendance = capacity/100 * 90;
            case 2 -> attendance = capacity/100 * 75;
            case 3 -> attendance = capacity/100 * 55;
            case 4 -> attendance = capacity/100 * 40;
            default -> attendance = capacity/100 * 25;
        }
        return attendance;
    }

    public void printBandRepertoire(){
        System.out.println("\"" + bandName + "\" repertoire: ");
        repertoire.printAllSongs();
        System.out.println(" ");
    }
    public Song getIndividualSong(String songName){
        return repertoire.getSongByName(songName);
    }

    //checks
    public boolean isLoosingRelevance(){
        boolean loosingRelevance;
        double fanPercentage = getFanPercentage();
        if (fanPercentage < 25.0 && fans != 0){
            System.out.println("\n//WARNING: Losing relevance! Consider a comeback strategy!//\n");
            loosingRelevance = true;
        } else {
            loosingRelevance = false;
        }
        return loosingRelevance;
    }

    //toString
    @Override
    public String toString(){
        return "\n=== " + bandName.toUpperCase() + " " + getBandGenre() + " ===\nFame " + getStatusTitle() + " | Fans: " + fans + "/" + maxFans + " | Money: $" + money + "\n";
    }

    //actions

    public void playGig(Venue venue) {
        System.out.println("\n"+bandName + " plays at " + venue);
        int attendancePercent = getAttendance(venue) / (venue.getVenueCapacity() / 100);
        if (attendancePercent >= 80 && attendancePercent <= 100) {
            System.out.println("Great turnout!\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + fans + " -> " + (fans + (venue.getVenueCapacity()/100*40)));
            System.out.println("XP: " + xP + " -> " + (xP + 100 * fameLevel));
            gainFans(venue.getVenueCapacity()/100*40);
            addXP(100 * fameLevel);
        } else if (attendancePercent < 80 && attendancePercent >= 60) {
            System.out.println("Successful gig.\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + fans + " -> " + (fans + (venue.getVenueCapacity()/100*25)));
            System.out.println("XP: " + xP + " -> " + (xP + 75 * fameLevel));
            gainFans(venue.getVenueCapacity()/100*25);
            addXP(75 * fameLevel);
        } else if (attendancePercent < 60 && attendancePercent >= 45) {
            System.out.println("Could have been better.\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + fans + " -> " + (fans + (venue.getVenueCapacity()/100*15)));
            System.out.println("XP: " + xP + " -> " + (xP + 50 * fameLevel));
            gainFans(venue.getVenueCapacity()/100*15);
            addXP(50 * fameLevel);
        } else if (attendancePercent < 45 && attendancePercent >= 25) {
            System.out.println("Terrible! Crisis!\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + fans + " -> " + (fans - (venue.getVenueCapacity() / 100 * 15)));
            System.out.println("XP: " + xP + " -> " + (xP + 20 * fameLevel));
            loseFans(venue.getVenueCapacity() / 100 * 15);
            addXP(20 * fameLevel);
        } else if (attendancePercent < 25 && attendancePercent >= 0) {
            System.out.println("Scandal! Noone turned up!\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + fans + " -> " + (fans - (venue.getVenueCapacity() / 100 * 20)));
            System.out.println("XP: " + xP + " -> " + (xP + 10 * fameLevel));
            loseFans(venue.getVenueCapacity() / 100 * 20);
            addXP(10 * fameLevel);
        }
        System.out.println("Money: $" + this.money + " -> $" + (this.money + venue.getPayoutAmount()));
        earnMoney(venue.getPayoutAmount());
    }


    public void compete(Band opponent, Venue venue){
        System.out.println("\"" + bandName + "\" competes against \"" + opponent.bandName + "\"!");
        playGig(venue);
        System.out.println(" ");
        opponent.playGig(venue);

        if (getFans() > opponent.getFans()){
            System.out.println("\n"+bandName + " is dominating the scene!");
        } else {
            System.out.println("\n"+opponent.bandName + " is the crowd favorite!");
        }
    }

    public void buyEquipment(double amount){
        if (spendMoney(amount)){
            System.out.println("\n"+bandName + " buys equipment for gigs!\nMoney: $" + money + "\n");
        } else {
            spendMoney(amount);
        }
    }





}
