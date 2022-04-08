package com.example.jk.controller;
import com.example.jk.model.Movie;
import com.example.jk.repository.MovieRepository;
//import com.example.jk.service.CreateMovieService;
//import com.example.jk.service.GetMovieService;
import com.example.jk.service.MovieService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("catalog")
public class MovieController {
	
	private final String REDIRECT_HOME = "redirect:/catalog/home";

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private MovieService movieService;
    
    
    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movies", movies);
        return "home";
    }    
    
    
    @PostMapping("/movie")
    public String saveMovie(@RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {
       movieService.saveMovie(title, duration, description);
       return "redirect:movies";
    }
    
    
    @GetMapping("/form-update/{id}")
    public String getFormUpdatePage(@PathVariable("id") Long id, Model model) {
      Optional<Movie> optionalMovie = movieService.getMovieById(id);

      if (optionalMovie.isEmpty()) {
        return REDIRECT_HOME;
      }

      model.addAttribute("movie", optionalMovie.get());

      return "form-update";
    }
    
    @PutMapping("/movies/{id}")
    public String update(
      @PathVariable("id") Long id,
      @RequestParam String title,
      @RequestParam String description,
      @RequestParam Integer duration
    ) {
      Boolean isMovieUpdated = movieService.updateById(id, title, description, duration);

      if (!isMovieUpdated) {
        // ...
      }

      return "redirect:/catalog/movies";
    }    
    

//    @DeleteMapping("/movies/{id}")
//    public String deleteById(@PathVariable Long id) {
//        movieService.deleteById(id);
//        return "redirect:movies";
//    }
    

    
    @DeleteMapping("/movies/{id}")
    public String delete(@PathVariable("id") Long id) {
      Boolean isMovieDeleted = movieService.deleteById(id);

      if (!isMovieDeleted) {
        // ...
      }

      return "redirect:/catalog/movies";
    } 
    
}
