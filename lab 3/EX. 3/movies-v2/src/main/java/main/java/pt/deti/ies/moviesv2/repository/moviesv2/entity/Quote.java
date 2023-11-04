package main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie; 

    @Column(name = "quote", nullable = false)
    private String quote;

    public Quote() {}

    public Quote(Movie movie, String quote) { 
        this.movie = movie;
        this.quote = quote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Movie getmovie() {
        return this.movie;
    }

    public void setmovie(Movie movie) {
        this.movie = movie;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
