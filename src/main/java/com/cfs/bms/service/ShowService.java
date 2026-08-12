package com.cfs.bms.service;

import com.cfs.bms.dto.ShowRequest;
import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Screen;
import com.cfs.bms.entity.Show;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repo.ShowRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepo showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    //addshow
    public Show addShow(ShowRequest request)
    {
        Movie movie =movieService.getMovieById(request.getMovieId());
        Screen screen=screenService.getScreenById(request.getScreenId());
        Show show=Show.builder()
                .movie(movie)
                .screen(screen)
                .showDate(request.getShowDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .ticketPrice(request.getTicketPrice())
                .build();

        return showRepository.save(show);
    }

    public List<Show> getAllShow()
    {
        return showRepository.findAll();
    }
    public Show getShowById(Long id)
    {
        return showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Show not found with id: "+id));

    }

    public List<Show> getShowByMovie(Long movieId)
    {
        return showRepository.findByMovieId(movieId);
    }

    public List<Show> getShowByMovieAndDate(Long movieId, LocalDate date)
    {
        return showRepository.findByMovieIdAndShowDate(movieId,date);
    }

    //getShowByScreen
    public List<Show> getShowByScreen(Long id){
        return showRepository.findByScreenId(id);
    }
}