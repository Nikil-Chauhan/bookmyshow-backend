package com.cfs.bms.service;

import com.cfs.bms.entity.Seat;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repo.SeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepo seatRepository;
    private final ScreenService screenService;

    //addSeat
    public Seat addSeat(Seat seat){
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatsByScreen(Long screenId)
    {
        return seatRepository.findByScreenId(screenId);
    }

    public Seat getSeatById(Long id)
    {
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found with id: "+id));

    }
}