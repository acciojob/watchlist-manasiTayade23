package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepo;

    public void addMovie(Movie movie){
       movieRepo.addMovie(movie);
    }
    public void addDirector(Director dir){
        movieRepo.addDirector(dir);
    }
    public void  addMovieDirectorPair(String movieName,String directorName){
        movieRepo.movieDirPair(movieName,directorName);
    }
    public Movie getMovieByName(String movieName){
        return movieRepo.getMovie(movieName);
    }
    public Director getDirectorByName(String dirName){
        return movieRepo.getDir(dirName);
    }
    public List<String>  getMoviesByDirectorName(String dirName){
        return movieRepo.getListOfDir(dirName);
    }
    public List<String> findAllMovies(){
        return movieRepo.getListOfMovie();
    }
    public void deleteDirectorByName(String dirName){
        movieRepo.deleteByDir(dirName);
    }
    public void  deleteAllDirectors(){
        movieRepo.deleteAll();

    }


}
