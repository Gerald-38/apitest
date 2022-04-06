package com.example.jk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jk.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("catalog")
public class MovieController {
		
		@GetMapping("/home")
		public String getMovies(Model model) {			
			Movie movie = new Movie();
			movie.setDescription("Film d'action");
			movie.setTitle("Transformers");	
			movie.setDuration(120);
			
			Movie movie2 = new Movie();
			movie.setDescription("Film fantastique");
			movie.setTitle("Harry Potter");	
			movie.setDuration(180);
			
			Movie movie3 = new Movie();
			movie.setDescription("Film thriller");
			movie.setTitle("Usual Suspects");
			movie.setDuration(160);
			
			List<Movie> movies = new ArrayList<>();
			movies.add(movie);
			movies.add(movie2);
			movies.add(movie3);			
			
			model.addAttribute("movies", movies);
			
			return "home";			
		}	
		
		@GetMapping("/about")
		public String getAboutpagess() {
				
			
			return "about";
		}
		

}


