package com.brk.CarShare.Services;

import com.brk.CarShare.Repositories.ITripRepository;
import com.brk.CarShare.Entities.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TripService {
    private final ITripRepository tripRepository;
    public void addTrip(Trip trip){tripRepository.insert(trip);}
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
    public Trip getTripById(String id){
        return tripRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find trip by ID"));
    }
    public void updateTrip(Trip trip) {tripRepository.save(trip);}
}
