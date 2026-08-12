package com.cfs.bms.repo;

import com.cfs.bms.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepo extends JpaRepository<Show,Long> {

    List<Show> findByMovieId(Long MovieId);
    List<Show> findByScreenId(Long screenId);
    List<Show> findByMovieIdAndShowDate(Long movieId, LocalDate showDate);
    List<Show> findByScreenIdAndShowDate(Long screenId, LocalDate showDate);


}