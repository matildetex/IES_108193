package main.java.pt.deti.ies.moviesv2.repository.moviesv2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Movie;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Quote;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MoviesController{

    private MovieService MovieService;

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return MovieService.getAllQuotes();
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable(value = "id") Long quoteId) {
        Quote quote = MovieService.getQuoteById(quoteId);
        return ResponseEntity.ok().body(quote);
    }

    @PostMapping("/quotes")
    public Quote createQuote(@RequestBody Quote quote){
        return MovieService.createQuote(quote);
    }

    @GetMapping("/quotes/r") // Random Quote From Random Movie
    public ResponseEntity<Quote> getQuoteRandomly() {
        Quote quote = MovieService.getRandomQuoteRandomMovie();
        return ResponseEntity.ok().body(quote);
    }

    @GetMapping("/movies/{id}/quotes/r") // Random Quote From Selected Movie
    public ResponseEntity<Quote> getQuoteRandomlyForMovie(@PathVariable(value = "id") Long movieId) {
        Quote quote = MovieService.getRandomQuoteByMovieId(movieId);
        return ResponseEntity.ok().body(quote);
    }

    @PutMapping("/quotes/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable(value = "id") Long quoteId, @RequestBody Quote quoteDetails) {
        Quote quote = MovieService.getQuoteById(quoteId);
        quote.setmovie(quoteDetails.getmovie());
        quote.setQuote(quoteDetails.getQuote());
        final Quote updatedQuote = MovieService.updateQuote(quote);
        return ResponseEntity.ok(updatedQuote);
    }

    @DeleteMapping("/quotes/{id}")
    public HashMap<String, Boolean> deleteQuote(@PathVariable(value = "id") Long quoteId) {
        MovieService.getQuoteById(quoteId);
        MovieService.deleteQuote(quoteId);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/movies")
    public List<Movie> getAllShows() {
        return MovieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") Long movieId) {
        Movie movie = MovieService.getMovieById(movieId);
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping("/movies")
    public Movie createMovie( @RequestBody Movie movie) {
        return MovieService.createMovie(movie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails) {
        Movie movie = MovieService.getMovieById(movieId);
        movie.setTitle(movieDetails.getTitle());
        final Movie updatedMovie = MovieService.updateMovie(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/movies/{id}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Long movieId) {
        MovieService.getMovieById(movieId);
        MovieService.deleteMovie(movieId);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}