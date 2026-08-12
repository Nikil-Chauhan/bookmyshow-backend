package com.cfs.bms.service;

import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repo.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepo movieRepository;

    public Movie addMove(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));

    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }

    //update movie
    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Movie not found with id: " + id));

        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setGenre(updatedMovie.getGenre());
        existingMovie.setLanguage(updatedMovie.getLanguage());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setReleaseDate(updatedMovie.getReleaseDate());

        return movieRepository.save(existingMovie);
    }

    //delete movie
    public void deleteMovie(Long id) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Movie not found with id: " + id));

        movieRepository.delete(existingMovie);
    }
}