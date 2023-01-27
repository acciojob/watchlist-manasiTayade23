package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("New Movie Added Successfully",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director dir){
        movieService.addDirector(dir);
        return new ResponseEntity("New Director Added Successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity  addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("dirName") String directorName){
      movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity("New movie-director pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName){
        Movie response= movieService.getMovieByName(movieName);
        return new ResponseEntity(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String dirName){
       Director response= movieService.getDirectorByName(dirName);
        return new ResponseEntity(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>  getMoviesByDirectorName(@PathVariable("director") String dirName){
        List<String> response=movieService.getMoviesByDirectorName(dirName);

        return new ResponseEntity<List<String>>(response,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> response=movieService.findAllMovies();

        return new ResponseEntity(response,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("dirName") String dirName){
        movieService.deleteDirectorByName(dirName);

        return new ResponseEntity(dirName + " removed successfully",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity  deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity("All directors deleted successfully",HttpStatus.ACCEPTED);
    }

}
