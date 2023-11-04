package main.java.pt.deti.ies.moviesv2.repository.moviesv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Movie;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByShow(Movie movie);
}