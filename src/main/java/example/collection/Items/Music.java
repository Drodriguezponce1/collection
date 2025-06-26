package example.collection.Items;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "music")
public class Music extends Item{

    @Id
    private String id;

    private String title, artist, genre, format, image;
    private int year, runtime, tracks;

    public Music(){
        super();
    }

    public Music(String title, String artist, String genre, String format, String image, int year, int runtime,
            int tracks) {
                super();
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.format = format;
        this.image = image;
        this.year = year;
        this.runtime = runtime;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }
    
}
