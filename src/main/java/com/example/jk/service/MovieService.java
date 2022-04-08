package com.example.jk.service;

import com.example.jk.model.Movie;
import com.example.jk.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
    
    @PostMapping("/movie")
    public Boolean saveMovie(String title, Integer duration, String description) {
    	Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDuration(duration);
        movie.setDescription(description);
        try {
        	movieRepository.save(movie);
        	return true;
        }catch (Exception e) {
        	System.out.println(e.getLocalizedMessage());
        	return false;
        }
    }
    
      
    
    public Optional<Movie> getMovieById(Long id) {
        Optional<Movie> optionalMovie;

        try {
          optionalMovie = movieRepository.findById(id);
          return optionalMovie;
        } catch (RuntimeException e) {
        	System.out.println(e.getLocalizedMessage());
          return Optional.empty();
        }
    }
    
    public Boolean updateById(Long id, String title, String description, Integer duration) {
        Optional<Movie> optionalMovie;

        try {
          optionalMovie = movieRepository.findById(id);
        } catch (RuntimeException e) {
        	System.out.println(e.getLocalizedMessage());
          return false;
        }

        if (optionalMovie.isEmpty()) {
          return false;
        }

        final Movie movie = optionalMovie.get();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setDuration(duration);

        movieRepository.save(movie);
        return true;
    }    
    
    
    
//    @DeleteMapping("/movies/{id}")
//    public Boolean deleteMovie(@PathVariable Long id) {
//        try {
//            movieRepository.deleteById(id);
//            return true;
//        }catch (RuntimeException e) {
//        	System.out.println(e.getLocalizedMessage());
//        	return false;
//        }
//    }
    
    public Boolean deleteById(Long id) {
        boolean isMovieInDB;

        try {
          isMovieInDB = movieRepository.existsById(id);

          if (!isMovieInDB) {
            return false;
          }

          movieRepository.deleteById(id);
          return true;
        } catch (RuntimeException e) {
        	System.out.println(e.getLocalizedMessage());
          return false;
        }
      }
    
    
}
