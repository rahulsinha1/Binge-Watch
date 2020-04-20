package edu.northeastern.cs5200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
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

  @OneToOne(mappedBy = "streamer")
  private Movie movie;
}
