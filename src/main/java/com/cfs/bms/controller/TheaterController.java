package com.cfs.bms.controller;

import com.cfs.bms.dto.TheaterRequest;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    //post add
    @PostMapping("/addTheater")
    private ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest request){
        return ResponseEntity.ok(theaterService.addTheater(request));
    }


    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters()
    {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id)
    {
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId)
    {
        return ResponseEntity.ok(theaterService.getTheaterByCity(cityId));
    }


}