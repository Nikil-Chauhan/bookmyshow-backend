package com.cfs.bms.controller;

import com.cfs.bms.entity.Screen;
import com.cfs.bms.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    private ResponseEntity<Screen> addScreen(@RequestBody Screen screen){
        return ResponseEntity.ok(screenService.addScreen(screen));
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens()
    {
        return ResponseEntity.ok(screenService.getAllScreen());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id)
    {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>>  getScreenByTheaterId(@PathVariable Long theaterId)
    {
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }
}