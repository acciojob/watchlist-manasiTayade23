package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> MovieDB=new HashMap<>();
    HashMap<String,Director> DirDB=new HashMap<>();
    HashMap<String , List<String>> movieDirPair=new HashMap<>();

    public void addMovie(Movie movie){
        if(movie == null){
            return ;
        }
        String movieName=movie.getName();
        
        MovieDB.put(movieName,movie);

    }
    public void addDirector(Director director){
        if(director == null){
            return ;
        }
        String dirName=director.getName();
        DirDB.put(dirName,director);
        //return "Added Successfully";
    }
    public void movieDirPair(String movie,String dir){
        if(MovieDB.containsKey(movie) && DirDB.containsKey(dir)){
          MovieDB.put(movie,MovieDB.get(movie));
          DirDB.put(dir,DirDB.get(dir));
          List<String> al=new ArrayList<>();
          if(movieDirPair.containsKey(dir) ) al=movieDirPair.get(dir);
          al.add(movie);
          movieDirPair.put(dir,al);
        }
        //return "Invalid Entry";
    }
    public Movie getMovie(String name){
        return MovieDB.get(name);
    }
    public Director getDir(String name){

        return DirDB.get(name);
    }
    public List<String> getListOfDir(String dirName){
       List<String> al=new ArrayList<>();
       if(movieDirPair.containsKey(dirName)){
           al=movieDirPair.get(dirName);
       }
       return al;
    }
    public List<String> getListOfMovie(){
       return new ArrayList<>(MovieDB.keySet());
    }
    public void deleteByDir(String dirName){
        List<String> movieal=new ArrayList<>();
        if(movieDirPair.containsKey(dirName)){
            movieal=movieDirPair.get(dirName);
            for(String movies:movieal){
                if(MovieDB.containsKey(movies)){
                    MovieDB.remove(movies);
                }
            }
        }
    }
    public void deleteAll(){
       HashSet<String> movieSet=new HashSet<>();
       for(String dir:movieDirPair.keySet()){
           for(String movie:movieDirPair.get(dir)){
                movieSet.add(movie);
           }
       }
       for(String movie:movieSet){
           if(MovieDB.containsKey(movie)){
               MovieDB.remove(movie);
           }
       }
    }

}
