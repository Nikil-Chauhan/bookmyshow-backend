package com.cfs.bms.repo;

import com.cfs.bms.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TheaterRepo extends JpaRepository<Theater,Long> {

    List<Theater> findByCityId(Long cityId);
}