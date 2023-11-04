package main.java.pt.deti.ies.moviesv2.repository.moviesv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}