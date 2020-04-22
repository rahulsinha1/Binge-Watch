package edu.northeastern.cs5200.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class MovieReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")
    private String comment;
    private int grade;
    private String movieName;
    private String userName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MovieReview(){}

    public MovieReview(String comment, int grade, String movieName, String userName) {
        this.comment = comment;
        this.grade = grade;
        this.userName = userName;
        this.movieName = movieName;
    }

    public MovieReview(String comment, int grade, String movieName, String userName, Movie movie, User user) {
        this.comment = comment;
        this.grade = grade;
        this.userName = userName;
        this.movieName = movieName;
        this.movie = movie;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
