package com.cfs.bms.service;

import com.cfs.bms.dto.TheaterRequest;
import com.cfs.bms.entity.City;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repo.CityRepo;
import com.cfs.bms.repo.TheaterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.CharacterIterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepo theaterRepository;
    private final CityService cityService;


    public Theater addTheater(TheaterRequest request)
    {
        City city=cityService.getCityById(request.getCityId());
        Theater theater=Theater.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(city)
                .build();
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters()
    {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(Long id)
    {
        return theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Theater not found with id: "+id));

    }

    public List<Theater> getTheaterByCity(Long cityId)
    {
        return theaterRepository.findByCityId(cityId);
    }
}