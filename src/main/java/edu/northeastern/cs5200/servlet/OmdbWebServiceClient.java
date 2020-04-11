package edu.northeastern.cs5200.servlet;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OmdbWebServiceClient {
    public static final String SEARCH_URL = "http://www.omdbapi.com/?t=TITLE&apikey=APIKEY";


    public static String sendGetRequest(String requestUrl){
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","*/*");
            connection.setRequestProperty("Content-Type","application/json;charset=UTF=8");
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line=buffer.readLine())!=null){
                response.append(line);
            }
            buffer.close();
            connection.disconnect();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
    public static String searchMovieByTitle(String title,String key) {
        String requestUrl = SEARCH_URL
                .replaceAll("TITLE",title)
                .replaceAll("APIKEY",key);
        System.out.println(SEARCH_URL);
        return sendGetRequest(requestUrl);
    }


    }
