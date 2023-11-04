package main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "movies")
public class Movie{
    private String title;
    private int movie;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Quote> quotes;

    public Movie(String title,int movie, List<Quote> quotes) {
        this.title = title;
        this.movie = movie;
        this.quotes = quotes;
    }
    public Movie(String title, int movie) {
        this.title = title;
        this.movie = movie;
        this.quotes = new ArrayList<Quote>();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getmovie() {
        return String.valueOf(this.movie);
    }
    public void setmovie(int movie) {
        this.movie = movie;
    }
    
    @Column(name = "title", nullable = false)
    public String getTitle() {
        if(this.title == null){
            return "Movie Title is null";
        }
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Quote> getQuotes() {
        return quotes;
    }
    public void addQuotes(Quote quote) {
        this.quotes.add(quote);
    }
    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }
    
    
    
}
