package edu.northeastern.cs5200.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Streamer {
  public Streamer() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getStreamingPlatform() {
    return streamingPlatform;
  }

  public void setStreamingPlatform(String streamingPlatform) {
    this.streamingPlatform = streamingPlatform;
  }

  public String getStreamingUrl() {
    return streamingUrl;
  }

  public void setStreamingUrl(String streamingUrl) {
    this.streamingUrl = streamingUrl;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  private String movieName;
  private String streamingPlatform;
  private String streamingUrl;
  private String logoUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private Movie movie;

  public Streamer(String logoUrl, String streamingPlatform, String streamingUrl,String movieName,Movie movie){
    this.logoUrl = logoUrl;
    this.streamingPlatform = streamingPlatform;
    this.streamingUrl = streamingUrl;
    this.movieName = movieName;
    this.movie=movie;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
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

}
