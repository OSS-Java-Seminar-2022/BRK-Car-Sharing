package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Trip;
import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {
    @Autowired
    private final TripService tripService;
    @PostMapping("/add")
    public ResponseEntity<String> addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
        return ResponseEntity.ok("Succesfully added trip!");
    }

    @GetMapping("")
    public Page<Trip> getTrips(@RequestParam(value = "searchTerm", required = false) String searchTerm,
                               Pageable pageable) {
        return tripService.findTripsBySearchTerm(searchTerm, pageable);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<Trip>> getAllTripsPaginated(Pageable pageable) {
        return ResponseEntity.ok(tripService.getAllTripsPaginated(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity getTripById(@PathVariable String id) {return ResponseEntity.ok(tripService.getTripById(id));}
    @GetMapping("/getTripsByDate")
    public ResponseEntity<List<Trip>> getTripsByStartTimeBetween(String dateFrom, String dateTo){
        return ResponseEntity.ok(tripService.getTripsByStartTimeBetween(dateFrom, dateTo));
    }

    @PostMapping("/start")
    public ResponseEntity startTrip(@RequestParam String userId, @RequestBody Vehicle vehicle) {
        Trip trip = tripService.startTrip(userId, vehicle);
        return ResponseEntity.ok(trip);
    }

    @PostMapping("/end")
    public ResponseEntity endTrip(@RequestBody Trip trip, @RequestParam List<Double> location) {
        Trip respTrip = tripService.endTrip(trip, location);
        return ResponseEntity.ok(respTrip);
    }
}
