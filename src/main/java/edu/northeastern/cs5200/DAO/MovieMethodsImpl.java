package edu.northeastern.cs5200.DAO;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.Streamer;
import edu.northeastern.cs5200.model.User;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.StreamerRepository;
import edu.northeastern.cs5200.repository.UserRepository;
import edu.northeastern.cs5200.servlet.OmdbWebServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Repository
public class MovieMethodsImpl implements MovieMethodsDao {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private StreamerRepository streamerRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @Override
    @GetMapping("/api/movies")
    public List<Movie> findAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }


    @CrossOrigin
    @Override
    @PostMapping("/api/movies/create")          //create movie
    public Movie createMovie(@ModelAttribute Movie movie) {
        movie.setPoster("http://sacobserver.com/wp-content/uploads/2012/08/coming-soon.jpg");
        movieRepository.save(movie);
        return movie;
    }


    @CrossOrigin
    @Override
    @RequestMapping("api/movies/delete")        //delete movie by id
    public void deleteMovie(@RequestParam int id) {
        movieRepository.deleteById(id);
    }


    @CrossOrigin
    @GetMapping("/api/likedBy/{movieName}")
    @Override
    public List<User> getLikedMovie(@PathVariable("movieName")String movieName) {
        Movie movie = movieRepository.findFromDB(movieName);
        List<User> users = userRepository.getUserWithMovie(movie.getId());
        return users;
    }

    @CrossOrigin
    @Override
    @RequestMapping("/api/movies/find")         //find movie by name
    public Movie findMovie(@RequestParam String name) {
        Movie movie = findFromDB(name);
        if (movie == null) {
            name = name.replaceAll(" ", "%20");
            return findFromOMDB(name);
        }
        return movie;
    }

    @CrossOrigin
    @Override
    @RequestMapping("/api/movies/find/id")     //find movie by id
    public Movie findMovieById(@RequestParam int id) {
        return movieRepository.findById(id).get();
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
                if(entry.getKey().matches("Error")){
                    System.out.println("Movie not found!");
                    return null;
                }
                if (entry.getKey().matches("Title")) {
                    movie_name = (String) entry.getValue();
                    if(movie_name == null){
                        System.out.println("no movie found");
                        return null;}
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
            int movie_id = movieRepository.findFromDB(movie_name).getId();
            getStreamingDetails(movie_name, movie);
            return movie;
        }
        return null;
    }

    public void getStreamingDetails(String name, Movie movie) {
        String SEARCH_URL = "https://utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com/lookup?term=TITLE&country=us";
        String requestUrl = SEARCH_URL
                .replaceAll("TITLE",name);
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        String res ="";
        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("x-rapidapi-host", "utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "c47aad3ae8mshe01fe4ddc4771c7p14d6a3jsn9de6d24820a9")
                .build();

        try {
            response = client.newCall(request).execute();
            res = response.body().string();
            Gson gson = new Gson();
            Map<String, Object> map = new HashMap<>();
            map = gson.fromJson(res, map.getClass());
            if(map.size() > 0){
                ArrayList<Object> results = (ArrayList<Object>) map.get("results");
                LinkedTreeMap<String, Object> ltm = (LinkedTreeMap<String, Object>) results.get(0);
                ArrayList<LinkedTreeMap<String, String>> locations = (ArrayList<LinkedTreeMap<String, String>>) ltm.get("locations");
//                        () (map.get("results")).get(0).get("location");
                for (int i = 0; i < locations.size(); i++) {
                    LinkedTreeMap<String, String> loc = locations.get(i);
                    String icon = loc.getOrDefault("icon", "");
                    String platform = loc.getOrDefault("display_name", "");
                    String url = loc.getOrDefault("url", "");

                    Streamer streamer = new Streamer(icon,platform,url, movie.getName(),movie);
                    streamerRepository.save(streamer);
                }
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
