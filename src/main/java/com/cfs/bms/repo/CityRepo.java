package com.cfs.bms.repo;

import com.cfs.bms.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepo extends JpaRepository<City,Long> {


}