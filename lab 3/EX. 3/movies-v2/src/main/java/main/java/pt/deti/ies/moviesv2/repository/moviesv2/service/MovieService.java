package main.java.pt.deti.ies.moviesv2.repository.moviesv2.service;

import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Movie;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Quote;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.repository.MovieRepository;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.repository.QuoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final QuoteRepository quoteRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, QuoteRepository quoteRepository) {
        this.movieRepository = movieRepository;
        this.quoteRepository = quoteRepository;
    }



    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    public Quote updateQuote(Quote quote)  {
        return quoteRepository.save(quote);
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getRandomQuoteByMovieId(Long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
    
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            List<Quote> quotes = quoteRepository.findByShow(movie);
    
            if (!quotes.isEmpty()) {
                Random random = new Random();
                return quotes.get(random.nextInt(quotes.size()));
            }
        }
    
        return null; 
    }
    

    public Quote getQuoteById(Long quoteId) {
        Optional<Quote> optionalQuote = quoteRepository.findById(quoteId);
        return optionalQuote.orElse(null); 
    }
    

public Quote getRandomQuoteRandomMovie() {
    List<Quote> allQuotes = quoteRepository.findAll();
    
    if (!allQuotes.isEmpty()) {
        Random random = new Random();
        int randomIndex = random.nextInt(allQuotes.size());
        return allQuotes.get(randomIndex);
    }
    
    return null;
}

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public Movie updateMovie(Movie movie)  {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

}