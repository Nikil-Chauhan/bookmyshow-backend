package com.cfs.bms.service;

import com.cfs.bms.entity.Screen;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repo.ScreenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepo screenRepository;
    private final TheaterService theaterService;

    //addscreen
    public Screen addScreen(Screen screen){
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreen()
    {
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id)
    {
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id: "+id));

    }

    public List<Screen> getScreenByTheater(Long theaterId)
    {
        return screenRepository.findByTheaterId(theaterId);
    }
}