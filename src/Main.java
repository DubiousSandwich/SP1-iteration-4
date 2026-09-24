
void main(){

//todo: menu, menuitemsarraylist, loop, run game, venuearraylist, gig arraylist?

    Band myBand = new Band("The Bandy Band", 'R');
    Band rivalBand = new Band("The Cat Ate My Toe Socks And I'm Not Happy About It", 'E');

    myBand.addSongToRepertoire(new Song("Eclectic Boogaloo",160, 10000));
    myBand.addSongToRepertoire(new Song("The Cats Have Taken Over My Residence",170, 20000));
    myBand.addSongToRepertoire(new Song("I Hate The Way That My Microwave Screams At Me",200, 15000));
    myBand.addSongToRepertoire(new Song("This Is A Song",240, 22000));
    myBand.addSongToRepertoire(new Song("Shock Me Like Electric Eel",246, 12000));
    myBand.addSongToRepertoire(new Song("ooga chaga",2,10));

    myBand.removeSongFromRepertoire("ooga chaga");

    rivalBand.addSongToRepertoire(new Song("We grate our cheese with style",500,30000));
    rivalBand.addSongToRepertoire(new Song("Blues but it is a distinct shade of purple",420,1000));
    rivalBand.addSongToRepertoire(new Song("The shared trauma of our brotherhood ascends the known",120,3000));
    rivalBand.addSongToRepertoire(new Song("Hounds of baskets",300,240000));
    rivalBand.addSongToRepertoire(new Song("The dogs reign supreme",260,12000));

    Venue kbHallen = new Venue("KB hallen", 7000, 2500.0);
    Venue royal = new Venue("Royal Arena", 8000, 6000);
    Venue herning = new Venue("Jyske Bank Boksen", 10000, 10000);
    Venue huset = new Venue("Pumpehuset", 5000, 1500);

    System.out.println(myBand);
    System.out.println(rivalBand);

    myBand.compete(rivalBand,huset);

    myBand.buyEquipment(1500);

    myBand.printBandRepertoire();
    rivalBand.printBandRepertoire();

    System.out.println(myBand);
    System.out.println(rivalBand);

}
