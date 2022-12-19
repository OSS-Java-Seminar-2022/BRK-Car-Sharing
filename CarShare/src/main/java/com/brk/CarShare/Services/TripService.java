package com.brk.CarShare.Services;

import com.brk.CarShare.Entities.SupportTicket;
import com.brk.CarShare.Repositories.ITripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brk.CarShare.Entities.Trip;
import com.brk.CarShare.Repositories.ITripRepository;

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
}
