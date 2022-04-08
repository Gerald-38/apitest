//package com.example.jk.service;
//
//import com.example.jk.model.Movie;
//import com.example.jk.repository.MovieRepository;
//
//import lombok.extern.slf4j.Slf4j;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Slf4j
//@Service
//public class CreateMovieService {
//
//	@Autowired
//    private MovieRepository movieRepository;
//	
//	@PostMapping("/movie")
//    public Boolean saveMovie(String title, Integer duration, String description) {
//    	Movie movie = new Movie();
//        movie.setTitle(title);
//        movie.setDuration(duration);
//        movie.setDescription(description);
//        try {
//        	movieRepository.save(movie);
//        	return true;
//        }catch (Exception e) {
//        	System.out.println(e.getLocalizedMessage());
//        	return false;
//        }
//    }
//
//}
