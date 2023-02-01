package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip,String>{
    List<Trip> getTripsByStartTimeBetween(String dateFrom, String dateTo);
}
