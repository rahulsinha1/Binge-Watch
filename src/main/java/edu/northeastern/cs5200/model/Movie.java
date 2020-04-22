package edu.northeastern.cs5200.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.List;

@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"id", "name"})
)
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double imdbRating;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")
    private String genre;
    private String rated;
    private int year;
    private String country;
    private String runtime;
    private String director;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")
    private String storyLine;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")
    private String poster;

    @OneToMany(mappedBy = "movie",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<MovieReview> movieReviews;

    @OneToMany(mappedBy = "movie",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Streamer> streamers;


    public static enum Type {
        movie, series, episode
    }

    public Movie() {
    }
    public Movie(String name, Type type, String genre, String rated,int year,double imdbRating, String country,String runtime,String director,String storyLine, String poster){
        this.name= name;
        this.type= type;
        this.genre=genre;
        this.rated=rated;
        this.year=year;
        this.imdbRating=imdbRating;
        this.country=country;
        this.runtime=runtime;
        this.director=director;
        this.storyLine=storyLine;
        this.poster=poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<MovieReview> getMovieReviews() {
        return movieReviews;
    }

    public void setMovieReviews(List<MovieReview> movieReviews) {
        this.movieReviews = movieReviews;
    }

    public List<Streamer> getStreamers() {
        return streamers;
    }

    public void setStreamers(List<Streamer> streamers) {
        this.streamers = streamers;
    }
}
