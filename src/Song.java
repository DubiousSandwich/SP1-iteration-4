public class Song {

    private String title;
    private int durationSeconds;
    private int streams;

    Song(String title, int durationSeconds, int streams){
        this.title = title;
        this.durationSeconds = durationSeconds;
        this.streams = streams;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        return "\"" + this.title + "\", Duration: " + this.durationSeconds + " seconds, Streams: " + this.streams;
    }

}
