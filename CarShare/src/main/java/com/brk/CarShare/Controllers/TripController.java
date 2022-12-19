package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.SupportTicket;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.brk.CarShare.Services.TripService;
import com.brk.CarShare.Entities.Trip;

import java.util.List;

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
    @GetMapping("/getAll")
    public ResponseEntity<List<Trip>> getAllTickets(){return ResponseEntity.ok(tripService.getAllTrips());}
    @GetMapping("/{id}")
    public ResponseEntity getTripById(@PathVariable String id) {return ResponseEntity.ok(tripService.getTripById(id));}
    @PostMapping
    public ResponseEntity updateTrip(@RequestBody Trip trip){
        tripService.updateTrip(trip);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
