package com.example.jk.service;

import com.example.jk.model.Movie;
import com.example.jk.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMovieService {

	@Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(Long id) {
        return movieRepository.findById(id).get();
    }

}