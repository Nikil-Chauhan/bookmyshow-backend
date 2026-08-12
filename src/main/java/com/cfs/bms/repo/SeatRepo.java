package com.cfs.bms.repo;

import com.cfs.bms.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Long> {

    List<Seat> findByScreenId(Long screenId);
}