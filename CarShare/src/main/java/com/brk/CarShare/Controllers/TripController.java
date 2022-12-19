package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.SupportTicket;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brk.CarShare.Services.TripService;
import com.brk.CarShare.Entities.Trip;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {
    @Autowired
    private final TripService tripService;
    @PostMapping("/add")
    public ResponseEntity addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
        return ResponseEntity.ok("Succesfully added trip!");
    }
}
