import java.util.ArrayList;

public class Repertoire {

    private ArrayList<Song> songs;

    public Repertoire(){
        this.songs = new ArrayList<>();
    }

    //todo: addsong method, printsongs, print individual song (toString), assign to band - band HAS A repertoire

    public void addSong(Song song){
        songs.add(song);
        System.out.println("Song: " + song.getTitle() + " added to repertoire!");
    }

    public void printAllSongs(){
        for (Song song : songs){
            System.out.println(song);
        }
    }

}
