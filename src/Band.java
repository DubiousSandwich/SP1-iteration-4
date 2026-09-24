public class Band {

    //private char[] genre = {'R','E','H','P'};
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
        this.maxFans = 10000;
        this.fameLevel = 1;
        this.xP = 10;
        this.money = 4200.0;
        this.isActive = true;
        this.repertoire = new Repertoire();
        this.genre = genre;
        /*switch (genre){
            case 'r' -> genre = this.genre[0];
            case 'e' -> genre = this.genre[1];
            case 'h' -> genre = this.genre[2];
            case 'p' -> genre = this.genre[3];
        }*/
    }

    //todo: band name print, Addfans, losefans, level up, addMoney, loseMoney, !isActive,




}
