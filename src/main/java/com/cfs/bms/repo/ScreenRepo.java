package com.cfs.bms.repo;

import com.cfs.bms.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepo extends JpaRepository<Screen,Long> {

    List<Screen> findByTheaterId(Long theaterId);
}