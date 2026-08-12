package com.cfs.bms.repo;

import com.cfs.bms.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie,Long> {

    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    List<Movie> findByTitleContainingIgnoreCase(String title);

}