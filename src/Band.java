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
        this.fans = 500;
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
    }
    public void loseFans(int amount){
        fans -= amount;
        if (fans < 0){
            fans = 0;
        }
        isActive();
    }
    boolean isActive(){
        if (fans == 0){
            return false;
            bandHasBrokenUp();
        }
    }
    void addXP(int amount){
        xP += amount;
        levelUp();
    }

    public void addSongToRepertoire(Song song){
        repertoire.addSong(song);
    }
    public void removeSongFromRepertoire(String title){
        Song song = repertoire.getSongByName(title);
        if (song != null){
            song = null;
            System.out.println("Song: " + title + " has been removed from repertoire.");
        } else {
            System.out.println("Song does not exist.");
        }

    }

    void levelUp(){
        if (xP >= (2000*fameLevel)){
            System.out.println("LEVEL UP!");
            maxFans += 2500 * fameLevel;
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
    public String getBandName(){
        return bandName;
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
    public void printBandRepertoire(){
        System.out.println(bandName + " repertoire: ");
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
            System.out.println("WARNING: Losing relevance! Consider a comeback strategy.");
            loosingRelevance = true;
        } else {
            loosingRelevance = false;
        }
        return loosingRelevance;
    }

    //toString
    @Override
    public String toString(){
        return "=== " + bandName.toUpperCase() + getBandGenre() + " ===\nFame Level: " + fameLevel + " | Fans: " + fans + "/" + maxFans + " | Money: $" + money;
    }





}
