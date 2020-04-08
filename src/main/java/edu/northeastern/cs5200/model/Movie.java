package edu.northeastern.cs5200.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;
    @Enumerated(EnumType.STRING)
    private Region region;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int imdbRating;
    private int websiteRating;
    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text") private String StoryLine;
    @Enumerated(EnumType.STRING)
    private AgeRating ageRating;

    public static enum Region{
        NorthAmerica, SouthAmerica, Asia, Europe;
    }
    public static enum Genre{
        ActionOrAdventure,Documentary,Crime,Drama,Fantasy,Thriller,ScienceFiction,Romance,Animation,Horror,War;
    }
    public static enum AgeRating{
        G,PG,PG13,R,NC17;
    }

    public Movie(){}

    
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

        public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getWebsiteRating() {
        return websiteRating;
    }

    public void setWebsiteRating(int websiteRating) {
        this.websiteRating = websiteRating;
    }

    public String getStoryLine() {
        return StoryLine;
    }

    public void setStoryLine(String storyLine) {
        StoryLine = storyLine;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }
}
