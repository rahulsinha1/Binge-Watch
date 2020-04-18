package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.servlet.OmdbWebServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Repository
public class MovieMethodsImpl implements MovieMethodsDao{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    @GetMapping("/api/movies")
    public List<Movie> findAllMovies() {
        return(List<Movie>) movieRepository.findAll();
    }

    @Override
    @RequestMapping("/api/movies/find")
    public Movie findMovie(@RequestParam String name) {
        Movie movie = findFromDB(name);
        if(movie==null){
            name = name.replaceAll(" ","%20");
            return findFromOMDB(name);
        }
        return movie;
    }


    private Movie findFromDB(@RequestParam String name) {
        Movie movie = movieRepository.findFromDB(name);
        return movie;
    }
    private Movie findFromOMDB(String name) {
        String response = OmdbWebServiceClient.searchMovieByTitle(name, "60f0ee17");
        if (response != null) {
            Gson gson = new Gson();
            Map<String, Object> map = new HashMap<>();
            map = gson.fromJson(response, map.getClass());           //import com.google.gson.Gson;
            Movie.Type type = null;
            String movie_name = new String(), genre = null, rated = null, country = null, runtime = null, director = null, storyLine = null;
            String poster = null;
            int year = 0;
            double imdbrating = 0;

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getKey().matches("Title")) {
                    movie_name = (String) entry.getValue();
                }
                if (entry.getKey().matches("Type")) {
                    type = Movie.Type.valueOf((String) entry.getValue());
                }
                if (entry.getKey().matches("Genre")) {
                    genre = (String) entry.getValue();
                }
                if (entry.getKey().matches("Rated")) {
                    rated = (String) entry.getValue();
                }
                if (entry.getKey().matches("Year")) {
                    year = Integer.valueOf((String) entry.getValue());
                }
                if (entry.getKey().matches("Country")) {
                    country = (String) entry.getValue();
                }
                if (entry.getKey().matches("Runtime")) {
                    runtime = (String) entry.getValue();
                }
                if (entry.getKey().matches("Director")) {
                    director = (String) entry.getValue();
                }
                if (entry.getKey().matches("Plot")) {
                    storyLine = (String) entry.getValue();
                }
                if (entry.getKey().matches("imdbRating")) {
                    imdbrating = Double.valueOf((String) entry.getValue());
                }
                if (entry.getKey().matches("Poster")){
                    poster = (String)entry.getValue();
                }

//                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
            Movie movie = new Movie(movie_name, type, genre, rated, year, imdbrating, country, runtime, director, storyLine,poster);
            movieRepository.save(movie);
            return movie;
        }
        return null;
    }

}
