package example.collection;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import example.collection.Items.Books;
import example.collection.Items.Music;
import example.collection.Items.Media;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    private List<Music> music;

    private List<Books> books;

    private List<Media> media;

    public User() {
        this.books = new ArrayList<>();
        this.media = new ArrayList<>();
        this.music = new ArrayList<>();
    }

    // Parameterized constructor (optional)
    public User(String firstName, String lastName, List<Music> music, List<Books> books, List<Media> media) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.music = music;
        this.books = books;
        this.media = media;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

}
