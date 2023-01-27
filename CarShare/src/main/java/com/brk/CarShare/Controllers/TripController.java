package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Trip;
import com.brk.CarShare.Entities.Vehicle;
import com.brk.CarShare.Services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/all")
    public ResponseEntity<Page<Trip>> getAllTripsPaginated(Pageable pageable) {
        return ResponseEntity.ok(tripService.getAllTripsPaginated(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable String id) {return ResponseEntity.ok(tripService.getTripById(id));}
    @PatchMapping("/update")
    public ResponseEntity<Trip> updateTrip(@RequestBody Trip trip){
        tripService.updateTrip(trip);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/getTripsBy")
    public ResponseEntity<List<Trip>> getTripsByStartTimeBetween(String dateFrom, String dateTo){
        return ResponseEntity.ok(tripService.getTripsByStartTimeBetween(dateFrom, dateTo));
    }
}
